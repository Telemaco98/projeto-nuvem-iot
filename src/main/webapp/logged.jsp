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
	} else  {
		System.out.println(user.getNickname());
	}
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h1>
		Hi <%=user.getNickname() %> How are you?
	</h1>
	<a href= "<%= us.createLogoutURL("index.jsp") %>">Logout </a>
</body>
</html>