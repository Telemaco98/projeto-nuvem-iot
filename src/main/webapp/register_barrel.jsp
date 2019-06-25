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
	<h1>
		Por favor, <%=user.getNickname()%>, insira os dados do barril a ser registrado
		abaixo.
	</h1>
	<form>
		<!-- TODO pegar dos Barris exitentes -->
		<!-- Selecione Barril<br>
		<select>
			<option> </option>
		</select> -->
		
		<input value="">
	</form>
</body>
</html>