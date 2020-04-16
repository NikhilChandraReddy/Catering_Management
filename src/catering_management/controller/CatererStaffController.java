package catering_management.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catering_management.data.CatererManagerDAO;
import catering_management.data.CatererStaffDAO;
import catering_management.model.*;

@WebServlet("/CatererStaffController")
public class CatererStaffController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();
		session.removeAttribute("errorMsgs");
		
		EventForm ef = new EventForm();
		
		if (action.equals("save_date")) {
			String date = request.getParameter("startdate");
			String time = request.getParameter("starttime");
			System.out.println("insise save_date");
			
			ef.setStart_date(date);
			ef.setStart_time(time);
			
			EventFormErrorMsgs eferrormsgs = new EventFormErrorMsgs();
			
			ef.validateDateandTime(ef, eferrormsgs);
			

			session.setAttribute("event",ef);
			session.setAttribute("errorMsgs",eferrormsgs);
			
			if (eferrormsgs.getStart_dateError().equals("") && eferrormsgs.getStart_timeError().equals("")) {
				
						
					session.removeAttribute("errorMsgs");
					ArrayList<EventForm> eventsInDB =  new ArrayList<EventForm>();
					String fname=(String) session.getAttribute("login_firstname");
					String lname=(String) session.getAttribute("login_lastname");
					System.out.println(lname);
					System.out.println(fname);
					eventsInDB = CatererStaffDAO.getEvents(date,time,lname,fname);
					session.setAttribute("eventslist", eventsInDB);
					url = "/catererstaffsummary.jsp";
				}
			else {
					//session.removeAttribute("registration");
					url = "/catererstaffdatepage.jsp"; 
				}		
			
		}
		else if(action.equals("View Selected Event")) {
			System.out.println("inside view");
			if (request.getParameter("radioevent")!=null) {
				int Index = Integer.parseInt(request.getParameter("radioevent")) - 1;
				System.out.println("\n\n"+Index+"\n\n");
				ArrayList<EventForm> eventsInDB =  new ArrayList<EventForm>();
				eventsInDB=(ArrayList<EventForm>) session.getAttribute("eventslist");
				System.out.println("\n\n"+eventsInDB.get(Index).getEvent_name()+"\n\n");
				
				EventForm event = new EventForm();
				event=eventsInDB.get(Index);
				session.removeAttribute("event");
				session.setAttribute("event",event);

/*				ArrayList<User> userInDB = new ArrayList<User>();
				String lastname=(String) session.getAttribute("Qlastname");
				User muser = new User();
				userInDB = UserDAO.searchUsers(lastname);
				
				
				//System.out.println("\n\n"+(String) session.getAttribute("Qlastname")+"\n\n");
				System.out.println("\n\n"+userInDB.get(Index).getUtaId()+"\n\n");
				muser.setUser(userInDB.get(Index).getUsername(),userInDB.get(Index).getPassword(),userInDB.get(Index).getLastName(),userInDB.get(Index).getFirstName(),userInDB.get(Index).getRole(),userInDB.get(Index).getUtaId(),userInDB.get(Index).getPhone(),userInDB.get(Index).getEmail(),userInDB.get(Index).getStreet_Number(),userInDB.get(Index).getStreet_Name(),userInDB.get(Index).getCity(),userInDB.get(Index).getState(),userInDB.get(Index).getZipCode());
				//System.out.println("\n\n"+userInDB.get(Index).getRole()+"\n\n");
				session.setAttribute("muser", muser);*/
				
				url = "/catererstaff_eventsummary.jsp";
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		

	}
}