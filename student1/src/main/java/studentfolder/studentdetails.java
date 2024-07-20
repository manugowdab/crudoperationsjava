package studentfolder;

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
