# crudoperationsjava

# CRUD Student Management system 

This project is a simple web application for managing student information. It fetch student data and Store in Local Database. It allows users to view a list of students, add new student, edit existing student details, delete student.

## Features

- **students List**: View a list of all Students with their details such as name, dob, address, email, and phone number.
- **Add Students**: Add a new student to the system by providing their details.
- **Edit student**: Modify existing customer information.
- **Delete student**: Remove a student from the system.

## Technologies Used

- **Java**: Backend logic is implemented using Java.
- **Servlets**: Handle HTTP requests and responses.
- **HTML/CSS**: For styling and structuring the web pages.
- **MySQL Database**: Store customer information.
- **Tomcat Server**: Used as the servlet container to deploy the application.

## Getting Started

1. **Create Local Database**:
    ```sql
    CREATE DATABASE studentdatabase;
    ```

2. **Create Customer Table**:
    ```sql
   CREATE TABLE student (
   `id` INT NOT NULL,
   `name` VARCHAR(45) NOT NULL,
   `dob` VARCHAR(45) NOT NULL,
   `email` VARCHAR(45) NOT NULL,
   `age` INT NOT NULL,
   `phone` BIGINT(10) NOT NULL,
   `address` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
    ```

**To run this project locally, follow these steps**:
   
1. Download the CRUD Student Management system and import it into Eclipse IDE.
   
2. Run the application by navigating to the index and selecting "Run on Server".
   
3. Access the application through [http://localhost:8080/SunbaseProject/index.jsp](http://localhost:8080/SunbaseProject/index.jsp)
   
  ![page1]![Screenshot 2024-07-20 200945](https://github.com/user-attachments/assets/0f46cbd3-2fbd-4731-8ed8-c912c7c506f3)
4. View the student list by clicking the "view".
   
  ![page2] ![Screenshot 2024-07-20 202402](https://github.com/user-attachments/assets/86a9c0cd-857e-43b9-8040-75160ee5bba6)
5. Click the "veiw" button to fetch the latest student data and store it locally.
    
6. Add a new customer by clicking the "Insert" button and filling out the provided form.

7. Edit the details of an existing sutdent by clicking the "Edit" link next to the customer's information.
8. Delete a student by clicking the "Delete" link .




