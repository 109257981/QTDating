package qtdating.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qtdating.beans.Date;
import qtdating.beans.Person;
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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerView.jsp");

        
        String s = request.getParameter("choice");
        
        
        if (s.equals("Update Employee Information")) {
            dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/updateEmployee.jsp");

        }
        else if (s.equals("deleteEmployee")) {
        	
        	DBUtils.deleteUser(conn,
        			request.getParameter("ssn")
        	);
           
        }
        else if (s.equals("UpdateEmployee")) {
        	String rate = request.getParameter("rate");
        	int _rate = 0;
        	try {
        		_rate = Integer.valueOf(rate);
        	} catch(Exception e) {
        		rate = "";
        	}
        	String role = request.getParameter("role");
        	if (rate == null || rate.equals("")) {
        		if (role ==  null || role.equals(""));
        		else {
        			DBUtils.editEmployeeRole(conn,
        					request.getParameter("ssn"),
        					request.getParameter("role"));
                	}
        	}
        	else {
        		if (role ==  null || role.equals("")) {
        			DBUtils.editEmployeeRate(conn,
        					request.getParameter("ssn"),
        					_rate);
        		}
        		else {
        			DBUtils.editEmployeeRole(conn,
        					request.getParameter("ssn"),
        					role);
        			DBUtils.editEmployeeRate(conn,
        					request.getParameter("ssn"),
        					_rate);
        		}
        		}
        	}
        else if  (s.equals("Monthly Sales"))  {
            dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/monthlySales.jsp");

        }
        else if  (s.equals("Monthly Sales Result"))  {	
        	String from = request.getParameter("from");
        	String to = request.getParameter("to");   
        	ArrayList<Date> dates;
        	
        	dates =  DBUtils.getSalesReport(conn,
        			 Timestamp.valueOf(from + " 00:00:00"),
        			 Timestamp.valueOf(to + " 00:00:00")
        	);
        	request.setAttribute("dates", dates);
        	
        	dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/monthlySalesResult.jsp");

        }
        else if  (s.equals("All Users"))  {
        	ArrayList<qtdating.beans.Person> users = DBUtils.getAllUsers(conn);
        	request.setAttribute("users", users);
            dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/allUsers.jsp");

        	
        }
        else if  (s.equals("Dates By Name or Date"))  {

            dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/antiDate.jsp");
        }
        else if  (s.equals("DateSearchResult"))  {
        	String how = request.getParameter("how");
        	ArrayList<qtdating.beans.Date> dates = null;
        	
        	if (how.equals("name")) {
        		dates = DBUtils.getDatesByName(conn,
        				request.getParameter("firstName"),
        				request.getParameter("lastName")
        		);
        	}
        	else {
        		dates = DBUtils.getDatesByDate(conn,
        				request.getParameter("date") + " 00:00:01",
        				request.getParameter("date") + " 23:59:59"
        				);
        		
        	}
        	
        	request.setAttribute("dates", dates);

        	dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/allDatesResult.jsp");
            
        }
        else if  (s.equals("Revenue summary")) {
        	dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/revenueSummary.jsp");

        	
        	
        }
        else if  (s.equals("Revenue summary Result"))  {
        	String how = request.getParameter("how");
        	ArrayList<Integer> sales;
        	if (how.equals("date")) {
        		System.out.println(request.getParameter("date"));
        		sales = DBUtils.revenueByDate(conn,
        				request.getParameter("date") + " 00:00:00",
        				request.getParameter("date") + " 23:59:59"
        		);

        	}
        	else {
        		sales = DBUtils.revenueByName(conn,
        				request.getParameter("firstName"),
        				request.getParameter("lastName")
        		);
        	}
        	
        	int total = 0;
        	for (int i : sales) {
        		total+=i;
        	}
        	
        	request.setAttribute("total", total);
        	
        	dispatcher = this.getServletContext()
            		.getRequestDispatcher("/WEB-INF/views/managerQueries/revenueSummaryResult.jsp");

        	
        }	
        else if  (s.equals("Employee revenue rating"))  {
        	//ArrayList  = DBUtils.most
        	Person p = DBUtils.getCusGeneratedMostTotalRevenue(conn);
        	request.setAttribute("user", p);

        	
        	dispatcher = this.getServletContext()
             		.getRequestDispatcher("/WEB-INF/views/managerQueries/employeeRevenue.jsp");
        	
        	
        	
        	
        }	
        else if  (s.equals("Most Active Customers"))  {
        	
        }	
        else if  (s.equals("Hightly Rated Customers"))  {
        	ArrayList<qtdating.beans.User> users = DBUtils.getHighestRatedCus(conn, 5);
        	ArrayList<String> ssn = new ArrayList();
        	ArrayList<qtdating.beans.Person> person = new ArrayList();
        	 for (qtdating.beans.User user : users) {
        		ssn.add(user.getSsn());
        	 }
        	 for (String st : ssn) {
         		person.add(DBUtils.getPersonBySSN(conn, st));
         	 }
			
        	request.setAttribute("users", person);	
           dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerQueries/topCustomers.jsp");
       

   	
        }
        else if  (s.equals("People who dated a customer"))  {
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerQueries/whoDated.jsp");
        }
        else if  (s.equals("People who dated a customer result"))  {
        	ArrayList<Person> list;
        	list =  DBUtils.getCusWhoHaveDated(conn,
        			request.getParameter("ssn"));
        	request.setAttribute("users", list);
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerQueries/whoDatedResult.jsp");
          

        	
        	
        	
        }
        else if  (s.equals("Highest-Rated Calendar Dates"))  {
        	ArrayList st = DBUtils.getHighestRatedCalendarDate(conn, 4);
        	request.setAttribute("dates", st);
        	
        	dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerQueries/calendarDates.jsp");
        	
        }	
        else
        {
        }
        
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
