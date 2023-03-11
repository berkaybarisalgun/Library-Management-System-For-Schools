# Library-Management-System-For-Schools
 Library Management System For Schools<br>
 ## Introduction:
The Library Management System for Schools is a desktop application that streamlines the process of managing school libraries. With this application, librarians can easily store and view information about books, magazines, and other library materials, as well as track the circulation of these items.<br>

## Key Features:
Catalog Management: Store and view information about books, magazines, and other library materials.<br>
Circulation Management: Track the removal, return, and renewal of library materials and record borrowing history.<br>
Reporting: Generate reports on the usage of library materials and provide visually understandable information to librarians.<br>

## Technologies Used:
Backend: Java<br>
Frontend: Java Swing<br>
Database: Mysql<br><br>

## Usage:

I added the database files to the project, if you don't know how to install them before you start, you can follow the database setup steps below.<br>
In general, you can run the application from the login class to run the project.<br>
Use the catalog management feature to store and view information about library materials.<br>
Remember that you must first register as a librarian to take action. Then you can register as a student by giving the student the registration number.<br>
Use the circulation management feature to track the removal, return, and renewal of library materials.<br>
When you register with the student, it is sufficient to write only a certain part of the name of the book you want,example ->(to kill a mockingbird) ->(mock) is sufficient.<br>
You can access transactions related to students and book borrowing when you log in as a librarian.<br>
Use the reporting feature to generate reports on the usage of library materials.<br>

## Database setup

To use the database provided in this project, you will need to create a new database and import the SQL commands that are provided.<br>

To create a new database, you will need to use a database management system (DBMS) such as MySQL or PostgreSQL.<br>

Next, you will need to import the SQL commands that are provided in this project. The SQL file is located in the database folder. To import the file, you will need to use the import tool in your DBMS. This tool is usually accessible from the DBMS's graphical user interface (GUI) or through the command line interface (CLI).<br>

Once the SQL file has been imported, you should be able to access the database and use it for your own purposes. To access the database, you will need to use the login credentials that you have set up in your DBMS.<br>

It's important to note that the process of importing a database can vary depending on the specific DBMS you are using, Feel free to write to me if you encounter any problems. My [Linkedin](https://www.linkedin.com/in/barisalgun/) account is here for you.
<br>


## Changelog

### v1.0.0(2023-02-06)
- Fixed a bug where the application was crashing when opening certain files<br>
- Improved code readability by using descriptive variable names and adding comments where necessary

### v1.0.1(2023-02-07)
- Captcha feature added to the application to enhance security and prevent automated spam

### v1.0.2(2023-02-12)
- The error in sorting by registration number in the Loan details section has been fixed
- New sorting by book name has been added

### v1.0.3(2023-02-14)
- Required database files have been added to use the project.

