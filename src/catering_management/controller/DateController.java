package catering_management.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DateController")
public class DateController extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		
		System.out.println("Inside DateController");
		System.out.println(action);
		HttpSession session = request.getSession();
		session.removeAttribute("date");
		session.removeAttribute("time");
		
      LocalDateTime myDateObj = LocalDateTime.now();  
      DateTimeFormatter myDateFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
      
      String formattedDate = myDateObj.format(myDateFormatObj);
    		  
      DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm");  
      String formattedTime = myDateObj.format(myTimeFormatObj);
      
      session.setAttribute("date", formattedDate);
      session.setAttribute("time", formattedTime);
      
     
      getServletContext().getRequestDispatcher("/"+action+".jsp").forward(request, response);
      		
	}

	
	
}