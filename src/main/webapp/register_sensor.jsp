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
	<title>Cadastro do Sensor</title>
</head>
<body>
	<h1>Cadastro de Sensor</h1>
	<h4> Por favor, insira os dados do barril a ser registrado abaixo. </h4>
	<form name="registerSensor" action="RegisterSensor" method="POST">
		<!-- TODO pegar as opções -->
  		Nome do Barril <br/> 
  		<select name="sensor_barrel_name">
  			<option value=""> </option>
  		</select> <br/>
  		
  		Tipo do Sensor<br> 
  		<select name="">
  			<option value="Temperature"> Temperatura </option>
  			<option value="Humidity"> Humidade </option>
  		</select> <br/>
  		
  		Medição do Sensor<br>
  		<input type="number"  step="0.1" name="sensor_value" /> <br/> <br/>
  		
  		<button type="submit">Confirmar</button>
	</form>
</body>
</html>