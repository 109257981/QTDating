package qtdating.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qtdating.beans.Person;
import qtdating.beans.Profile;


public class MyUtils {

    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
 
    // Store Connection in request attribute.
    // (Information stored only exist during requests)
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    // Get the Connection object has been stored in attribute of the request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }

    // Store user info in Session.
    public static void storePerson(HttpSession session, Person person) {
        // On the JSP can access via ${person}
        session.setAttribute("person", person);
    }
 
    // Get the user information stored in the session.
    public static Person getPerson(HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        return person;
    }
    
    // Store profile info in Session.
    public static void storeProfile(HttpSession session, Profile profile) {
        // On the JSP can access via ${person}
        session.setAttribute("profile", profile);
    }
 
    // Get the profile information stored in the session.
    public static Profile getProfile(HttpSession session) {
        Profile profile= (Profile) session.getAttribute("profile");
        return profile;
    }
    
   
    // Store info in Cookie
    public static void storePersonCookie(HttpServletResponse response, Person person) {
        System.out.println("Store person cookie");
        Cookie cookieEmail = new Cookie(ATT_NAME_USER_NAME, person.getEmail());
        // 1 day (Converted to seconds)
        cookieEmail.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieEmail);
    }
 
    public static String getEmailInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
 
    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieEmail = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 seconds (This cookie will expire immediately)
        cookieEmail.setMaxAge(0);
        response.addCookie(cookieEmail);
    }
    
}
