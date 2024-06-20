Zootopia-
The implemented java program manages the zoo compromising of various classes such as Attraction,Admin,Visitor etc. which helps to run various functions for Admins and visitors.This project was made in Intellij using Maven.
ADMIN 1 -
username - Zoey01
password - Z123
ADMIN 2 - 
username - Jack01
password - J123

In this Home folder(main) is in Src folder and jar file is in tagert folder.
*Assumptions Made: *
1. At starting all the attractions are set to be closed.
2. At the starting it compromises of 6 hardcoded animals (2 belonging to each categorgy-Mammal, Amphibian, Reptile).
3. At starting it also comprises of 2 harcoded special Deals.
4. At the beginning the, prices of Attraction are setted to be zero , the admin have to set the price in Scheduled events for the attractions.
5. Visitor does not have any prior membership , he/she have to purchase any of the two(Basic/Premium) membership to visit Attractions or Animals.
6. Categories are case sensitive , such that while adding animal you should enter Mammal and if mammal typed it will not add.

At Beginning you have 3 options with you-
1. Enter as Admin
2. Enter as Visitor
3. Show special deals

Entering as Admin will ask you to enter Admin's username as well as password , if they both are correct it will give access to you otherwise will show Invalid Admin Details.
Functions Provided to you when entered as admin by Selecting 1 and entering details-
Admin Menu:
1. Manage Attractions
2. Manage Animals
3. Schedule Events
4. Set Discounts
5. Set Special Deal
6. View Visitor Stats
7. View Feedback
8. Exit(Back to the Beginning)

Entering as Visitor will further show two option:
1.Register(Allow new member Registration)
2.Login

Login will allow you to enter Visitor's Email -id as well as password , if he/she entered them corrctly it will login otherwise show a message Invalid Details.
Functions provided to you when Logged in as a Visitor:
Visitor Menu:
1. Explore the Zoo
2. Buy Membership
3. Buy Tickets
4. View Discounts
5. View Special Deals
6. Visit Animals
7. Visit Attractions
8. Leave Feedback
9. Log Out(Logged out for Visitor)
 
HANDLING OF ERRORS:
One functions is defined in Zoo class Getint which is
used to check the inputs given by user .
Such that where int variables are defined and user gives some another input such as string so it will diplsay Invalid input and ask the user to 
enter again.
Some conditions are just implemented such as while registring a new member if user inputs age less then or equals to 0 it will show Invalid Input as well as same is done for the balance such that if user enters negative balance it will show Invalid input.

ABOUT CLASSES IMPLEMENTED IN PROGRAMS:
1. Abstract class Animal
   classes Mammal , Amphibian and Reptiles class      Animal.
Private Attributes-
id - Id have been given to each animal for easy use
Name - Animal Name
Type - Can only be of type Mammal,Amphibian and Reptile
Sound - sound of animal
Description - some lines about that animal

A constructor was made which sets id,Name,Type,Sound and description of a animal.

2. class Admin
Private Attributes-
Username and password
Only 2 Admins are created as specified above

3. class SpecialDeal
Private Attributes-
Attractioncount-On how many tickets to apply discount
discount - sets discount percentage
id - assigned by system for easier use

4. class Discount
Private Attributes-
percentage - to be applied on membership
DisCode - Discount code
Category - whether minor or senior

5. class Attraction
Private Attributes-
id - Attraction ID
name - name of attraction
description - what the attraction does.
price - charges of attraction
ticketsold - counts the solded tickets
status - whether close or open

6. class Visitor
name , age , Phonenumber , balance , mail , password 
and a List of buyed ticket.

7. class Feedback
Just a single attribute specifying the feedback to be added.

8. abstract class membership
Two classes are extending this class which are generally named Basic and Premium to specify about whether the membership is Basic or Premium.

9. class ZOO
In this class list of all other clsses are made , and all the private functions are implemented in this class which are used in main. Excepting some functions which are implemented in Visitor class such as buytickets and buymemberhsip.

ABOUT INTERFACES IMPLEMENTED
1.interface discount
Two functions-
1. void buyticket();
2. void applydiscount();

2.interface FeedbackInterface
Two functions-
1. void setFeedback(String s);
2. String getfeedback();

3. interface visitor
Three functions-
1. int buyticket(int id , double price , int percentage);
2.int visitattraction(int id);
3.void buymembership(int id , int discountpercentage , int minororsenior);

EXITING THE CODE-
There is no way of exiting the code as tasked us in Assignment , we can only come back to the menu where a one can gets the three options left which are specified above , which are where you can enter as vistor or admin or can have special Deals.