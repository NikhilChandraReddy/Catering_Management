<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<h1>Payment Information </h1>  
<form action="/catering_management/EventFormController?action=save_card_details" method="post">  
<table>  
<tr> <td> Cost: </td> <td> <input type = 'text' value = '${event.cost}' disabled/> </td> </tr>
<tr>
<td>Credit Card Number:</td>
<td><input type="text" name="creditcardnumber" value = '${event.getCreditcard_number()}'></td>
<td><input name="card_numberError" value="<c:out value='${errorMsgs.creditcard_numberError}' />" type = "text" class="errorMsg" > </td>
</tr>  

  <tr>
<td>Exp Date:</td>
<td><input type="text" name="exp_date" value = '${event.getCreditcard_expiry()}'></td>
<td><input name="card_expiryError" value="<c:out value='${errorMsgs.creditcard_expiryError}' />" type = "text" class="errorMsg" > </td>
</tr>  
  
  <tr>
<td>Credit Card Pin:</td>
<td><input type="text" name="creditcardpin" value = '${event.getCreditcard_pin()}'></td>
<td><input name="card_pinError" value="<c:out value='${errorMsgs.creditcard_pinError}' />" type = "text" class="errorMsg" > </td>
</tr>  



  <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
</table>  
</form>  
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>