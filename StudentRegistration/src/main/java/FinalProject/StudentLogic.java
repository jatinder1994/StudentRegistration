package FinalProject;

import Beans.Student;
import DBUtils.DBUtil;

public class StudentLogic  implements StudentInterface{

	@Override
	public Student getStudent(String ssn) {
		DBUtil dbUtil = new DBUtil();
		return dbUtil.getStudentInfo(ssn);
		
	}
	

}
