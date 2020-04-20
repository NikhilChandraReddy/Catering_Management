package model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import catering_management.model.User;
import catering_management.model.UserErrorMsg;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class usertest {

	User usr;
	UserErrorMsg UerrorMsg;

	@Before
	public void setUp() throws Exception {
		usr = new User();
		UerrorMsg = new UserErrorMsg();
	}

	@Test
	//@FileParameters("tests/Excel/eventtestcase.csv")
	@FileParameters("tests/Excel/usertests.csv")
	public void test(int testcaseNo, String username, String password, String first_name, String last_name, String role, String uta_id, String phone, String email, String street_number, String street_name, String city, String state, String zip_code, String action, String errorMsg, String lastname_error, String username_error, String role_error) {

		usr.setUser(username, password, last_name, first_name, role, uta_id, phone, email, street_number, street_name, city, state, zip_code);
		
		usr.validateUserMore( usr, UerrorMsg);
		
		assertTrue(username.equals(usr.getUsername()));
		assertTrue(password.equals(usr.getPassword()));
		assertTrue(first_name.equals(usr.getFirstName()));
		assertTrue(last_name.equals(usr.getLastName()));
		assertTrue(role.equals(usr.getRole()));
		assertTrue(uta_id.equals(usr.getUtaId()));
		assertTrue(phone.equals(usr.getPhone()));
		assertTrue(email.equals(usr.getEmail()));
		assertTrue(street_number.equals(usr.getStreet_Number()));
		assertTrue(street_name.equals(usr.getStreet_Name()));
		assertTrue(city.equals(usr.getCity()));
		assertTrue(state.equals(usr.getState()));
		assertTrue(zip_code.equals(usr.getZipCode()));
		
		assertTrue(errorMsg.equals(UerrorMsg.getErrorMsg()));
		assertTrue(username_error.equals(UerrorMsg.getUsernameError()));
		assertTrue(lastname_error.equals(UerrorMsg.getLastNameError()));
		assertTrue(role_error.equals(UerrorMsg.getRoleError()));
	}
}
