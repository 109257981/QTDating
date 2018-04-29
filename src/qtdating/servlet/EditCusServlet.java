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

import qtdating.utils.DBUtils;
import qtdating.utils.MyUtils;

/**
 * Servlet implementation class EditCusServlet
 */
@WebServlet(urlPatterns = {"/EditCusServlet"})
public class EditCusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String ssn=request.getParameter("SSN");
		String change=request.getParameter("change");
		String changeTo=request.getParameter("changeTo");
		
		Connection conn = MyUtils.getStoredConnection(request);
		boolean success=DBUtils.editUserInfo(conn,ssn,change,changeTo);
		
		if(success)
		{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateCusInfo.jsp");
			dispatcher.forward(request, response);			
		}
		else
		{
			request.setAttribute("errorString", "Please try Again!");
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/editCus.jsp");
			dispatcher.forward(request, response);
		}
	}

}
