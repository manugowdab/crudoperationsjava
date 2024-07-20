package studentfolder;

public class dend {
	
	public static void main(String[] args)
	{
		student_mod st = new student_mod(7,"kiran","6-1-2002","manoj@ram.com",23,80812225,"hoskote");
		Student_imp sm = new Student_imp();
	
		System.out.println(sm.updatestudent(st));
		
		
	}

}
