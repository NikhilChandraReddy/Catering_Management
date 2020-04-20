package model;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import catering_management.data.LoginDAO;
import catering_management.data.RegistrationDAO;
import catering_management.model.Login;
import catering_management.model.LoginErrorMsg;
import catering_management.model.Registration;
import catering_management.model.RegistrationErrorMsg;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class registrationtest {
	
	Registration registration;
	RegistrationErrorMsg registrationErr;
	RegistrationErrorMsg errorMsgs;
	RegistrationDAO registrationDao;
	
	@Before
	public void setUp() throws Exception {
		registration = new Registration();
		registrationErr = new RegistrationErrorMsg();
		errorMsgs = new RegistrationErrorMsg();
		registrationDao = new RegistrationDAO();
	}

	@Test
	@FileParameters("tests/Excel/registratontestcase.csv")
	public void test(int testcaseno, String username, String password, String last_name, String first_name,String role, String uta_id, String phone, String email,String street_number,String street_name, String city, String state, String zip_code, String error_msg,String username_error,String password_error, String last_name_error, String first_name_error,String role_error, String uta_id_error, String phone_error, String email_error,String street_number_error,String street_name_error, String city_error, String state_error, String zip_code_error) {
		registration.setRegistration (username, password, last_name,  first_name,role, uta_id, phone,email,street_number,street_name,city,state,zip_code);
//	Following 2 lines added to get complete JaCoCo coverage
//		@SuppressWarnings("unused")
//		String dummy=login.getFk_username();
//		login.setFk_username(username);
		registration.validateRegistration (registration, registrationErr);
		registration.validateRegistrationnotrole(registration, errorMsgs);
		assertTrue(error_msg.equals(registrationErr.getErrorMsg()));
		assertTrue(username_error.equals(registrationErr.getusernameError())); //Username Error
		
		System.out.println(registrationErr.getpasswordError());
		System.out.println(password_error);
		assertTrue(password_error.equals(registrationErr.getpasswordError())); //Password Error
		assertTrue(last_name_error.equals(registrationErr.getlast_nameError()));
		assertTrue(first_name_error.equals(registrationErr.getfirst_nameError()));
		assertTrue(role_error.equals(registrationErr.getroleError()));
		assertTrue(uta_id_error.equals(registrationErr.getutaIDError()));
		assertTrue(phone_error.equals(registrationErr.getphoneError()));
		assertTrue(email_error.equals(registrationErr.getemailError()));
		assertTrue(street_number_error.equals(registrationErr.getstreet_numberError()));
		assertTrue(street_name_error.equals(registrationErr.getstreet_nameError()));
		assertTrue(city_error.equals(registrationErr.getcityError()));
		assertTrue(state_error.equals(registrationErr.getstateError()));
		assertTrue(zip_code_error.equals(registrationErr.getzipcodeError()));
		
		registrationDao.Register(registration);
	}
}