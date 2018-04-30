

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

import qtdating.beans.Date;
import qtdating.beans.Person;
import qtdating.beans.Profile;
import qtdating.utils.DBUtils;
import qtdating.utils.MyUtils;

/**
 * Servlet implementation class RecordDateServlet
 */
@WebServlet(urlPatterns = {"/RecordDateServlet"})
public class RecordDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/recordDate.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//get the login user 
		HttpSession session = request.getSession();
		Person person=MyUtils.getPerson(session);
		String ssn=person.getSsn();
		
		String p1=request.getParameter("p1");		
		String p2=request.getParameter("p2");
		String date=request.getParameter("date");//
		Timestamp dt=Timestamp.valueOf(date);
		String location=request.getParameter("location");
		int bkfee=Integer.parseInt(request.getParameter("bkfee"));
		String cm=request.getParameter("cm");
		int u1R=Integer.parseInt(request.getParameter("u1R"));
		int u2R=Integer.parseInt(request.getParameter("u2R"));
		String geo=request.getParameter("geo");
		
		Boolean geo2;
		if(geo.equals("Yes"))
			geo2=true;
		else
			geo2=false;
		
		//connect to the database
		Connection conn = MyUtils.getStoredConnection(request);
		Date d=DBUtils.insertDate(conn,p1,p2,ssn,dt,location,bkfee,cm,u1R,u2R,geo2);
				
		if(d==null)
		{
			request.setAttribute("errorString", "Please try Again!");
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/recordDate.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/custRepresentativeView.jsp");
	        dispatcher.forward(request, response);
		}
	}

}
