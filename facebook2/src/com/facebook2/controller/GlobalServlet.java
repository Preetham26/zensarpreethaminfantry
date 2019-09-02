package com.facebook2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook2.entity.FacebookEmployee;
import com.facebook2.service.FacebookService;
import com.facebook2.service.FacebookServiceInterface;


public class GlobalServlet extends HttpServlet 
	
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		String option=request.getParameter("ac");
		if(option.equals("register"))
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
		
			FacebookEmployee fe = new FacebookEmployee();
			fe.setName(name);
			fe.setPass(pass);
			fe.setEmail(email);
			fe.setAddress(address);
			//now pass fe object to service layer how?
			//ans is via boject of service layer 
			//so create object using factory design pattern
			//and maintain low coupling via interface
			FacebookServiceInterface fs= FacebookService.createServiceObject();
			//here createServiceObject method is factory method
			int i = fs.createProfile(fe);
			if(i>0)
			{
				out.println("profile created ");
			}
			else
			{
				out.println("could not create profile");
			}
		}
		
	
if(option.equals("login"))
{
}
if(option.equals("timeline")) 
{
}
out.println("</html></body>");
}
}