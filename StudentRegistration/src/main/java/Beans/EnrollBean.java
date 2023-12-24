package Beans;

public class EnrollBean {
final private String courseID, title, grade;
	
	public EnrollBean(String courseID, String title, String grade)
	{
		this.courseID = courseID;
		this.title = title;
		this.grade = grade;
	}
	
	public String getCourseID() {
		return courseID;
	}

	public String getTitle() {
		return title;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "<tr><td>" + courseID +"</td><td>"+ title +
			"</td><td>" + grade +"</td></tr>";
	}
	
	
	

}
