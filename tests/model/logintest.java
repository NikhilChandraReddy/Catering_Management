package model;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import catering_management.data.LoginDAO;
import catering_management.model.Login;
import catering_management.model.LoginErrorMsg;
import catering_management.model.Registration;
import catering_management.model.RegistrationErrorMsg;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class logintest {
	
	Login login;
	LoginErrorMsg LoginEerr;
	LoginDAO loginDao;
	
	@Before
	public void setUp() throws Exception {
		login = new Login();
		LoginEerr = new LoginErrorMsg();
		loginDao = new LoginDAO();
	}

	@Test
	@FileParameters("tests/Excel/logintestcases.csv")
	public void test(int testcaseno, String username, String password, String error_msg,String username_error,String password_error) {
		login.setLogin(username,password);
//	Following 2 lines added to get complete JaCoCo coverage
//		@SuppressWarnings("unused")
//		String dummy=login.getFk_username();
//		login.setFk_username(username);
		login.validateLogin(login, LoginEerr);
		assertTrue(error_msg.equals(LoginEerr.getErrorMsg()));
		assertTrue(username_error.equals(LoginEerr.getusernameError())); //Username Error
		assertTrue(password_error.equals(LoginEerr.getpasswordError())); //Password Error
		loginDao.UserLogin(login);
	}
}