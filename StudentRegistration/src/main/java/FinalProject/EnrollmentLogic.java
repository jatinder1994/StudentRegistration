package FinalProject;

import java.util.ArrayList;
import java.util.List;

import Beans.EnrollBean;
import DBUtils.DBUtil;

public class EnrollmentLogic implements EnrollmentInterface{
	
	private  List<EnrollBean> list = new ArrayList<EnrollBean>();

	@Override
	public List<EnrollBean>  getEnrollment(String ssn) {
		DBUtil dbUtil = new DBUtil();
		list = dbUtil.getEnrollInfo(ssn);
		return list;
	}
	
	
	
	

}
