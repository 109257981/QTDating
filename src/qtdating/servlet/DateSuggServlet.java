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

import qtdating.beans.Date;
import qtdating.beans.Profile;
import qtdating.utils.DBUtils;
import qtdating.utils.MyUtils;

/**
 * Servlet implementation class DateSuggServlet
 */
@WebServlet(urlPatterns = {"/DateSuggServlet"})
public class DateSuggServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateSuggServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/dateSugg.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if(request.getAttribute("profileList")!=null)
		{
			request.removeAttribute("profileList");
		}
		
		String pID=request.getParameter("pID");
		
		//connect to the database
		Connection conn = MyUtils.getStoredConnection(request);
		ArrayList<Profile> p=DBUtils.getProfileSugg(conn, pID);
		
		request.setAttribute("profileList", p);
		
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/dateSugg.jsp");
        dispatcher.forward(request, response);
	}

}
