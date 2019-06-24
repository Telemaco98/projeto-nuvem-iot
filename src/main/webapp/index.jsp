<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.google.appengine.api.users.User"%>
<%@page import="com.google.appengine.api.users.UserService"%>
<%@page import="com.google.appengine.api.users.UserServiceFactory"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	UserService us = UserServiceFactory.getUserService();
	User user = us.getCurrentUser();
	
	if (user != null) {
		response.sendRedirect("logged.jsp");
	}
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<title>Winecloud</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="1003569852186-35a9jsgc1punp5fr8ih2aps9odikn977.apps.googleusercontent.com">
</head>

<body>
	<h1>Welcome to Winecloud!</h1>
	
	<table>
		<tr>
			<td>
				<a href="<%= us.createLoginURL("logged.jsp") %>"> Login </a>
			</td>
		</tr>
	</table>
</body>
</html>