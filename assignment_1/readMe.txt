1) What does the program do
The program takes a xml file from the user reads all of its contents and maps the query id's to query structures.
The user can then use those structed queries with a appropriate object with the required variables. The program then generates the required SQL query and executes it.

2) How to compile
->Clone the repository to the local machine.
->Open the SqlLibTest file at location /lib/src//test/java/assignment1
->Update the username and password in the Test Class;
->Open CMD and run "gradle build" this assembles and tests the library against predetermined testcases.
->If you wish to edit the testcases, please make changes to the SqlLibTest.java file at /lib/src//test/java/assignment1