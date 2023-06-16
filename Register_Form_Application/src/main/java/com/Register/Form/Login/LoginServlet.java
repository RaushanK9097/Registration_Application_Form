package com.Register.Form.Login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	UserBean ub = new LoginDAO().login(req);
    	pw.println("<html><body bgcolor=#ffcc00><center>");
    	if(ub==null) {
    		
    		pw.println("Invalid User or Password...");
    		RequestDispatcher rd = req.getRequestDispatcher("login.html");
    		rd.include(req, res);
    	}else {
    		ServletContext sct = this.getServletContext();
    		sct.setAttribute("ub", ub);
    		Cookie ck = new Cookie("fname",ub.getfName());
    		res.addCookie(ck);
    		//Serialization process
    		pw.println("WelCome User "+ub.getfName()+"<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("link.html");
    		rd.include(req, res);
    		
    	}
    	pw.println("</center></body></html>");
    }
}
