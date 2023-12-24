package DBUtils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.ClassesBean;
import Beans.EnrollBean;
import Beans.Student;

public class DBUtil {
	
    private static Connection connection;

	
	public static void connectToDatabase(){
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    System.out.println("Driver loaded");
		    try {
				connection = DriverManager.getConnection
						("jdbc:mysql://database-cuny.c4piq2ndsfvh.us-west-1.rds.amazonaws.com:3306/CUNY_DB" , "cst4713", "password1");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		System.out.print("connected");	
		}
	
	 public static void closeConnection() {
	       
	            try {
					if (connection != null && !connection.isClosed()) {
					    connection.close();
					    System.out.println("Connection closed");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } 
	
	 
	 public Student getStudentInfo(String ssn) {
		 Student student = null;
		 connectToDatabase();
		 try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM "
						+ "Students WHERE ssn = ?");
				preparedStatement.setString(1, ssn);

				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					student = new Student(resultSet.getString(1), 
							resultSet.getString(2), 
							resultSet.getString(3), 
							resultSet.getString(4), 
							resultSet.getString(5), 
							resultSet.getString(6), 
							resultSet.getString(7), 
							resultSet.getString(8), 
							resultSet.getString(9));
					return student;
				}

				preparedStatement.close();
				resultSet.close();
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	 }
	 public List<EnrollBean> getEnrollInfo(String ssn) {
		 connectToDatabase();
		 List<EnrollBean> enrollList = new ArrayList<EnrollBean>();
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT Course.courseID, Course.title, Enrollment.grade "
						+ "FROM Course, Enrollment "
						+ "WHERE Enrollment.courseId = Course.courseID and Enrollment.ssn = ? "
						+ "ORDER BY Course.title");
			 preparedStatement.setString(1, ssn); 
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while (resultSet.next()) {
					enrollList.add(new EnrollBean(resultSet.getString(1), 
							resultSet.getString(2),
							resultSet.getString(3)));
					
				}
			 preparedStatement.close();
				resultSet.close();
				closeConnection();
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return enrollList;
		 
	 }
	 public List<ClassesBean> getCourses(){
		 ClassesBean classes = null;
		 List<ClassesBean> classList = new ArrayList<ClassesBean>();
		 connectToDatabase();
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT courseID, "
			 			+ "title, numOfCredits " 
						+ "FROM Course "
						+ "ORDER BY title"); 
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while (resultSet.next()) {
					classList.add(new ClassesBean(resultSet.getString(1), 
							resultSet.getString(2)));
					
				}
			 preparedStatement.close();
				resultSet.close();
				closeConnection();
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return classList;
		 
	 }
	 
	 public String registerClass(String ssn, String courseID, String grade) {
		 connectToDatabase();
		 try {
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Enrollment "
						+ "VALUES(?, ?, NOW(), ?)");
				preparedStatement.setString(1, ssn);
				preparedStatement.setString(2, courseID);
				preparedStatement.setString(3, grade);

				
					preparedStatement.executeUpdate();
					preparedStatement.close();
					closeConnection();
					return "Success";
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 closeConnection();
		 return "Fail";
	 }
	 
	 public String dropClass(String ssn, String courseID) {
		 connectToDatabase();
		 try {
				PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Enrollment "
						+ "WHERE ssn = ? and courseId = ?");
				preparedStatement.setString(1, ssn);
				preparedStatement.setString(2, courseID);
				PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM Enrollment "
				 		+ "WHERE ssn = ? and courseId = ?");
				preparedStatement2.setString(1, ssn);
				preparedStatement2.setString(2, courseID);
				ResultSet set = preparedStatement2.executeQuery();
				if(set.next()) {
				preparedStatement.executeUpdate();
				preparedStatement.close();
				closeConnection();
				return "Success";}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 closeConnection();
		 return "fail";
	 }
	 
	
		 
	 
	 
	 
	 
	    

}
