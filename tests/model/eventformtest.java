package model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import catering_management.data.EventFormDAO;
import catering_management.model.EventForm;
import catering_management.model.EventFormErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class eventformtest {
	
	EventForm eventform;
	EventFormErrorMsgs eventerror;
	EventFormDAO eventdao;
	
	@Before
	public void setUp() throws Exception {
		eventform = new EventForm();
		eventerror = new EventFormErrorMsgs();
		eventdao = new EventFormDAO();
	}

	@Test
	@FileParameters("tests/Excel/event2.csv")
	//@FileParameters("tests/Excel/eventformtests.csv")

	public void test(int testcaseno, String uid, String last_name, String first_name, String start_date, String start_time, String duration, String hall_name,String estimated_attendees, String event_name, String food_type, String meal, String meal_formality, String drink_type, String entertainment_items, double cost, String creditcard_number, String creditcard_expiry, String creditcard_pin, String Error, String last_name_error, String first_name_error, String start_date_error, String start_time_error, String duration_error, String hall_name_error,String estimated_attendees_error, String event_name_error, String creditcard_number_error, String creditcard_expiry_error, String creditcard_pin_error)
	{
		eventform.setEvent(uid, last_name, first_name, start_date, start_time, duration, hall_name, estimated_attendees, event_name, food_type, meal, meal_formality, drink_type, entertainment_items);
		eventform.setEventCC(creditcard_number, creditcard_expiry, creditcard_pin);
		eventform.validateEventForm(eventform, eventerror);
		eventform.validateMoreDateandTime(eventform, eventerror);
		eventform.validateCreditCard(eventform, eventerror);
		eventform.validateOnlyNames(eventform,eventerror);
		
		
		assertTrue(uid.equals(eventform.getUid())); //duration
		assertTrue(last_name.equals(eventform.getLast_name()));
		assertTrue(first_name.equals(eventform.getFirst_name())); //duration
		assertTrue(start_date.equals(eventform.getStart_date())); //duration
		assertTrue(start_time.equals(eventform.getStart_time())); //duration
		assertTrue(duration.equals(eventform.getDuration())); //duration
		assertTrue(hall_name.equals(eventform.getHall_name())); //duration
		assertTrue(estimated_attendees.equals(eventform.getEstimated_attendees()));
		assertTrue(event_name.equals(eventform.getEvent_name()));
		assertTrue(food_type.equals(eventform.getFood_type()));
		assertTrue(meal.equals(eventform.getMeal()));
		assertTrue(meal_formality.equals(eventform.getMeal_formality()));
		assertTrue(drink_type.equals(eventform.getDrink_type()));
		assertTrue(entertainment_items.equals(eventform.getEntertainment_items()));
		assertTrue(creditcard_number.equals(eventform.getCreditcard_number()));
		assertTrue(creditcard_expiry.equals(eventform.getCreditcard_expiry()));
		assertTrue(creditcard_pin.equals(eventform.getCreditcard_pin()));
		
		
		
		assertTrue(last_name_error.equals(eventerror.getLast_nameError())); //duration
		assertTrue(first_name_error.equals(eventerror.getFirst_nameError())); //duration
		assertTrue(start_date_error.equals(eventerror.getStart_dateError())); //duration
		assertTrue(start_time_error.equals(eventerror.getStart_timeError())); //duration
		assertTrue(duration_error.equals(eventerror.getDurationError())); //duration
		assertTrue(hall_name_error.equals(eventerror.getHall_nameError())); //duration
		assertTrue(estimated_attendees_error.equals(eventerror.getEstimated_attendeesError())); //duration
		assertTrue(event_name_error.equals(eventerror.getEvent_nameError())); //duration
		assertTrue(creditcard_number_error.equals(eventerror.getCreditcard_numberError())); //duration
		assertTrue(creditcard_expiry_error.equals(eventerror.getCreditcard_expiryError())); //duration
		assertTrue(creditcard_pin_error.equals(eventerror.getCreditcard_pinError())); //duration
		assertTrue(Error.equals(eventerror.getErrorMsg())); //duration
		if(eventerror.getErrorMsg()=="")
			assertEquals(cost,eventform.totalcost(),0.01);
		//assertTrue(food_type.equals(eventform.getFood_type())); //food type
		//assertTrue(hall_name.equals(eventform.getHall_name())); //hall name
		//assertTrue(meal.equals(eventform.getMeal())); //meal
		//assertTrue(meal_formality.equals(eventform.getMeal_formality())); //meal_formality
		//assertTrue(assigned_to.equals(mar1.getAssigned_to()));
		//eventdao.createEvent(eventform);
		//eventdao.searchEvent(eventform.getFk_username());
		
		
	}
}	