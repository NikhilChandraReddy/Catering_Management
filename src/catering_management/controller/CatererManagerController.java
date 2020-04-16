package catering_management.controller;



import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import catering_management.data.EventFormDAO;
import catering_management.data.UserDAO;
import catering_management.model.*;

@WebServlet("/CatererManagerController")
public class CatererManagerController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();
		EventForm ef = new EventForm();
		System.out.println("Action = "+action 	);
		session.removeAttribute("errorMsgs");

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
					
					eventsInDB = CatererManagerDAO.getEvents(date,time);
					session.setAttribute("eventslist", eventsInDB);
					url = "/caterereventsummary.jsp";
				}
			else {
					//session.removeAttribute("registration");
					url = "/catererdatepage.jsp"; 
				}		
			
		}
		else if(action.equals("searchforstaffs")) {
			System.out.println("inside searchForStaff");

			String lastname = request.getParameter("last_name");
			String firstname = request.getParameter("first_name");
			System.out.println("lastname = " + lastname);
			System.out.println("firstname = " + firstname);
			session.removeAttribute("errorMsgs");
			
			User user = new User();
			user.setUser("","", lastname, firstname, "", "", "","","","","","","");
			ArrayList<User> userlist =  new ArrayList<User>();
			userlist = UserDAO.getstaff(lastname,firstname);
			System.out.println(userlist.size());
			String mainerror = "";
			
			EventForm event = new EventForm();
			event=(EventForm) session.getAttribute("event");
			if(userlist.size()==0) {
				
				mainerror="No Such Last name first name combination exists";
				session.setAttribute("mainerror", mainerror);
				session.setAttribute("user", user);
				url = "/searchforstaff.jsp";
				
			}else
			{
				System.out.println(userlist.get(0).getLastName());
				System.out.println(userlist.get(0).getFirstName());
				event.setAssigned_lname(userlist.get(0).getLastName());
				event.setAssigned_fname(userlist.get(0).getFirstName());
				session.setAttribute("event", event);
				EventFormDAO.assignstaff(event.getEvent_name(),event.getAssigned_lname(),event.getAssigned_fname());
				url = "/caterermanager_assignsummary.jsp";
			}
			
		/*
		 * user.validateUser(action, user, usererrorMsgs);
		 * System.out.println("after validateUser");
		 * 
		 * ArrayList<User> userInDB = new ArrayList<User>(); ArrayList<EventForm>
		 * eventsInDB = new ArrayList<EventForm>(); eventsInDB=(ArrayList<EventForm>)
		 * session.getAttribute("eventslist");
		 * System.out.println("\n\n"+eventsInDB.get(Index).getEvent_name()+"\n\n");
		 * 
		 * EventForm event = new EventForm(); event=eventsInDB.get(Index);
		 * session.removeAttribute("event"); session.setAttribute("event",event);
		 * 
		 * 
		 * url = "/caterermanager_eventsummary.jsp";
		 */
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
				
				url = "/caterermanager_eventsummary.jsp";
			}
			
		}else if(action.equals("Modify Selected Event")) {
			System.out.println("inside modify selected event");
			session.setAttribute("radio", request.getParameter("radioevent"));
			if (request.getParameter("radioevent")!=null) {
				
				int Index = Integer.parseInt(request.getParameter("radioevent")) - 1;
				System.out.println("\n\n"+Index+"\n\n");
				
				ArrayList<EventForm> eventsInDB =  new ArrayList<EventForm>();
				eventsInDB=(ArrayList<EventForm>) session.getAttribute("eventslist");
				System.out.println("\n\n"+eventsInDB.get(Index).getFirst_name()+"\n\n");
				
				EventForm event = new EventForm();
				event=eventsInDB.get(Index);
				session.removeAttribute("event");
				System.out.println("\n\n setting oldevent\n\n");
				session.removeAttribute("oldevent");

				System.out.println("THE ERROR MESSAGE NEAR(-1) THIS: "+event.getFirst_name());
				session.setAttribute("event",event);
				session.setAttribute("oldevent",event);
				session.setAttribute("eventold", event.getEvent_name());
				EventForm oe = (EventForm) session.getAttribute("oldevent");
				System.out.println("The old event name is set to "+oe.getEvent_name());

				
				url = "/caterermanager_modifyeventpage.jsp";
			}
			
			
		}	else if(action.equals("cancel")) {
			System.out.println("inside cancel ");
			
			
			if (session.getAttribute("radio")!=null) {
				
				int Index = Integer.parseInt((String) session.getAttribute("radio")) - 1;
				System.out.println("\n\n"+Index+"\n\n");
				
				ArrayList<EventForm> eventsInDB =  new ArrayList<EventForm>();
				eventsInDB=(ArrayList<EventForm>) session.getAttribute("eventslist");
				System.out.println("\n\n"+eventsInDB.get(Index).getFirst_name()+"\n\n");
				
				EventForm event = new EventForm();
				event=eventsInDB.get(Index);
				session.removeAttribute("event");
				System.out.println("\n\n setting oldevent\n\n");
				session.removeAttribute("oldevent");

				System.out.println("THE ERROR MESSAGE NEAR(-1) THIS: "+event.getFirst_name());
				session.setAttribute("event",event);
				session.setAttribute("oldevent",event);
				session.setAttribute("eventold", event.getEvent_name());
				EventForm oe = (EventForm) session.getAttribute("oldevent");
				System.out.println("The old event name is set to "+oe.getEvent_name());

				
				url = "/caterermanager_modifyeventpage.jsp";
			}
			
			
		}else if(action.equals("modify_event") ) {
			
			
			
			EventForm oldevent = (EventForm) session.getAttribute("oldevent");
			String old_eventname = oldevent.getEvent_name();
			String eventold= (String) session.getAttribute("eventold");
			System.out.println("The old event name after retrieving is "+old_eventname);
			System.out.println("The old event name after retrieving is "+eventold);
			
			EventForm ef2 =  (EventForm) session.getAttribute("event");
			
			session.removeAttribute("event");
			session.removeAttribute("errorMsgs");
			
			
			ef2.setLast_name(request.getParameter("lname"));
			System.out.println("THE ERROR MESSAGE NEAR(0) THIS: "+request.getParameter("fname"));
			ef2.setFirst_name(request.getParameter("fname"));
			ef2.setAssigned_lname(request.getParameter("Assigned_lname"));
			ef2.setAssigned_fname(request.getParameter("Assigned_fname"));
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
			System.out.println("THE ERROR MESSAGE NEAR(1) THIS: "+ef2.getFirst_name());

			ef2.validateNames(ef2, eferrormsgs);
			
//			System.out.println(ef2.getDuration());
//			System.out.println(ef2.getHall_name());
//			System.out.println(ef2.getEstimated_attendees());
//			System.out.println(ef2.getEvent_name());
//			System.out.println(ef2.getFood_type());
//			System.out.println(ef2.getMeal());
//			System.out.println(ef2.getMeal_formality());
//			System.out.println(ef2.getEntertainment_items());
//			System.out.println(ef2.getDrink_type());
//			System.out.println("Error msg is "+eferrormsgs.getErrorMsg());
			
			session.setAttribute("event", ef2);
			session.setAttribute("errorMsgs",eferrormsgs);
			
			if (eferrormsgs.getErrorMsg().equals("")) {

				// Update the new details to the database if there is no error 
			EventFormDAO.updateEvent(old_eventname, ef2 );
				
			
				url = "/caterermanager_eventsummary.jsp"; 
					
				session.removeAttribute("errorMsgs");
			}
		else {
				
				url = "/caterermanager_modifyeventpage.jsp"; 
			}
		
			
		}else if(action.equals("Assign Staff")) {
			System.out.println("inside assign");
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
				
				url = "/searchforstaff.jsp";
			}
			
		}		else if(action.equals("back")) {
			EventForm ef2 = new EventForm();
			
			  LocalDateTime myDateObj = LocalDateTime.now();  
		      DateTimeFormatter myDateFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		      
		      String date = myDateObj.format(myDateFormatObj);
		    		  
		      DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm");  
		      String time = myDateObj.format(myTimeFormatObj);
		      
		      
		        ef2.setStart_date(date);
				ef2.setStart_time(time);
				
				
				
				
				session.removeAttribute("event");
				session.setAttribute("event",ef2);
				
						
				session.removeAttribute("errorMsgs");
				ArrayList<EventForm> eventsInDB =  new ArrayList<EventForm>();
				
				eventsInDB = CatererManagerDAO.getEvents(date,time);
				
				session.removeAttribute("eventslist");
				session.setAttribute("eventslist", eventsInDB);

						url = "/caterereventsummary.jsp";
		      
		      
		      
			
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);		

		
	}
	
}