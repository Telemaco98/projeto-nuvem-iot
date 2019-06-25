package br.ufrn.imd.winecloud.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import br.ufrn.imd.winecloud.business.ConnectionUtils;

public class Barrels extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		if (user == null) resp.sendRedirect("index.jsp");

//		URL url = new URL("http://www.omdbapi.com/?apikey=7a8ad7b1&s=game");		
		URL url = new URL("http://"+ ConnectionUtils.IP + ":"+ ConnectionUtils.PORT_ORION +"/v2/entities?type=" + user.getUserId() + "_barrel");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer json = new StringBuffer();
		String line;

		while ((line = reader.readLine()) != null) {
		  json.append(line);
		}
		reader.close();
		
		out.print(json.toString());
	}
}