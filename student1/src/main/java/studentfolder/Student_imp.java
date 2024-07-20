package studentfolder;

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
