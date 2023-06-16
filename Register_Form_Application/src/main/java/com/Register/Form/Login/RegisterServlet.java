package com.Register.Form.Login;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
   protected void doPost(HttpServletRequest req , HttpServletResponse res)
   throws ServletException,IOException{
	   PrintWriter pw = res.getWriter();
	   res.setContentType("text/html");
	   UserBean ub = new UserBean();
	   ub.setuName(req.getParameter("uname"));
	   ub.setpWord(req.getParameter("pword"));
	   ub.setfName(req.getParameter("fname"));
	   ub.setlName(req.getParameter("lname"));
	   ub.setAddr(req.getParameter("addr"));
	   ub.setmId(req.getParameter("mid"));
	   ub.setPhno(Long.parseLong(req.getParameter("phno")));
	   int k = new RegisterDAO().register(ub);
	   pw.println("<html><body bgcolor=#ceccd9><center>");
	   if(k>0) {
		   pw.println("User Registered Successfully..<br>");
		   RequestDispatcher rd = req.getRequestDispatcher("login.html");
		   rd.include(req, res);
	   }
	   pw.println("</center></body></html>");
   }
}
