package br.ufrn.imd.winecloud.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import br.ufrn.imd.winecloud.business.BarrelServices;
import br.ufrn.imd.winecloud.entity.Barrel;

public class RegisterBarrel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		
		if (user == null) resp.sendRedirect("index.jsp");
		
		resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF8");
		
		try {
	        String id 			= req.getParameter("barrel_name");
	        String dob_str		= req.getParameter("barrel_birthday");
	        String grapeType 	= req.getParameter("barrel_grape");
			
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dob_str);
			
			Barrel barrel = new Barrel(id, dob, grapeType);
	        BarrelServices barrelServices = new BarrelServices(barrel, user);
	        barrelServices.registerBarrel();
	        
	        resp.sendRedirect("logged.jsp");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}
