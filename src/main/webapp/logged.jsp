<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.google.appengine.api.users.User"%>
<%@page import="com.google.appengine.api.users.UserService"%>
<%@page import="com.google.appengine.api.users.UserServiceFactory"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	UserService us = UserServiceFactory.getUserService();
	User user = us.getCurrentUser();
	
	if (user == null) {
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h1> Welcome to WineCloud <%=user.getNickname() %> </h1>
	<h2> ID: <%=user.getUserId() %> </h2>
	<a href= "<%= us.createLogoutURL("index.jsp") %>"> Logout </a> <br/>
	
	<form action="barrels" method="GET">
		<button type="submit"> Ver todos os barris </button>
	</form>
	
	<form action="sensors" method="GET">
		<button type="submit"> Ver sensores de barril </button>
	</form>
	<a href="register_barrel.jsp"> Registrar barril </a> <br/>
	<a href="register_sensor.jsp"> Registrar sensor </a>
	
	
</body>
</html>