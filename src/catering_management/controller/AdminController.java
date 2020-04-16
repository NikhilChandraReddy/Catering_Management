package catering_management.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import catering_management.data.UserDAO;
import catering_management.model.*;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final ArrayList<User> NULL = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doPost()");

		String action = request.getParameter("action"),url = "/";
		System.out.println(action);		
		HttpSession session = request.getSession();
		User user = new User();
		UserErrorMsg usererrorMsgs = new UserErrorMsg();
		// int selectedUserIndex;
		session.removeAttribute("errorMsgs");

		if (action.equalsIgnoreCase("searchforuser")) {
			System.out.println("inside searchUser action\n action="+action.equalsIgnoreCase("searchforuser"));
			String lastname = request.getParameter("last_name");
			System.out.println("lastname = " + lastname);
			session.removeAttribute("errorMsgs");

			user.setUser("","", lastname, "", "", "", "","","","","","","");

			user.validateUser(action, user, usererrorMsgs);
			System.out.println("after validateUser");

			ArrayList<User> userInDB = new ArrayList<User>();

			System.out.println("after userInDB");
			if (usererrorMsgs.getErrorMsg().equalsIgnoreCase("")) {
				System.out.println("inside IF of UerrorMsgs.getErrorMsg()");
				userInDB = UserDAO.searchUsers(lastname);
				session.setAttribute("Qlastname", lastname);
				if (userInDB.isEmpty()) {
					System.out.println("is empty for userInDB");
					usererrorMsgs.setLastNameError("No such user found");
					session.setAttribute("Qlastname", lastname);
					session.setAttribute("user", user);
					session.setAttribute("errorMsgs", usererrorMsgs);
					url = "/searchforuser.jsp";
					getServletContext().getRequestDispatcher(url).forward(request, response);

					return;
				}

				session.setAttribute("USERS", userInDB);

				System.out.println("before calling userlist.jsp");
				url = "/userlist.jsp";
			} else {
//				System.out.println("inside ELSE");
//				System.out.println(user.getLastName());
				session.setAttribute("user", user);
				session.setAttribute("errorMsgs", usererrorMsgs);
				url = "/searchUser.jsp";
				// }
			}
		} else if (action.equalsIgnoreCase("modify selected user")) {
			System.out.println("inside modifyUser");
			if (request.getParameter("radiouser")!=null) {
				int Index = Integer.parseInt(request.getParameter("radiouser")) - 1;
				
				ArrayList<User> userInDB = new ArrayList<User>();
				String lastname=(String) session.getAttribute("Qlastname");
				User muser = new User();
				userInDB = UserDAO.searchUsers(lastname);
				
				
				//System.out.println("\n\n"+(String) session.getAttribute("Qlastname")+"\n\n");
				System.out.println("\n\n"+userInDB.get(Index).getCity()+"\n\n");
				muser.setUser(userInDB.get(Index).getUsername(),userInDB.get(Index).getPassword(),userInDB.get(Index).getLastName(),userInDB.get(Index).getFirstName(),userInDB.get(Index).getRole(),userInDB.get(Index).getUtaId(),userInDB.get(Index).getPhone(),userInDB.get(Index).getEmail(),userInDB.get(Index).getStreet_Number(),userInDB.get(Index).getStreet_Name(),userInDB.get(Index).getCity(),userInDB.get(Index).getState(),userInDB.get(Index).getZipCode());
				//System.out.println("\n\n"+userInDB.get(Index).getRole()+"\n\n");
				session.setAttribute("muser", muser);
				
				url = "/modifyuser.jsp";
			}
		}
		else if (action.equalsIgnoreCase("delete selected user")) {
			System.out.println("inside deleteuser");
			if (request.getParameter("radiouser")!=null) {
				int Index = Integer.parseInt(request.getParameter("radiouser")) - 1;
				
				ArrayList<User> userInDB = new ArrayList<User>();
				String lastname=(String) session.getAttribute("Qlastname");
				User muser = new User();
				userInDB = UserDAO.searchUsers(lastname);
				
				
				System.out.println("\n\n"+userInDB.get(Index).getUsername()+"\n\n");
				String username= userInDB.get(Index).getUsername();
				
				UserDAO.deleteUser(username);
				//muser.setUser(userInDB.get(Index).getUsername(),userInDB.get(Index).getPassword(),userInDB.get(Index).getLastName(),userInDB.get(Index).getFirstName(),userInDB.get(Index).getRole(),userInDB.get(Index).getUtaId(),userInDB.get(Index).getPhone(),userInDB.get(Index).getEmail(),userInDB.get(Index).getStreet_Number(),userInDB.get(Index).getStreet_Name(),userInDB.get(Index).getCity(),userInDB.get(Index).getState(),userInDB.get(Index).getZipCode());
				//System.out.println("\n\n"+userInDB.get(Index).getRole()+"\n\n");
			}
				url = "/searchforuser.jsp";
		}else if (action.equalsIgnoreCase("changerole")) 
			{
				System.out.println("inside changerole");
				String role = request.getParameter("role");

				User muser = (User) session.getAttribute("muser");
				session.removeAttribute("muser");
				String username = muser.getUsername();
				System.out.println(role);
				String RoleERR = muser.validateRole(role);
				System.out.println(username);
				System.out.println("checking for role error");
				if(!RoleERR.equals(""))
				{
					System.out.println("found role error");
					muser.setRole(role);
					session.setAttribute("muser", muser);
					session.setAttribute("RoleERR", RoleERR);
					
					url = "/modifyuser.jsp";
				}
				else {
					
					try {
						UserDAO.changeroleUser(username,role);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					muser.setRole(role);
					session.setAttribute("muser", muser);

					
					url = "/sucessmodifyuser.jsp";
				}
					
		}
		else {
				session.setAttribute("muser", user);
				session.setAttribute("errorMsgs", usererrorMsgs);
				url = "/modifyUser.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}