package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import dto.Task;
import dto.myuser;
@WebServlet("/login")
public class Login extends HttpServlet
{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("Password");
		
		userdao userdo=new userdao();
		
		myuser myuser=userdo.findmyemail(email);
		if(myuser==null)
		{
			
			resp.getWriter().print("<h1>Incorrect Email");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		else {
			if(myuser.getPassword().equals(password)) {
				req.getSession().setAttribute("user", myuser);
				req.getSession().setMaxInactiveInterval(30);
				resp.getWriter().print("<h1>Login Successfully");
				
				List<Task> list=myuser.getTask();
				req.setAttribute("list", list);
//				req.getSession().setAttribute("user",myuser);
				req.getRequestDispatcher("Home.jsp").include(req, resp);
				
				
			}else {
				resp.getWriter().print("<h1>Incorrect Password");
				req.getRequestDispatcher("login.html").include(req, resp);		}
		}
		}
}