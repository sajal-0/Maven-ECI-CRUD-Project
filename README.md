
##ECI Management System

The ECI Management System is a Java-based application for managing and retrieving election candidate information.<br> It offers features to add, delete, update, and query candidate records with various criteria, making it useful for election management and analysis.


## Table Content

- Project Structure

- Features

- Technologies

- Usage









## Project Structure

This project is organized into the following packages:

- com.tka.eci.entity
  Contains the Candidate class, representing a candidate with properties like ID, name, party, state, assembly, etc.

- com.tka.eci.dao
  Contains ECAdao, which handles all database operations using JDBC, such as retrieving, inserting, updating, and deleting records.

- com.tka.eci.service
  Contains ECIservice, providing business logic to filter and process data fetched from the DAO.

- com.tka.eci.controller
  Contains ECIcontroller, which serves as an intermediary between the client and service layers, handling user requests and responses.

- com.tka.eci.client
  Contains ECIclient, the main entry point with a command-line interface for interacting with the application.

  
## Features

- Add Candidate: Insert new candidate records into the database.
- Delete Candidate: Remove a candidate by ID.
- Update Candidate: Update candidate information based on ID.
- View All Candidates: Retrieve and display all candidates in a tabular format.
- Filter Candidates:
By party, assembly, state-party combination, gender, age, and status.
- Accepted Candidate Count by Assembly: Count candidates with "Accepted" status by a specific assembly.

## Technologies
Java: Core programming language used to build the application.
JDBC: To connect and interact with a SQL database.
SQL Database: Stores all candidate data for retrieval and modification.

## Usage

Run ECIclient.java in your IDE or from the command line. <br>You will see an interactive menu allowing you to choose options to perform various operations on the candidate records.<br> The data is displayed in a user-friendly tabular format.

  
1. View All Candidates
2. Add Candidate
3. Delete Candidate by ID
4. Update Candidate by ID
5. List Candidates by Party
6. List Candidates by Assembly
7. List Candidates by State and Party
8. List Candidates by Gender
9. List Candidates by Age
10. List Candidates by Status
11. Count Accepted Candidates by Assembly
12. Exit



