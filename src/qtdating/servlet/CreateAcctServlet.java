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

import qtdating.beans.Person;
import qtdating.utils.DBUtils;
import qtdating.utils.MyUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/CreateAcctServlet" })
public class CreateAcctServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAcctServlet() {
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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createAcctView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String SSN = request.getParameter("SSN");
		String PassWord = request.getParameter("PassWord");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Street = request.getParameter("Address");
		String City = request.getParameter("City");
		String State = request.getParameter("State");
		String ZipCodeS = request.getParameter("ZipCode");
		int ZipCode = Integer.parseInt(ZipCodeS);
		String Email = request.getParameter("Email");
		String Telephone = request.getParameter("Telephone");
		
		Person person = null;
		boolean hasError = false;
		Connection conn = MyUtils.getStoredConnection(request);
		person = DBUtils.insertPerson(conn,SSN,PassWord,FirstName,LastName,Street,City,State,ZipCode,Email,Telephone);
		
		if (person == null) {
		    hasError = true;
		}        
        if(hasError) {}
        
        else{
        	HttpSession session = request.getSession();
			MyUtils.storePerson(session, DBUtils.getPerson(MyUtils.getStoredConnection(request), Email));
            response.sendRedirect(request.getContextPath() + "/HomeServlet");
        }
	}

}
