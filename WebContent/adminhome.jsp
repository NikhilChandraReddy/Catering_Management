<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CATERING MANAGEMENT</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="main">
		<div class="header">
			<div class="header_resize">

				<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->

				<div class="logo">
					<h1>
						<a href="<c:url value='/' />">Catering Management
							Application</a>
					</h1>
				</div>
				<div class="content">

					<div class="menu_nav">
						<ul>
							<li><a id="search_user" href="searchforuser.jsp" target="_top">Search For User</a></li>
							<li><a href = "/catering_management/UserController?action=ViewProfile">View Profile</a></li>
						</ul>
						<a href="/catering_management/index.jsp" target="_top">LOGOUT</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>