package qtdating.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qtdating.beans.Employee;
import qtdating.beans.Person;
import qtdating.utils.DBUtils;
import qtdating.utils.MyUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Forward to /WEB-INF/views/loginView.jsp
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email = request.getParameter("Email");
        String password = request.getParameter("Password");
 
        Person person = null;
        boolean hasError = false;
 
        Connection conn = MyUtils.getStoredConnection(request);
        // Find the person in the DB.
		person = DBUtils.getPerson(conn, email, password);
 
		if (person == null) {
		    hasError = true;
		}        
        if(hasError) { 
            // Forward to /WEB-INF/views/login.jsp
        	request.setAttribute("errorString", "Invalid Email or Password!");
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
        
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
        	//check if that person is an employee
        	Employee e=null;
        	e = DBUtils.getEmployee(conn, person.getSsn());
        	
        	if(e==null)
        	{      	
	            HttpSession session = request.getSession();
				MyUtils.storePerson(session, DBUtils.getPerson(MyUtils.getStoredConnection(request), email));
	            response.sendRedirect(request.getContextPath() + "/HomeServlet");
        	}
        	else
        	{
        		if((e.getRole()).equals("Manager"))
        		{
        			HttpSession session = request.getSession();
    				MyUtils.storePerson(session, DBUtils.getPerson(MyUtils.getStoredConnection(request), email));
    				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerView.jsp");
    		        dispatcher.forward(request, response);
        		}
        		else
        		{
        			HttpSession session = request.getSession();
    				MyUtils.storePerson(session, DBUtils.getPerson(MyUtils.getStoredConnection(request), email));
    				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/custRepresentativeView.jsp");
    		        dispatcher.forward(request, response);
        		}
        	}
        }
	}

}
