from flask import Flask, render_template, request, redirect, url_for, send_from_directory
import mysql.connector
from flask import Flask, jsonify, request

app = Flask(__name__)
cart=[]
item_image_map={
    'television':'Image/Televisions.jpg',
    'laptop':'Image/Laptop.jpg',
    'phone':'Image/Mobile.jpg',
    'headphone':'Image/Headphones.jpg',
    'robots':'Image/Robots.jpg',
    'fridge':'Image/Fridges.jpg',
    'loudspeaker':'Image/LoudSpeaker.jpg',
    'air_conditioner':'Image/Airconditions.jpg'
}

def perform_purchase_transaction(username, purchase_amount):
    try:
        # Connect to the database
        conn = connect_to_database()
        cursor = conn.cursor()

        # Deduct the purchase amount from the user's bank account
        cursor.execute("UPDATE user_bank_account SET balance = balance - %s WHERE username = %s", (purchase_amount, username))

        # Add the same amount to the store's account
        cursor.execute("UPDATE store_account SET balance = balance + %s", (purchase_amount,))

        # Commit the transaction
        conn.commit()

        # Close cursor and database connection
        cursor.close()
        conn.close()

        return True  # Transaction successful
    except Exception as e:
        print("Error performing transaction:", e)
        return False  # Transaction failed


# Route to handle the purchase transaction
@app.route('/purchase', methods=['POST'])
def purchase():
    try:
        # Extract data from request
        username = request.json['username']
        product_type = request.json['product_type']
        quantity = request.json['quantity']

        # Calculate the total purchase amount
        conn = connect_to_database()
        cursor = conn.cursor()
        cursor.execute("SELECT price FROM products WHERE product_type = %s", (product_type,))
        price = cursor.fetchone()[0]
        total_amount = price * quantity

        # Perform the purchase transaction
        if perform_purchase_transaction(username, total_amount):
            # If transaction successful, update product stock, clear cart, and return success response
            # Add your code to update product stock and clear cart here
            return jsonify({"message": "Purchase successful"}), 200
        else:
            return jsonify({"error": "Failed to process the transaction"}), 500

    except Exception as e:
        print("Exception occurred:", e)
        return jsonify({"error": "Failed to process the transaction"}), 500





# MySQL database configuration
db_config = {
    'host': 'localhost',
    'user': 'root',
    'password': 'root',
    'database': 'hel'
}

# Function to connect to MySQL database
def connect_to_database():
    try:
        conn = mysql.connector.connect(**db_config)
        print("Database connected successfully")
        return conn
    except mysql.connector.Error as err:
        print("Error connecting to database:", err)
        return None

# Function to check if a user exists in the database
def check_user_exists(username):
    conn = connect_to_database()
    cursor = conn.cursor()
    sql = "SELECT * FROM login WHERE username = %s"
    cursor.execute(sql, (username,))
    user = cursor.fetchone()
    cursor.close()  
    conn.close()
    return user

# Route for the registration form
@app.route('/', methods=['GET'])
def registration_form():
    return render_template("register.html")

# Route to handle form submission for registration
@app.route('/', methods=['POST'])
def register():
    name = request.form['name']
    username = request.form['username']
    password = request.form['password']
    contact = request.form['contact']
    if check_user_exists(username):
        return "Username already exists. Please choose another username."

    # Connect to the database
    conn = connect_to_database()
    cursor = conn.cursor()
    print("working")
    # Insert user data into the database
    sql = "INSERT INTO register (name, username, password, contact_number) VALUES (%s, %s, %s, %s)"
    val = (name, username, password, contact)
    cursor.execute(sql, val)
    conn.commit()

    # Insert user data into the database
    sql = "INSERT INTO login (username, password) VALUES (%s, %s)"
    val = (username, password)
    cursor.execute(sql, val)
    conn.commit()


    # Close database connection
    cursor.close()
    conn.close()

    return redirect(url_for('registration_success'))

# Route to show registration success message
@app.route('/success')
def registration_success():
    return render_template('success.html')

# Route for login page
@app.route('/login',  methods=['GET'])
def login_form():
    return render_template('login.html')

# Route to handle form submission for login
@app.route('/login', methods=['POST','PUT'])
def login():
    username = request.form['username']
    password = request.form['password']
    print("works")
    # Check if the user exists in the database
    user = check_user_exists(username)
    if(user==None):
        return redirect(url_for('/'))
    print(user)
    if(password!=user[1]):
        conn=connect_to_database()
        cur=conn.cursor()
        cur.execute("UPDATE login SET login_attempt=login_attempt+1 WHERE username=%s",(username,))
        conn.commit()
        print(user)
        if(user[3] == 'blocked'):
            return redirect(url_for('blocked',username=username))
        else:
            return render_template('login.html')
    if user and user[1] == password and user[3] == 'allowed':
        conn=connect_to_database()
        cur=conn.cursor()
        cur.execute("UPDATE login SET login_attempt=0 WHERE username=%s",(username,))
        conn.commit()
        return redirect(url_for('website'))
    else:
        return redirect(url_for('/'))  # Redirect to registration page if user not registered

# Route to show login success message

@app.route('/blocked/<username>',methods=['GET','PUT'])
def blocked(username):
    if(request.method == 'PUT'):
        print("put is working")
        conn=connect_to_database()
        cur=conn.cursor()
        cur.execute("UPDATE login SET status=%s WHERE username=%s",('allowed',username,))
        n_string="select * from login where username=%s"
        cur.execute(n_string,(username,))
        print(cur.fetchone())
        conn.commit()
    return render_template('blocked.html', username=username)

def enforce_password_policy(password):
    if len(password) < 8:
        return False, "Password must be at least 8 characters long"
    return True, "Password meets the policy requirements"

@app.route('/update_password', methods=['POST'])
def update_password():
    data = request.json
    password = data.get('password')

    is_valid, message = enforce_password_policy(password)

    if is_valid:
        # Update password in the database
        # Add your database update logic here
        return ({'success': True, 'message': 'Password updated successfully'})
    else:
        return ({'success': False, 'error':message})


@app.route('/website',methods=['GET'])
def website():  
    return render_template('website.html')

get_price="select price from product where product_type=%s"

@app.route('/phone',methods=['GET','POST'])
def phones():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('phone',))
            price = cur.fetchone()
            item={
                'name':'phone',
                'price':float(price[0]),
                'quantity': quantity
            }
            print(item)
            cart.append(item)
    return render_template('phone.html')

@app.route('/headphone',methods=['GET','POST'])
def headphones():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('headphone',))
            price = cur.fetchone()
            item={
                'name':'headphone',
                'price':float(price[0]),
                'quantity': quantity
            }
            print(item)
            cart.append(item)             
    return render_template('headphone.html')

@app.route('/robots',methods=['GET', 'POST'])
def robots():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('robots',))
            price = cur.fetchone()
            item={
                'name':'robots',
                'price':float(price[0]),
                'quantity': quantity
            }
            cart.append(item)
    return render_template('robots.html')

@app.route('/fridge',methods=['GET', 'POST'])
def fridge():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('fridge',))
            price = cur.fetchone()
            item={
                'name':'fridge',
                'price':float(price[0]),
                'quantity': quantity
            }
            cart.append(item)
    return render_template('fridge.html')

@app.route('/loudspeaker',methods=['GET', 'POST'])
def speaker():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('loudspeaker',))
            price = cur.fetchone()
            item={
                'name':'loudspeaker',
                'price':float(price[0]),
                'quantity': quantity
            }
            cart.append(item)
    return render_template('loudspeaker.html')

@app.route('/television',methods=['GET', 'POST'])
def televison():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('television',))
            price = cur.fetchone()
            item={
                'name':'television',
                'price':float(price[0]),
                'quantity': quantity
            }
            cart.append(item)
    return render_template('television.html')

@app.route('/ac',methods=['GET', 'POST'])
def ac():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('air_conditioner',))
            price = cur.fetchone()
            item={
                'name':'air_conditioner',
                'price':float(price[0]),
                'quantity': quantity
            }
            cart.append(item)
    return render_template('ac.html')

@app.route('/laptop',methods=['GET', 'POST'])
def laptop():
    if(request.method == 'POST'):
        quantity = int(request.form['quantity'])
        if quantity > 0:
            conn=connect_to_database()
            cur=conn.cursor()
            cur.execute(get_price,('laptop',))
            price=cur.fetchone()
            item={
                'name':'laptop',
                'price':float(price[0]),
                'quantity': quantity
            }
            cart.append(item)
    return render_template('laptop.html')

@app.route('/cart',methods=['GET', 'PUT'])
def view_cart(cart=cart):
    if(request.method == 'PUT'):
        print("put is working")
        cart_body=request.get_json()
        query="UPDATE product SET stock=stock-%s WHERE product_type=%s "
        conn = connect_to_database()
        cursor=conn.cursor()
        for item in cart_body:
            print("in the loop")
            cursor.execute(query,(item['quantity'],item['name']))
            print("query executed")
        conn.commit()
        cart.clear()
        return redirect(url_for('website'))
    return render_template('cart.html',cart=cart,item_image_map=item_image_map)

if __name__ == '_main_':
    app.run(debug=True,port=3000)