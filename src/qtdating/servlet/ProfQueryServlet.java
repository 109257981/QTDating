package qtdating.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

@WebServlet(urlPatterns = { "/ProfQueryServlet" })
public class ProfQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfQueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// String pID =request.getParameter("btn");
		//
		// //connect to the database
		// Connection conn = MyUtils.getStoredConnection(request);
		// Profile p=DBUtils.getSpecificProfile(conn,pID);
		//
		// //Store profile to session
		// HttpSession session = request.getSession();
		// MyUtils.storeProfile(session,p);
		//
		//
		// RequestDispatcher dispatcher =
		// this.getServletContext().getRequestDispatcher("/WEB-INF/views/profileView.jsp");
		// dispatcher.forward(request, response);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profileView.jsp");


		String s = request.getParameter("choice");

		Connection conn = MyUtils.getStoredConnection(request);
		String profileId = request.getParameter("profileId");
		request.setAttribute("profileId", profileId);
		Profile profile = MyUtils.getProfile(request.getSession());
		profileId = profile.getProfileId();

		

		if (s.equals("Make a Date")) {
			String profile2 = request.getParameter("profile2");
			request.setAttribute("profile2", profile2);
			System.out.println("in make date prof2 = " + profile2);
			
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profileQueries/makeDate.jsp");

		} 
		else if (s.equals("submitNewDate")) {
			System.out.println("SUBMIT DATE");
			String date_time =  request.getParameter("date") + " " + request.getParameter("time");
			System.out.println(date_time);
			System.out.println(profileId);
			System.out.println(request.getParameter("profile2"));
			System.out.println(request.getParameter("location"));

			DBUtils.makeDate(conn,
					profileId,
					request.getParameter("profile2"),
					request.getParameter("location"),
					false,
					date_time
			);
			

		}
		
		else if (s.equals("New Geo-Date")) {

		} else if (s.equals("Cancel a Date")) {
			ArrayList<qtdating.beans.Date> pendingDates;
			pendingDates = DBUtils.getPendingDates(conn, profileId, getRightNow());
			request.setAttribute("pendingDates", pendingDates);
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/cancelDate.jsp");
		} else if (s.equals("CancelDateProcessing")) {
			DBUtils.cancelDate(conn, request.getParameter("profile1"), request.getParameter("profile2"),
					request.getParameter("date"));
		} else if (s.equals("Like a Profile")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profileView.jsp");
		} else if (s.equals("Past Dates")) {
			

			ArrayList<qtdating.beans.Date> pastDates;
			pastDates = DBUtils.getPastDates(conn, profileId, getRightNow());
			request.setAttribute("pastDates", pastDates);
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profileQueries/pastDates.jsp");

		} else if (s.equals("Pending Dates")) {

			// how soon is now?
			ArrayList<qtdating.beans.Date> pendingDates;
			pendingDates = DBUtils.getPastDates(conn, profileId, getRightNow());
			request.setAttribute("pendingDates", pendingDates);
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/pendingDates.jsp");

		} else if (s.equals("Referral")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profileQueries/referral.jsp");
		} else if (s.equals("Refer")) {
			DBUtils.referProfile(conn, "3456",
					request.getParameter("profileA"),
					request.getParameter("profileB"),
					getRightNow()
			);
		}
		else if (s.equals("LikeProfile")) {
			DBUtils.likeProfile(conn,
					profileId,
					request.getParameter("profile2"),
					getRightNow()
			);
		}
		else if (s.equals("Favorites List")) {
			ArrayList<qtdating.beans.Profile> profileList;
			profileList = DBUtils.getFavorites(conn, profileId);
			request.setAttribute("profileList", profileList);
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/favorites.jsp");
		} else if (s.equals("Search for profiles")) {

		} else if (s.equals("Comment on a Date")) {
			ArrayList<qtdating.beans.Date> pastDates;
			pastDates = DBUtils.getPastDates(conn, profileId, getRightNow());
			request.setAttribute("pastDates", pastDates);
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/commentDate.jsp");
		} else if (s.equals("newComment")) {
			DBUtils.commentOnDate(conn, request.getParameter("profile1"), request.getParameter("profile2"),
					request.getParameter("date"), request.getParameter("comment"));
		}

		else if (s.equals("Most active profiles")) {
			ArrayList<qtdating.beans.Profile> profileList = DBUtils.getActiveProfiles(conn);
			request.setAttribute("profileList", profileList);
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/mostActive.jsp");


		} else if (s.equals("Top Rated Profiles")) {
			ArrayList<qtdating.beans.Profile> profileList = DBUtils.getHighlyRatedProfiles(conn);
			request.setAttribute("profileList", profileList);
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/mostActive.jsp");
			

		} else if (s.equals("Popular Date Locations")) {
			ArrayList<String> locations = DBUtils.getPopularGeoDateLocations(conn);
			request.setAttribute("locations", locations);
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/popularLocations.jsp");
			
			

		} else if (s.equals("Date Suggestion List")) {
			dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/profileQueries/commentDate.jsp");

		} else if (s.equals("Back to profiles")) {
			

		}

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.print("ENTER THE GPOSTET");
		System.out.print("ENTER THE GET");

	}

	private String getRightNow() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		return sdfDate.format(now);
	}

}
