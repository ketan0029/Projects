Library Management system - The implemented java program manages the
library compromising of three classes Book ,Members and library which
helps to run various functions for librarian and member.This project was
made in Intellij using maven.

At just starting you can enter as i) Librarian ii) Member

functions provided to you when entered as Librarian by selecting option
1 : i) Register a member ii) Remove a member iii)Add a book iv)Remove a
book v)View all members along with their book and fine vi)view all books
vii)Back(to the interface where you can enter an librarian , member or
exit)

functions provided to you when entered as a member by selecting option 2
:

When entering as a member Code will ask you for your name and registered
phone number , if they both are coorect as per the registered member it
will give you access for the member functions and otherwise it will show
no member exist for the given name and phone number.

i)List Available books ii)List my books(borrowed one) iii)Issue a book
iv)Return a book v)Pay fine(Imposed if book is not returned within 10
days i.e within 10 sec acc. to code) vi)Back

HANDLING OF ERROR: Some conditions are just implemented where the input
have been taken such as while taking a phone number as input so it is
checked whether it is of 9 or 10 digits or not , if not it will display
Invalid phone number by using chechp function of library class, and in
case of age it is defined that it cannot be less the and equal to 0 and
can\'t be greater then 130.

Two functions are defined in Library class Getint and Getlong which are
used to check the inputs given by user . Such that where int variables
are defined and user gives some another input such as string so it will
diplsay Invalid input and ask the user to enter again. Various error
handling were made acc. to instrucions given such as for books tha a
member can issue atmost two books at a time , Cannot issue second book
if fine was imposed on the first one by borrowBook function of Member
class. For member class you cannot register two members for same contact
number.

If user has not issued any book and it clicks option 5 i.e Payfine then
pf function of member class will display that No fine is there.

Name could be anything for example - Ayush -1 , Ayush -2 Maximum Age is
setted to 130.

ABOUT CLASSES IMPLEMENTED IN PROGRAM

Book class\-- private attributes:

bt- borrowing time bID - Book Id title - name of book author - author of
book TC - total copies of book rt - return time of the book

A constructor was made which sets Book id , title , author , total
copies of the book.

Member class - Private attributes:

fi - determine fine on member Id - Member Id name - Name of the member
age - Age of member pn - Phone Number of maember BB - list of type class
Book (Borrowed books of a member)

A constructor was made which sets name , age , phone number , Id of the
member.

Public Function implemented -  1. borrowBook - Helps a member to issue a
book by taking the book to be issued as a parameter. 2. listbook - lists
te book borrowed by a member 3. retb - Helps a member to return a book
by taking Book to be returned as a parameter and also calculates penalty
from borrowint time to the time function is called. 4.updatef - Updates
a fine for a member for the book given as a parameter from the borrowing
time to the time function is called. 5.pf - helps in paying fine if
imposed on member 6.tfine - gives the totl fine imposed on a member
7.checks - Check whether the book of given Id by user is present in
borrowed book list of member or not. 8. rb -return book by taking id as
an input.

Library class - Various static int type variables are defined to have a
track on Id\'s and some return type function to check existence. Two
list are defined - 1.BOOK - this is a list of class type Book , keeps
the record of the books in Library. 2.MEM - this is a list of type class
Member , keeps the record of the registered member in library.

Public functions implemented -  1. Addbook - helps in Adding the book to
library by taking Name , author , and total copies of the book and
assigns Id to the book by increasing value of defined static variable
zz. 2.enterasmem - Helps a member to get access of the library by taking
name and phone number as a parameter and returns a(1 if member is
registered and both input given are correct otherwise 0) 3.removebook -
Helps in removing book from library by taking Id of the book to be
removed as a parameter. 4.removemem - Helps in removing member from
library by taking Id of member to be removed as a parameter.
5.listbook - Lists the available books in library. 6.listmem - Lists the
registered member in library along with borrowed books and fine.
7.registermem - Registered the member in library by taking name , age
and phone number as a parameter.

Various other function are implemented in library to check , return
member , return book and to have good feasibility of code.

EXITING THE CODE To exit the program choose option 3 from main interface
, It will display Thanks for visiting . There is no another way of
exiting the program , if user gives invalid input for different
specified variables then it will show invalid input instead of
terminating it.
