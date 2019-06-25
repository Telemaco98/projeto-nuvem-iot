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
	<h1>Cadastro de Barril</h1>
	<h4> Por favor, insira os dados do barril a ser registrado abaixo. </h4>

	<form name="registerBarrel" action="RegisterBarrel" method="POST">
  		Nome do Barril<br>
  		<input type="text" name="barrel_name" required><br/>
  		
  		Data de Envasamento<br>
  		<input type="date" name="barrel_birthday" value="<?php echo date(Y-m-d) ?>" required> <br/>
  		
  		Tipo de Uva<br>
  		<input type="text" name="barrel_grape" required><br/> <br/>
  		
  		<button type="submit">Confirmar</button>
	</form>
</body>
</html>