package studentfolder;

import java.util.List;


public interface student {
	int addstudent(student_mod student);
	int updatestudent(student_mod student);
	int deletestudent(int id);
	List<student_mod> getAllstudent();

}
