-- Create database hel
CREATE DATABASE IF NOT EXISTS hel;

-- Use database hel
USE hel;

-- Create register table
CREATE TABLE IF NOT EXISTS register (
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    contact_number VARCHAR(20) NOT NULL
);

-- Insert data into register table
INSERT INTO register (name, username, password, contact_number)
VALUES
    ('Christopher Taylor', 'chris_taylor', 'ChR1s_T@yl0r', '8765432109'),
    ('David Miller', 'david.miller', 'D@v1dM1ll3r_', '7890123456'),
    ('Emily Johnson', 'emily.johnson', 'E@J0hnson123', '9876543210'),
    ('Jennifer Wilson', 'jennifer.wilson', 'J3nn1f3rW1ls0n!', '2345678901'),
    ('Jessica Martinez', 'jessica.martinez', 'J3ss!c@M@rt1n3z', '3216540987'),
    ('John Smith', 'john_smith', 'J0hnSm1th!', '1234567890'),
    ('Michael Davis', 'michael_davis', 'M1ch@3lD@v1s', '5551234567'),
    ('Sarah Brown', 'sarah_brown', '$@r@hBr0wn2022', '4567890123');

-- Create login table
CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    login_attempt INT NOT NULL DEFAULT 0,
    status VARCHAR(255) NOT NULL CHECK (status IN ('allowed', 'blocked')),
    FOREIGN KEY (username) REFERENCES register(username)
);


-- Inserting data into the login table
INSERT INTO login (username, password, login_attempt, status)
VALUES
    ('chris_taylor', 'ChR1s_T@yl0r', 0, 'allowed'),
    ('david.miller', 'D@v1dM1ll3r_', 0, 'allowed'),
    ('emily.johnson', 'E@J0hnson123', 0, 'allowed'),
    ('jennifer.wilson', 'J3nn1f3rW1ls0n!', 0, 'allowed'),
    ('jessica.martinez', 'J3ss!c@M@rt1n3z', 0, 'allowed'),
    ('john_smith', 'J0hnSm1th!', 0, 'allowed'),
    ('michael_davis', 'M1ch@3lD@v1s', 0, 'allowed'),
    ('sarah_brown', '$@r@hBr0wn2022', 0, 'allowed');


-- Create products table
CREATE TABLE IF NOT EXISTS products (
    product_type VARCHAR(100) PRIMARY KEY,
    m_id CHAR(8) NOT NULL,
    stock DOUBLE NOT NULL,
    price INT NOT NULL DEFAULT 0
);

-- Insert data into products table
INSERT INTO products (product_type, m_id, stock, price)
VALUES
    ('air_conditioner', 'm5N6oP7Q', 700,599.99),
    ('fridge', 'R8sT9uVW', 700,799.99),
    ('headphone', 'XyZ1A2B3', 700,99.99),
    ('laptop', 'c4DE5fG6', 700,799.99),
    ('loudspeaker', 'H7iJ8kL9', 700,149.99),
    ('phone', 'm0nOPqR1', 700,699.99),
    ('robots', 'S2tU3vWx', 700,499.99),
    ('television', 'P2Q3r4S5', 700,599.99);
CREATE TABLE USER (
    Sno INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    items_purchased INT,
    item_name VARCHAR(255),
    product_id INT,
    rate DECIMAL(10, 2),
    total DECIMAL(10, 2) GENERATED ALWAYS AS (items_purchased * rate) STORED
);


-- Create user_bank_account table
CREATE TABLE IF NOT EXISTS user_bank_account (
    username VARCHAR(255) PRIMARY KEY,
    balance DECIMAL(10,2) NOT NULL DEFAULT 0
);

-- Create store_account table
CREATE TABLE IF NOT EXISTS store_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10,2) NOT NULL DEFAULT 0
);

-- Start the transaction
BEGIN;

-- Deduct the purchase amount from the customer's bank account
UPDATE user_bank_account
SET balance = balance - purchase_amount
WHERE username = '<customer_username>';

-- Add the same amount to the store's bank account
UPDATE store_account
SET balance = balance + purchase_amount;

-- Commit the transaction to save changes
COMMIT;


-- Start a transaction
START TRANSACTION;

-- Update the mode of payment for a specific user
UPDATE register
SET payment_mode = 'new_payment_mode'
WHERE username = 'specific_username';

-- Update the address for a specific user
UPDATE register
SET address = 'new_address'
WHERE username = 'specific_username';

-- Update the contact number for a specific user
UPDATE register
SET contact_number = 'new_contact_number'
WHERE username = 'specific_username';

-- Commit the transaction if all updates are successful
COMMIT;

-- Rollback the transaction if any update fails
ROLLBACK;
START TRANSACTION;

-- Update the user's bank account balance with the additional amount.
CREATE TABLE IF NOT EXISTS user_bank_account (
    username VARCHAR(255) PRIMARY KEY,
    balance DECIMAL(10,2) NOT NULL DEFAULT 0
);

-- Insert a record into the transactions table to keep a log of the transaction.
INSERT INTO transactions (user_id, transaction_type, amount, transaction_date)
VALUES (user_id, 'Credit', amount_to_add, NOW());

COMMIT;

START TRANSACTION;

-- Update the user's bank account balance with the additional amount.
UPDATE user_bank_account
SET balance = balance + amount_to_add
WHERE user_id = user_id;

-- Insert a record into the transactions table to keep a log of the transaction.
INSERT INTO transactions (user_id, transaction_type, amount, transaction_date)
VALUES (user_id, 'Credit', amount_to_add, NOW());

COMMIT;

CREATE TABLE IF NOT EXISTS feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    product_id INT NOT NULL,
    rating INT NOT NULL,
    comment TEXT,
    submission_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (username) REFERENCES register(username)
);
START TRANSACTION;

INSERT INTO feedback (user_id, product_id, rating, comment, submission_date)
VALUES (user_id,product_id, rating, '<comment>', NOW());

COMMIT;

CREATE TABLE delivery_status (
    username VARCHAR(50),
    delivery_status VARCHAR(100),
    FOREIGN KEY (username) REFERENCES register(username)
);
START TRANSACTION;
SELECT status
FROM parcels
WHERE parcel_id = parcel_id 
FOR UPDATE;

UPDATE parcels
SET status = 'Canceled'
WHERE parcel_id = parcel_id AND status = 'Pending';
UPDATE orders
SET status = 'Canceled'
WHERE order_id = (
    SELECT order_id
    FROM parcels
    WHERE parcel_id = parcel_id
);

COMMIT;
START TRANSACTION;

SELECT status
FROM parcels
WHERE parcel_id = parcel_id
FOR UPDATE;


UPDATE parcels
SET status = 'Canceled'
WHERE parcel_id = parcel_id AND status = 'Pending';

COMMIT;
START TRANSACTION;
SELECT status
FROM parcels
WHERE parcel_id = parcel_id
FOR UPDATE;

UPDATE parcels
SET status = 'Canceled'
WHERE parcel_id = parcel_id AND status = 'Pending';

COMMIT;



START TRANSACTION;

SELECT quantity
FROM products
WHERE product_id = product_id
FOR UPDATE;

UPDATE products
SET quantity = quantity - 1
WHERE product_id = product_id AND quantity > 0;

COMMIT;
START TRANSACTION;

SELECT quantity
FROM products
WHERE product_id = product_id
FOR UPDATE;

UPDATE products
SET quantity = quantity - 1
WHERE product_id = product_id AND quantity > 0;

COMMIT;