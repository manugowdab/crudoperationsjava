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
   
3. Access the application through [http://localhost:8080/SunbaseProject/index.jsp](http://localhost:8080/SunbaseProject/index.jsp)
   
  ![page1]![Screenshot 2024-07-20 200945](https://github.com/user-attachments/assets/0f46cbd3-2fbd-4731-8ed8-c912c7c506f3)
4. View the student list by clicking the "view".
   
  ![page2] ![Screenshot 2024-07-20 202402](https://github.com/user-attachments/assets/86a9c0cd-857e-43b9-8040-75160ee5bba6)
5. Click the "veiw" button to fetch the latest student data and store it locally.
    
6. Add a new customer by clicking the "Insert" button and filling out the provided form.

7. Edit the details of an existing sutdent by clicking the "Edit" link next to the customer's information.
8. Delete a student by clicking the "Delete" link .


Above java code order:

Project Structure:

-student1/src/main/java/studentfolder

1. student_mod.java(Model Class)
   
public class student_mod {
	private int id;
	private String name;	
	private String dob;
	private String email;
	private int age;
	private long phone;
	private String address;
	public student_mod(int id, String name, String dob, String email, int age, long phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.address = address;	
	}
	public student_mod(String name, String dob, String email, int age, long phone, String address) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString()
	{
		return "student_mod [id=" + id + ", name=" + name + ", dob=" + dob + ", email="
				+ email + ", age=" + age +", phone="+ phone + ", address=" + address  + "]";	
	}
}


   2. student.java(Interface of Data Access object)


import java.util.List;
public interface student {
	int addstudent(student_mod student);
	int updatestudent(student_mod student);
	int deletestudent(int id);
	List<student_mod> getAllstudent();
}


3. Student_imp.java(implemention of Data Access object)


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Student_imp implements student{
	String url="jdbc:mysql://127.0.0.1:3306/studentdatabase";
	String un="root";
	String pswd="pass";
	private Connection connection;
	String insert_q="insert into student(id,name, dob, email, age, phone, address) VALUES(?,?,?,?,?,?,?)";
	String select_q="select * from student";
	String Update_q="update student set name=? ,dob=?, email=?, age=?, phone=? ,address=? where id=?";
	String delete_q="delete from student where id=?";
	public Student_imp()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url, un, pswd);
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public int addstudent(student_mod student) {
			try {
				PreparedStatement pstm = connection.prepareStatement(insert_q);
				pstm.setInt(1, student.getId());
				pstm.setString(2,student.getName());
				pstm.setString(3,student.getDob());
				pstm.setString(4,student.getEmail());
				pstm.setInt(5, student.getAge());
				pstm.setLong(6,student.getPhone());
				pstm.setString(7, student.getAddress());
				int i=pstm.executeUpdate();
				return i;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}
	@Override
	public int updatestudent(student_mod student) {
		try {
			PreparedStatement pstm = connection.prepareStatement(Update_q);
			pstm.setString(1,student.getName());
			pstm.setString(2,student.getDob());
			pstm.setString(3,student.getEmail());
			pstm.setInt(4, student.getAge());
			pstm.setLong(5,student.getPhone());
			pstm.setString(6, student.getAddress());
			pstm.setInt(7, student.getId());
			int i=pstm.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deletestudent(int id) {
		// TODO Auto-generated method stub
		int i;
		try {
			PreparedStatement pstm = connection.prepareStatement(delete_q);
			pstm.setInt(1, id);
			 i=pstm.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -2;
	}
	@Override
	public List<student_mod> getAllstudent() {
		// TODO Auto-generated method stub
		List<student_mod> al=new ArrayList<student_mod>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet res = stmt.executeQuery(select_q);
			while(res.next())
			{
				int id= res.getInt(1);
				String name=res.getString(2);
				String dob=res.getString(3);
				String email=res.getString(4);
				int age=res.getInt(5);
				long phone=res.getLong(6);
			    String address=res.getString(7);
				student_mod user=new student_mod(id,name, dob, email, age, phone, address);
				al.add(user);	
			}
			return al;	
		} catch (SQLException e) {
			// TODO Auto-genedrated catch block
			e.printStackTrace();
		}
		return al;
	}
}


   
4. studentdetails.java(Server connection and business logic):


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/studentdetails")
public class studentdetails extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String email=req.getParameter("email");
		int age=Integer.parseInt(req.getParameter("age"));
		Long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String action = req.getParameter("action");
		student_mod stud=new student_mod(id,name,dob,email,age,phone,address);
		Student_imp st=new Student_imp();
		 PrintWriter pw = resp.getWriter();	
		 if(action.equals("insert"))
		 {
			int i= st.addstudent(stud);
			if(i==1)
			{
				pw.print(i+ " row inserted successfully");
			}
			else
			{
				pw.print("insertion error");
			}
		 }
		 else if(action.equals("retrive")) 
			{
				List<student_mod> al= st.getAllstudent();
				pw.print("<table border='1'>");
				pw.print("<tr>");
				pw.print("<th>Id</th>");
				pw.print("<th>Name</th>");
				pw.print("<th>Dob</th>");
				pw.print("<th>Email</th>");
				pw.print("<th>Age</th>");
				pw.print("<th>Phone</th>");
				pw.print("<th>Address</th>");
				pw.print("<tr>");
				for(student_mod x:al)
				{
					int sid=x.getId();
					String sname=x.getName();
					String sdob=x.getDob();
					String semail=x.getEmail();
					int sage=x.getAge();
					Long sphone=x.getPhone();
					String saddress=x.getAddress();
					pw.print("<tr>");
					pw.print("<td>"+sid+"</td>");
					pw.print("<td>"+sname+"</td>");
					pw.print("<td>"+sdob+"</td>");
					pw.print("<td>"+semail+"</td>");
					pw.print("<td>"+sage+"</td>");
					pw.print("<td>"+sphone+"</td>");
					pw.print("<td>"+saddress+"</td>");
					pw.print("</tr>");
				}
				pw.print("</table>");
			 }
		 else if(action.equals("update"))
		 {
			 int i=st.updatestudent(stud);
			 if(i==1)
			 {
			pw.print(i+ " row updated successfully");
			 }
			 else
			 {
				 pw.print( "data does't exit, some error occur");
			 }
		 }
		 else if(action.equals("delete"))
		 {
			 int i=st.deletestudent(id);
			 if(i==1)
			 {
				 pw.print(i+ " row deleted successfully");
			 }
			 else
			 {
				 pw.print( "data does't exit, some error occur");
			 } 
		 }
	}
}



HTML code:

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="regi.css">
    <title>register page</title>
</head>
<body>
     <form action="studentdetails" method="post">  
        <div class="login">
            <div class="admin"><h1>REGISTER</h1></div>
        </div>
        <br>
        <div class="details">
            Stud_Id : <br> <input type="number" name="id" required><br><br>	
            NAME : <br> <input type="text" name="name" required><br><br>
            DOB  : <br> <input type="date" name="dob" required><br><br>
            EMAIL : <br> <input type="email" name="email"  required pattern="[^ @]+@[^ @]+.[a-z]{2,}"> <br><br>
            PHONE : <br> <input type="number" name="phone"  required pattern="[6-9]{1}[0-9]{9}"> <br><br>
            AGE : <br> <input type="number" name="age" required><br><br>
            ADDRESS : <br> <input type="text" name="address"  required> <br><br>
        </div>
        <div class="submit">
           <button name="action" value="insert">Insert</button>
	       <button name="action" value="retrive">View</button>
	       <button name="action" value="update">Edit</button>
	       <button name="action" value="delete">Delete</button>
        </div>
     </form>
</body>
</html>


CSS code:

@charset "UTF-8";
* body {
    background: #222D32;
    font-family: 'Roboto', sans-serif;
}
form
{
    background-color: #1A2226;
    margin-top: 100px;
    margin-left: 300px;
    width: 50%;
    height: 700px ;	
    border-radius: 10px;
}
form .login-key
{
    background-color: aliceblue;
}
div.login{
    text-shadow: 2px 2px 4px#3bde5e;        
    color: azure;
    padding-top: 20px;
    padding-left: 225px;
}

div.details
{
    padding-left: 50px;
    color: #6C6C6C;
    letter-spacing: 1px;    
    font-weight: bold;
    font-size: 10px;
    box-shadow: 0 0 0;
}

.details input
{
    padding-top: 10px;
    background-color: #1A2226;
    color: aliceblue;
    font-size: 20px;
    outline: 0px;
    border: none;
    border-bottom: 2px solid aqua;
    width: 500px;
    padding-bottom: 5px;
}
.submit
{
    background-color: #1A2226;
    display: flex;
    padding-Left:15px;
}
.submit button
{
    margin-top: 30px;
    margin-left: 35px;
    border-color: #0cbbe2;
    background-color: #1A2226;
    height: 30px;
    width: 100px;
    color: #0cbbe2;
    border-radius: 2px;
    font-weight: bold;
    letter-spacing: 1px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}
.submit button:hover {
    background-color: #0DB8DE;
    color: white;
    right: 0px;
}



