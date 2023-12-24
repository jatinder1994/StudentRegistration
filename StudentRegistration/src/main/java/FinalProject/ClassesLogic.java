package FinalProject;

import java.util.ArrayList;
import java.util.List;

import Beans.ClassesBean;
import DBUtils.DBUtil;

public class ClassesLogic implements CourseInterface{
	private  List<ClassesBean> list2 = new ArrayList<ClassesBean>();
	@Override
	public List<ClassesBean> getCourses() {
		DBUtil dbUtil = new DBUtil();
		list2 = dbUtil.getCourses();
		return list2;
	}
	@Override
	public String enrollClass(String ssn, String courseID, String grade) {
		DBUtil dbUtil = new DBUtil();
		if(dbUtil.registerClass(ssn, courseID, grade)=="Success") {
			return "Success";
		}else {
		return "Fail";}
	}
	@Override
	public String dropClass(String ssn, String courseID) {
		DBUtil dbUtil = new DBUtil();
		if(dbUtil.dropClass(ssn, courseID)=="Success") {
			return "Success";
		}else {
		return "Fail";}
	}
	

}
