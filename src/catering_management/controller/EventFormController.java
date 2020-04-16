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

import catering_management.data.EventFormDAO;
import catering_management.data.RegistrationDAO;
import catering_management.model.*;

@WebServlet("/EventFormController")
public class EventFormController extends HttpServlet {
	




	private double totalcost( String usergivenhallname, String numberOfHours, String mealtype, String estimatedAttendees,String mealformality, String drinktype, String entertainment) {

		double totalcost = 0;
		double mealformalityadditionalcost = 1.0;
		
		Hashtable<String, String> hallname = new Hashtable<String, String>();
		hallname.put("Maverick", "100");
		hallname.put("KC",  "25");
		hallname.put("Arlington", "50" );
		hallname.put("Shard", "25" );
		hallname.put("Liberty", "75" );
		
		Hashtable<String, String> numofhours = new Hashtable<String, String>();
		numofhours.put("2 Hours", "2");
		numofhours.put("3 Hours",  "3");
		numofhours.put("4 Hours", "4" );
		numofhours.put("5 Hours", "5" );
		numofhours.put("6 Hours", "6" );
		numofhours.put("7 Hours", "7" );
		numofhours.put("8 Hours", "8" );
		
		
		
		totalcost = Integer.parseInt(hallname.get(usergivenhallname))*2*Integer.parseInt(numofhours.get(numberOfHours));

		if (mealformality.equals("formal")) {
			mealformalityadditionalcost =  1.5;	
		}

		Hashtable<String, String> meal = new Hashtable<String, String>();
		meal.put("BreakFast", "8");
		meal.put("Lunch",  "12");
		meal.put("Supper", "18" );
		
//		System.out.println("Estimated Attendees: "+ estimatedAttendees);
//		System.out.println("Meal Type: "+ mealtype);
		
		totalcost = totalcost + ( Integer.parseInt(estimatedAttendees)*Integer.parseInt(meal.get(mealtype))* mealformalityadditionalcost);

		if (drinktype.equals("Alcohol")) {
			totalcost += Integer.parseInt(estimatedAttendees)*15;

		}

		if (entertainment.equals("Music")) {
			totalcost += 50;
		}

		return totalcost;

	}




	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();
		session.removeAttribute("registration");
		EventForm ef = new EventForm();
		//Set time and date
		if (action.equals("save_date")) {
			System.out.println((String)session.getAttribute("login_lastname"));
			System.out.println((String)session.getAttribute("login_firstname"));
			ef.setLast_name((String)session.getAttribute("login_lastname"));
			ef.setUid((String)session.getAttribute("login_uid"));;
			ef.setLast_name((String)session.getAttribute("login_lastname"));
			ef.setLast_name((String)session.getAttribute("login_lastname"));
			ef.setFirst_name((String)session.getAttribute("login_firstname"));
			ef.setStart_date(request.getParameter("startdate"));
			ef.setStart_time(request.getParameter("starttime"));
			
			EventFormErrorMsgs eferrormsgs = new EventFormErrorMsgs();
			
			ef.validateMoreDateandTime(ef, eferrormsgs);
			

			session.setAttribute("event",ef);
			session.setAttribute("errorMsgs",eferrormsgs);
			
			if (eferrormsgs.getStart_dateError().equals("") && eferrormsgs.getStart_timeError().equals("")) {
				
					URL = "/reserveevent.jsp"; 
						
					session.removeAttribute("errorMsgs");
				}
			else {
					//session.removeAttribute("registration");
					URL = "/datepage.jsp"; 
				}
			}
		else if(action.equals("save_reservation_details")){
			EventForm ef2 =  (EventForm) session.getAttribute("event");
			session.removeAttribute("event");
			session.removeAttribute("errorMsgs");
			
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
			
			ef2.validateEventForm(ef2, eferrormsgs);
			
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

				// Calculate cost only after all the validations are checked
				ef2.setCost(totalcost(ef2.getHall_name(), ef2.getDuration(), ef2.getMeal(), ef2.getEstimated_attendees(), ef2.getMeal_formality(), ef2.getDrink_type(), ef2.getEntertainment_items()));
				
				session.removeAttribute("event");
				session.setAttribute("event", ef2);
				
				System.out.println("Calculated Cost is "+ef2.getCost());
				URL = "/creditcard.jsp"; 
					
				session.removeAttribute("errorMsgs");
			}
		else {
				//session.removeAttribute("registration");
				URL = "/reserveevent.jsp"; 
			}
			
			
		}
		else if (action.equals("save_card_details")) {
			
			
			EventForm ef3 =  (EventForm) session.getAttribute("event");
			session.removeAttribute("event");
			
			ef3.setCreditcard_number(request.getParameter("creditcardnumber"));
			ef3.setCreditcard_expiry(request.getParameter("exp_date"));
			ef3.setCreditcard_pin(request.getParameter("creditcardpin"));
			


			EventFormErrorMsgs eferrormsgs = new EventFormErrorMsgs();
			
			ef3.validateCreditCard(ef3, eferrormsgs);
			
			
			session.setAttribute("event", ef3);
			session.setAttribute("errorMsgs",eferrormsgs);
			
			if (eferrormsgs.getErrorMsg().equals("")) {

				// Calculate cost only after all the validations are checked

				URL = "/eventsummary.jsp"; 
					
				session.removeAttribute("errorMsgs");
			}
		else {
				//session.removeAttribute("registration");
				URL = "/creditcard.jsp"; 
			}
			
			
			
		}
		else if(action.equals("save_event_summary_details")) {
			/*
			 * 
			 * Write the logic for storing the data into database
			 * 
			 */
			EventForm ef4 =  (EventForm) session.getAttribute("event");
			session.removeAttribute("event");
			ef4.setEventStatus("Reserved");
			session.setAttribute("event", ef4);
			
			EventFormDAO.SaveEvent(ef4);
			
			
			
			URL = "/userhomepage.jsp";
			
		}
		
		else{
				URL = "/reserveevent.jsp"; 
		}
			
			url = URL; 
	
		getServletContext().getRequestDispatcher(url).forward(request, response);		
}
}