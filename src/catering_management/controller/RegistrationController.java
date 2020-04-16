package catering_management.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catering_management.data.RegistrationDAO;
import catering_management.model.*;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();
		session.removeAttribute("registration");
		System.out.println("i am here");
		Registration registration = new Registration();
		//insert user
		if (action.equals("save_registration_details")) {
			registration.setRegistration( request.getParameter("username"), request.getParameter("password"),request.getParameter("last_name"),request.getParameter("first_name"), request.getParameter("role"), request.getParameter("uta_id"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("street_number"), request.getParameter("street_name"), request.getParameter("city"), request.getParameter("state"), request.getParameter("zip_code"));
			RegistrationErrorMsg EerrorMsgs = new RegistrationErrorMsg();
			
			registration.validateRegistration(registration, EerrorMsgs);
			session.setAttribute("registration",registration);
			session.setAttribute("errorMsgs",EerrorMsgs);
			System.out.println("i am here");
			if (EerrorMsgs.getErrorMsg().equals("")) {
				
					RegistrationDAO.Register(registration);
					URL = "/index.jsp"; 
					session.removeAttribute("registration");	
					session.removeAttribute("errorMsgs");
				}
			else {
					//session.removeAttribute("registration");
					URL = "/registration.jsp"; 
				}
			}
		else{
				URL = "/registration.jsp"; 
		}
			
			url = URL; 
	
		//System.out.print("\n\n\n\n"+registration.getLastName()+"\n\n\n");
		getServletContext().getRequestDispatcher(url).forward(request, response);		
}
}