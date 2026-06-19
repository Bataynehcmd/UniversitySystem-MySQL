# University System - MySQL

A Java console application that simulates a simple University Management System using JDBC and MySQL.

## Features

### User Management

* Add User
* View All Users
* Search User by ID
* Update User Information
* Delete User

### Course Registration

* Register Course for Student
* View Student Courses
* Remove Course from Student

## Database Design

### Users Table

Stores all system users.

Fields:

* id
* name
* mail
* usertype

### Courses Table

Stores available university courses.

Fields:

* course_code
* course_name

### Student Courses Table

Manages the relationship between students and courses.

Fields:

* student_id
* course_code

## Technologies Used

* Java
* JDBC
* MySQL
* IntelliJ IDEA
* Git & GitHub

## Concepts Practiced

* Object-Oriented Programming (OOP)
* JDBC Database Connectivity
* PreparedStatement
* ResultSet
* CRUD Operations
* Foreign Keys
* Composite Primary Keys
* One-to-Many Relationships
* Many-to-Many Relationships

## Project Structure

* Main.java
* DatabaseConnection.java
* User.java
* Student.java
* Teacher.java
* Admin.java
* Loginable.java
* Course.java

## Future Improvements

* Course Management CRUD
* Teacher Course Assignment
* Authentication System
* Spring Boot Migration
* Web Interface (HTML, CSS, JavaScript)
* REST API Development

## Author

Ahmed Bataineh
