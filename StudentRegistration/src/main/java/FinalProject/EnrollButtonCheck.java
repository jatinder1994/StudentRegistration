package FinalProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnrollButtonCheck
 */
@WebServlet("/EnrollButtonCheck")
public class EnrollButtonCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollButtonCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
			if ("Enroll".equals(action)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enroll.jsp");
				dispatcher.forward(request, response);
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if ("Exit".equals(action)) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
			dispatcher.forward(request, response);
        } else if ("Drop".equals(action)) {
        	String selectedCourse = request.getParameter("courses");
        	response.sendRedirect("DropClass?courses=" + selectedCourse);
            
        } else if ("Register".equals(action)) {
        	String selectedCourse = request.getParameter("courses");
        	String selectedGrade = request.getParameter("grade");
            response.sendRedirect("RegisterCheck?courses=" + selectedCourse+"&grade="+selectedGrade);
        } 
        
	}
	

}
