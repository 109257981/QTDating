package qtdating.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qtdating.beans.Profile;
import qtdating.utils.DBUtils;
import qtdating.utils.MyUtils;

/**
 * Servlet implementation class ProfileServlet
 */

@WebServlet(urlPatterns = { "/ManagerQueryServlet" })
public class ManagerQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//connect to the database
		Connection conn = MyUtils.getStoredConnection(request);
		
		//Store profile to session
		HttpSession session = request.getSession();
        
        String s = request.getParameter("choice");
        
        
        if (s.equals("Update Employee Information")) {
        	
        }
        else if  (s.equals("Monthly Sales"))  {
        	
        }
        else if  (s.equals("All Users"))  {
        	ArrayList<qtdating.beans.Person> users = DBUtils.getAllUsers(conn);
        	request.setAttribute("users", users);
        	
            RequestDispatcher dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/allUsers.jsp");
            dispatcher.forward(request, response);

        	
        }
        else if  (s.equals("All Dates"))  {
        	//ArrayList<qtdating.beans.Person> dates; = DBUtils.getDate(conn);
        	//request.setAttribute("dates", dates);
            RequestDispatcher dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/allDates.jsp");
            dispatcher.forward(request, response);
            
        }
        else if  (s.equals("Revenue summary"))  {
        	
	
        }	
        else if  (s.equals("Employee revenue rating"))  {
        	
        }	
        else if  (s.equals("Most Active Customers"))  {
        	
        }	
        else if  (s.equals("Hightly Rated Customers"))  {
        	ArrayList<qtdating.beans.User> users = DBUtils.getHighestRatedCus(conn, 5);
   	
        }
        else if  (s.equals("People who dated a customer"))  {
        	
        }
        else if  (s.equals("Highest-Rated Calendar Dates"))  {
        	
        }	
        else
        {
        }
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerView.jsp");
        dispatcher.forward(request, response);
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
