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

import Beans.EnrollBean;
import Beans.Student;

/**
 * Servlet implementation class DropClass
 */
@WebServlet("/DropClass")
public class DropClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnrollmentLogic enrollmentLogic = new EnrollmentLogic();
	private ClassesLogic courseServiceLogic = new ClassesLogic();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = (Student) request.getSession().getAttribute("student");
		String ssn = student.getSsn();
		String courses = request.getParameter("courses");
		if(courseServiceLogic.dropClass(ssn, courses)=="Success") {
			List<EnrollBean> enrollList = enrollmentLogic.getEnrollment(ssn);
			HttpSession session = request.getSession();
			session.setAttribute("list", enrollList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
			dispatcher.forward(request, response);

		}else {
			request.setAttribute("studentSSN", ssn);
	        request.setAttribute("courseID", courses);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enrollDropError.jsp");
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
