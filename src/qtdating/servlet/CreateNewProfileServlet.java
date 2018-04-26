package qtdating.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qtdating.beans.Person;
import qtdating.beans.Profile;
import qtdating.utils.DBUtils;
import qtdating.utils.MyUtils;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

/**
 * Servlet implementation class CreateNewProfile
 */
@WebServlet(urlPatterns = { "/CreateNewProfileServlet" })
public class CreateNewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createNewProfileView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				//get the login user 
				HttpSession session = request.getSession();
				Person person=MyUtils.getPerson(session);
				
				//connect to the database
				Connection conn = MyUtils.getStoredConnection(request);
				
				String profileId = request.getParameter("profileId");
		        int age= Integer.parseInt(request.getParameter("age"));
		        int datingAgeRangeStart= Integer.parseInt(request.getParameter("datingAgeRangeStart"));
		        int datingAgeRangeEnd= Integer.parseInt(request.getParameter("datingAgeRangeStart"));
		        int datingGeoRange= Integer.parseInt(request.getParameter("datingGeoRange"));	        
		        String gender = request.getParameter("m_f");
		        String hobbies = request.getParameter("hobbies");
		        int height= Integer.parseInt(request.getParameter("height"));
		        int weight= Integer.parseInt(request.getParameter("weight"));
		        String hairColor = request.getParameter("hairColor");
		        
		        //getting the current time
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		        LocalDateTime now = LocalDateTime.now();    
		        Timestamp timestamp = Timestamp.valueOf(now);	        
				
				Profile p = DBUtils.insertProfile(conn,profileId,person.getSsn(),age,datingAgeRangeStart,datingAgeRangeEnd,datingGeoRange,gender,hobbies, height,weight, hairColor,timestamp,timestamp);
				
				if(p==null)
				{
					request.setAttribute("errorString", "Please try Again!");
					
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createNewProfileView.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					 response.sendRedirect(request.getContextPath() + "/HomeServlet");
				}		
	}

}
