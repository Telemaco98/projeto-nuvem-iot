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
	<h1> Por favor, <%=user.getNickname() %>, insira os dados do barril a ser registrado abaixo. </h1>
	
	
	<form>
  		Nome do Barril:<br>
  		<input type="text" name="barrel_name"><br>
  		Data de Envasamento (deixar vazio para registrar como hoje):<br>
  		<input type="date" value="<?php echo date("Y-m-d");?>" name="barrel_birthday">
  		Tipo de Uva:<br>
  		<input type="text" name="barrel_grape"><br>
	</form>
	
	
	
</body>
</html>