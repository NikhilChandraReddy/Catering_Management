package catering_management.controller;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catering_management.data.CatererStaffDAO;
import catering_management.data.EventFormDAO;
import catering_management.data.RegistrationDAO;
import catering_management.data.UserDAO;
import catering_management.model.EventForm;
import catering_management.model.EventFormErrorMsgs;
import catering_management.model.Registration;
import catering_management.model.RegistrationErrorMsg;
import catering_management.model.User;


@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="";
		HttpSession session = request.getSession();

		
		if (action.equals("ViewProfile")) {
			System.out.println("inside ViewProfile");
			String username= (String) session.getAttribute("login_username");
			ArrayList<Registration> RegInDB = new ArrayList<Registration>();
			Registration vuser = new Registration();
			RegInDB = UserDAO.getreg(username);
			int Index=0;
			System.out.println("\n\n"+RegInDB.get(Index).getCity()+"\n\n");
			//vuser.setUser(RegInDB.get(Index).getUsername(),RegInDB.get(Index).getPassword(),RegInDB.get(Index).getLastName(),RegInDB.get(Index).getFirstName(),userInDB.get(Index).getRole(),userInDB.get(Index).getUtaId(),userInDB.get(Index).getPhone(),userInDB.get(Index).getEmail(),userInDB.get(Index).getStreet_Number(),userInDB.get(Index).getStreet_Name(),userInDB.get(Index).getCity(),userInDB.get(Index).getState(),userInDB.get(Index).getZipCode());
			//System.out.println("\n\n"+userInDB.get(Index).getRole()+"\n\n");
			vuser = RegInDB.get(Index);
			session.setAttribute("vuser", vuser);
			
			
			url = "/viewprofile.jsp";
								
		
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}if (action.equals("cancel")) {
		System.out.println("inside ViewProfile");
		String username= (String) session.getAttribute("login_username");
		ArrayList<Registration> RegInDB = new ArrayList<Registration>();
		Registration vuser = new Registration();
		RegInDB = UserDAO.getreg(username);
		int Index=0;
		System.out.println("\n\n"+RegInDB.get(Index).getCity()+"\n\n");
		//vuser.setUser(RegInDB.get(Index).getUsername(),RegInDB.get(Index).getPassword(),RegInDB.get(Index).getLastName(),RegInDB.get(Index).getFirstName(),userInDB.get(Index).getRole(),userInDB.get(Index).getUtaId(),userInDB.get(Index).getPhone(),userInDB.get(Index).getEmail(),userInDB.get(Index).getStreet_Number(),userInDB.get(Index).getStreet_Name(),userInDB.get(Index).getCity(),userInDB.get(Index).getState(),userInDB.get(Index).getZipCode());
		//System.out.println("\n\n"+userInDB.get(Index).getRole()+"\n\n");
		vuser = RegInDB.get(Index);
		session.setAttribute("vuser", vuser);
		
		
		url = "/modifyprofile.jsp";
							
	
	getServletContext().getRequestDispatcher(url).forward(request, response);		
	}else if (action.equals("save_details")) {
		Registration newregistration = new Registration();
		Registration oldregistration =  (Registration) session.getAttribute("vuser");
		newregistration.setRegistration( request.getParameter("username"), request.getParameter("password"),request.getParameter("last_name"),request.getParameter("first_name"),oldregistration.getRole(),request.getParameter("uta_id"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("street_number"), request.getParameter("street_name"), request.getParameter("city"), request.getParameter("state"), request.getParameter("zip_code"));
		RegistrationErrorMsg EerrorMsgs = new RegistrationErrorMsg();
		
		newregistration.validateRegistrationnotrole(newregistration, EerrorMsgs);
		session.removeAttribute("vuser");	
		session.removeAttribute("errorMsgs");
		session.setAttribute("vuser",newregistration);
		session.setAttribute("errorMsgs",EerrorMsgs);
		System.out.println("i am here");
		if (EerrorMsgs.getErrorMsg().equals("")) {
			
				RegistrationDAO.updateUser(newregistration);
				url = "/userhomepage.jsp"; 
				session.removeAttribute("vuser");	
				session.removeAttribute("errorMsgs");
			}
		else {
				//session.removeAttribute("registration");
				url = "/modifyprofile.jsp"; 
			}
	}else if (action.equals("save_date")) {
		EventForm ef = new EventForm();
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
				String utaID=(String) session.getAttribute("login_uid");
				System.out.println(lname);
				System.out.println(fname);
				System.out.println(utaID);
				eventsInDB = CatererStaffDAO.getEventsforuser(date, time, utaID);
				session.setAttribute("eventslist", eventsInDB);
				url = "/systemusersummary.jsp";
			}
		else {
				//session.removeAttribute("registration");
				url = "/systemuserdatepage.jsp"; 
			}		
		
	}else if(action.equals("View Selected Event")) {
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
			
			url = "/systemuser_eventsummary.jsp";
		}
	}else if(action.equals("Modify Selected Event")) {
		System.out.println("inside modify selected event");
		session.setAttribute("radiou", request.getParameter("radioevent"));
		if (request.getParameter("radioevent")!=null) {
			int Index = Integer.parseInt(request.getParameter("radioevent")) - 1;
			System.out.println("\n\n"+Index+"\n\n");
			ArrayList<EventForm> eventsInDB =  new ArrayList<EventForm>();
			eventsInDB=(ArrayList<EventForm>) session.getAttribute("eventslist");
			System.out.println("\n\n"+eventsInDB.get(Index).getFirst_name()+"\n\n");
			
			EventForm event = new EventForm();
			event=(EventForm)eventsInDB.get(Index);
			session.setAttribute("eventold", event.getEvent_name());
			session.removeAttribute("event");
			session.removeAttribute("oldevent");

			session.setAttribute("event",event);
			session.setAttribute("oldevent",event);


			
			
			url = "/systemuser_modifyeventpage.jsp";
		}
	}else if(action.equals("cancelm")) {
		System.out.println("inside modify selected event");
		if (session.getAttribute("radiou")!=null) {
			int Index = Integer.parseInt((String) session.getAttribute("radiou")) - 1;
			System.out.println("\n\n"+Index+"\n\n");
			ArrayList<EventForm> eventsInDB =  new ArrayList<EventForm>();
			eventsInDB=(ArrayList<EventForm>) session.getAttribute("eventslist");
			System.out.println("\n\n"+eventsInDB.get(Index).getFirst_name()+"\n\n");
			
			EventForm event = new EventForm();
			event=(EventForm)eventsInDB.get(Index);
			session.setAttribute("eventold", event.getEvent_name());
			session.removeAttribute("event");
			session.removeAttribute("oldevent");

			session.setAttribute("event",event);
			session.setAttribute("oldevent",event);


			
			
			url = "/systemuser_modifyeventpage.jsp";
		}
	}
	else if(action.equals("modify_event")) {
		
		EventForm oldevent = (EventForm) session.getAttribute("oldevent");
		String old_eventname = oldevent.getEvent_name();
		String eventold= (String) session.getAttribute("eventold");
		
		
		EventForm ef2 =  (EventForm) session.getAttribute("event");
		
		
		session.removeAttribute("event");
		session.removeAttribute("errorMsgs");
		
		
		ef2.setLast_name(request.getParameter("lname"));
		System.out.println("THE ERROR MESSAGE NEAR(0) THIS: "+request.getParameter("fname"));
		ef2.setFirst_name(request.getParameter("fname"));
		ef2.setStart_date(request.getParameter("startdate"));
		ef2.setStart_time(request.getParameter("starttime"));
		
		
		ef2.setHall_name(request.getParameter("hallname"));
		ef2.setEstimated_attendees(request.getParameter("estattendees"));
		ef2.setEvent_name(request.getParameter("eventname"));	
		ef2.setFood_type(request.getParameter("foodtype"));
		ef2.setMeal(request.getParameter("mealtype"));
		ef2.setMeal_formality(request.getParameter("mealformality"));
		ef2.setEntertainment_items(request.getParameter("entertainmenttype"));
		ef2.setDrink_type(request.getParameter("drinktype"));
		ef2.setDuration(request.getParameter("duration"));

		EventFormErrorMsgs eferrormsgs = new EventFormErrorMsgs();
		
		ef2.validateMoreDateandTime(ef2, eferrormsgs);
		ef2.validateEventForm(ef2, eferrormsgs);

		ef2.validateOnlyNames(ef2, eferrormsgs);
		
//		System.out.println(ef2.getDuration());
//		System.out.println(ef2.getHall_name());
//		System.out.println(ef2.getEstimated_attendees());
//		System.out.println(ef2.getEvent_name());
//		System.out.println(ef2.getFood_type());
//		System.out.println(ef2.getMeal());
//		System.out.println(ef2.getMeal_formality());
//		System.out.println(ef2.getEntertainment_items());
//		System.out.println(ef2.getDrink_type());
//		System.out.println("Error msg is "+eferrormsgs.getErrorMsg());
		
		session.setAttribute("event", ef2);
		session.setAttribute("errorMsgs",eferrormsgs);
		
		if (eferrormsgs.getErrorMsg().equals("")) {

			// Update the new details to the database if there is no error 
			
			EventFormDAO.updateEventByUser(old_eventname, ef2 );
			
		
			url = "/systemuser_eventsummary2.jsp"; 
				
			session.removeAttribute("errorMsgs");
		}
	else {
			
			url = "/systemuser_modifyeventpage.jsp"; 
		}
	
		
	}
		
		
		
		

	
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}
}