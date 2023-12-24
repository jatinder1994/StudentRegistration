package FinalProject;

import java.util.List;

import Beans.ClassesBean;

public interface CourseInterface {
	public List<ClassesBean> getCourses();
	public String enrollClass(String ssn, String courseID, String grade);
	public String dropClass(String ssn, String courseID);


}
