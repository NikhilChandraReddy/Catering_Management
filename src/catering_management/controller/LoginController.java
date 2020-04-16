package catering_management.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catering_management.data.*;
import catering_management.model.*;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();
		Login login = new Login();
//		session.setAttribute("login",login);
		//insert employee
		if (action.equals("login")) {
//			if (request.getParameter("insertEmpbutton")!=null) {  //insert employee button pressed
			login.setLogin(request.getParameter("username"), request.getParameter("password"));
			LoginErrorMsg EerrorMsgs = new LoginErrorMsg();
			login.validateLogin(login, EerrorMsgs);
			session.setAttribute("login",login);
			session.setAttribute("errorMsgs",EerrorMsgs);
			//session.setAttribute("uname",request.getParameter("username"));
			if (EerrorMsgs.getErrorMsg().equals("")) {
				String[] ans = LoginDAO.UserLogin(login);
				String role = ans[0];
				String utaid = ans[1];
				System.out.print(role);
				System.out.println(ans[0]);
				System.out.println(ans[2]);
				System.out.println(ans[3]);
				session.setAttribute("login_username",login.getUsername());
				session.setAttribute("login_uid",ans[1]);
				session.setAttribute("login_lastname",ans[2]);
				session.setAttribute("login_firstname",ans[3]);
//				System.out.println(role);
				if (role.equals("User")) {
					URL = "/userhomepage.jsp"; 
				}
				else if (role.equals("Caterer_Manager")) {
					URL = "/caterermanager_homepage.jsp"; 
				}
				else if (role.equals("Admin")) {
					URL = "/adminhome.jsp"; 
				}
				else if (role.equals("Caterer_Staff")) {
					URL = "/catererstaff_homepage.jsp"; 
				}
				else {
					URL = "/index.jsp";
				}
				session.removeAttribute("login");	
				session.removeAttribute("errorMsgs");	
			}
			
			else {
				URL = "/index.jsp";
			}
				url = URL; 
			}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}