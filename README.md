# CRUD Student Management system 

This project is a simple web application for managing student information. It fetch student data and Store in Local Database. It allows users to view a list of students, add new student, edit existing student details, delete student.

## Features

- *students List*: View a list of all Students with their details such as name, dob, address, email, and phone number.
- *Add Students*: Add a new student to the system by providing their details.
- *Edit student*: Modify existing customer information.
- *Delete student*: Remove a student from the system.

## Technologies Used

- *Java*: Backend logic is implemented using Java.
- *Servlets*: Handle HTTP requests and responses.
- *HTML/CSS*: For styling and structuring the web pages.
- *MySQL Database*: Store customer information.
- *Tomcat Server*: Used as the servlet container to deploy the application.

## Getting Started

1. *Create Local Database*:
    sql
    CREATE DATABASE studentdatabase;
    

2. *Create Customer Table*:
    sql
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
    

*To run this project locally, follow these steps*:
   
1. Download the CRUD Student Management system and import it into Eclipse IDE.
   
2. Run the application by navigating to the index and selecting "Run on Server".
   
3. Access the application through [http://localhost:8080/SunbaseProject/index.jsp](http://localhost:8080/student1/regis.html)]
   
  [page1]![Screenshot 2024-07-20 200945](https://github.com/user-attachments/assets/0f46cbd3-2fbd-4731-8ed8-c912c7c506f3)
4. View the student list by clicking the "view".
   
  [page2] ![Screenshot 2024-07-20 202402](https://github.com/user-attachments/assets/86a9c0cd-857e-43b9-8040-75160ee5bba6)
5. Click the "veiw" button to fetch the latest student data and store it locally.
    
6. Add a new customer by clicking the "Insert" button and filling out the provided form.

7. Edit the details of an existing sutdent by clicking the "Edit" link next to the customer's information.
8. Delete a student by clicking the "Delete" link .


Above java code order:

Project Structure:

-student1/src/main/java/studentfolder

1. student_mod.java(Model Class)
   
   ![Screenshot 2024-11-19 095032](https://github.com/user-attachments/assets/5c1c6c77-94ee-4844-9476-3eb924d56c3e)
   ![Screenshot 2024-11-19 095136](https://github.com/user-attachments/assets/f1f974cd-a4a9-4eee-a5a4-8416bb0207f1)



2. student.java(Interface of Data Access object)

    ![Screenshot 2024-11-19 095519](https://github.com/user-attachments/assets/804d1278-4f2a-4367-bd39-ee60e4478963)


3. Student_imp.java(implemention of Data Access object)
   
   ![Screenshot 2024-11-19 100127](https://github.com/user-attachments/assets/88e03f05-651e-4778-959a-ac27e9b0cab9)
   ![Screenshot 2024-11-19 100226](https://github.com/user-attachments/assets/c051d42d-cf8e-44d5-9540-6045c9fe70e7)
   ![Screenshot 2024-11-19 100422](https://github.com/user-attachments/assets/9c5fd15a-7b1d-40c5-bf2d-f2d810bf685d)

4. studentdetails.java(Server connection and business logic):

![Screenshot 2024-11-19 100731](https://github.com/user-attachments/assets/fb52846b-7e58-4619-9b16-b03e53bf0647)
![Screenshot 2024-11-19 100801](https://github.com/user-attachments/assets/26367135-2a10-4e6b-badc-7b52bd7a7904)
![Screenshot 2024-11-19 100817](https://github.com/user-attachments/assets/dbf8f9cd-dd72-4e11-99af-3bb397385499)

web.xml:

![Screenshot 2024-11-19 101114](https://github.com/user-attachments/assets/d6b3da30-d36a-4c3c-898d-986da6792529)



HTML code:

![Screenshot 2024-11-19 101143](https://github.com/user-attachments/assets/bd234755-6543-4d51-82c2-984979549af4)

 

CSS code:

![Screenshot 2024-11-19 101223](https://github.com/user-attachments/assets/79ae3928-55da-48e0-909a-507d0a9774cf)
![Screenshot 2024-11-19 101251](https://github.com/user-attachments/assets/1e234920-be79-4922-acdb-cad78021f32d)


