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
@WebServlet("/edit")
public class EditFileServlet extends HttpServlet{
   protected void doGet(HttpServletRequest req,HttpServletResponse res)
   throws ServletException,IOException{
	 PrintWriter pw =res.getWriter();
	 res.setContentType("text/html");
	 Cookie c[] = req.getCookies();
	 if(c==null) {
		 pw.println("Session Expired...<br>");
		 RequestDispatcher rd = req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }else {
		 ServletContext sct = this.getServletContext();
	     UserBean ub = (UserBean)sct.getAttribute("ub");
	     pw.println("<html><body bgcolor=#000000><center>");
	     pw.println("<form action='update' method='post'>");
	     pw.println("Address : <input type='text' name='addr' value='"+ub.getAddr()+"'>");
	     pw.println("Mail Id : <input type='email' name='mid' value='"+ub.getmId()+"'>");
	     pw.println("Address : <input type='text' name='phno' value='"+ub.getPhno()+"'>");
	     pw.println("<input type='submit' value='Update'>");
	     pw.println("</form>");
	     pw.println("</center></body></html>");
	 }
   }
}
