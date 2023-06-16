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
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet{
   protected void doGet(HttpServletRequest req,HttpServletResponse res)
   throws ServletException,IOException{
	   PrintWriter pw = res.getWriter();
	   res.setContentType("text/html");
	   Cookie c[] = req.getCookies();
	   pw.println("<html><body bgcolor=#ceccd9><center>");
	   if(c==null) {
		   pw.println("Session expired..<br>");
		   RequestDispatcher rd = req.getRequestDispatcher("login.html");
		   rd.include(req, res);
	   }else {
		   String fName = c[0].getValue();
		   pw.println("Page Belongs to "+fName+"<br>");
		   ServletContext sct = this.getServletContext();
		   UserBean ub =(UserBean)sct.getAttribute("ub");
	       pw.println(ub.getuName()+"&nbsp&nbsp&nbsp"
	       		+ub.getlName()+"&nbsp&nbsp&nbsp"
	       		+ub.getAddr()+"&nbsp&nbsp&nbsp"
	       		+ub.getmId()+"&nbsp&nbsp&nbsp"
	       		+ub.getPhno()+"&nbsp&nbsp&nbsp"
	       		+"<a href='edit'>EditProfile</a>"
	       		+"&nbsp&nbsp&nbsp"
	       		+"<a href='logout'>LogOut</a>");
	   }
	   pw.println("</center></body></html>");
   }
}





