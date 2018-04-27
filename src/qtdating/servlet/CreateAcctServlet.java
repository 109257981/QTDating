package qtdating.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qtdating.beans.Account;
import qtdating.beans.Person;
import qtdating.beans.User;
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
		// SSN only contains digits
		Matcher m = Pattern.compile("[0-9]+").matcher(SSN); 
		if (m.matches() == false) { } // handle error
		
		
		// Password only contain letters, digits, [@*_] and at least n long
		String PassWord = request.getParameter("PassWord");
		m = Pattern.compile("[0-9a-zA-Z@#\\$_%&\\*]{3,}").matcher(PassWord); 
		
		String ConfirmPass = request.getParameter("ConfirmPass");
		
		// Passwords don't match! 
		if (!PassWord.equals(ConfirmPass)) {   // handle error
			
		}
		
		
		// Names: Only alphabetic letters and dashes (e.g. Anne-Marie)
		String FirstName = request.getParameter("FirstName");
        m = Pattern.compile("(([a-zA-Z])+(-([a-zA-Z]))?)+").matcher(FirstName);
		if (m.matches() == false) { } // handle error
        
		// Same here
		String LastName = request.getParameter("LastName");
		 m = Pattern.compile("(([a-zA-Z])+(-([a-zA-Z]))?)+").matcher(LastName);
		if (m.matches() == false) { } // handle error
		
		// Non empty
		String Street = request.getParameter("Address");	
		m = Pattern.compile(".+").matcher(Street);
		if (m.matches() == false) { } // handle error
		
		// Non empty
		String City = request.getParameter("City");
		m = Pattern.compile(".+").matcher(City);
		if (m.matches() == false) { } // handle error

		// Can later do the combobox
		String State = request.getParameter("State");
		
		String ZipCodeS = request.getParameter("ZipCode");
		// Zip only contains digits
		m = Pattern.compile("[0-9]+").matcher(ZipCodeS); 
		int ZipCode = 0;   // for now
		if (m.matches() == false) { }  // handle error
		else {
			ZipCode = Integer.parseInt(ZipCodeS); // to avoid atoi() trouble
		}
		
		// Only valid email addresses
		String Email = request.getParameter("Email");
		m = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,10}$",
				Pattern.CASE_INSENSITIVE).matcher(Email);
		if (m.matches() == false) { }  // handle error
		
		
		String Telephone = request.getParameter("Telephone");
		// Only digits for now, will discuss what is valid
		m = Pattern.compile("[0-9]+").matcher(Telephone); 
		if (m.matches() == false) { }  // handle error
		String cardNumber = request.getParameter("Cardnumber");
		
		Person person = null;
		boolean hasError = false;
		Connection conn = MyUtils.getStoredConnection(request);
		person = DBUtils.insertPerson(conn,SSN,PassWord,FirstName,LastName,Street,City,State,ZipCode,Email,Telephone);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();    
        Timestamp timestamp = Timestamp.valueOf(now);
        User user = DBUtils.createUser(conn, SSN, "User-User", 0, timestamp);
		Account act = DBUtils.createAccount(conn, SSN, cardNumber, timestamp);
		
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
