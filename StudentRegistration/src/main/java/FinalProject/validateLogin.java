package FinalProject;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.ClassesBean;
import Beans.EnrollBean;
import Beans.Student;

/**
 * Servlet implementation class validateLogin
 */
@WebServlet("/validateLogin")
public class validateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentInterface studentLogic = new StudentLogic();
	private EnrollmentLogic enrollmentLogic = new EnrollmentLogic();
	private ClassesLogic classesLogic = new ClassesLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ssn = request.getParameter("ssn").trim();
		Student student = null;
	
		
		List<EnrollBean> enrollList = null;
		List<ClassesBean> classList = null;
		student = studentLogic.getStudent(ssn);
		if(student==null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginError.jsp");
            dispatcher.forward(request, response);
		}else {
		enrollList = enrollmentLogic.getEnrollment(ssn);
		classList = classesLogic.getCourses();
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		session.setAttribute("list", enrollList);
		session.setAttribute("list2", classList);
	

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
		dispatcher.forward(request, response);
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
