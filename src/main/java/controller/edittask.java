package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
@WebServlet("/edittask")
public class edittask extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
 {	
	 if (req.getSession().getAttribute("user")==null) {
		 resp.getWriter().print("<h1>This change Task servlet</h1>");
		 req.getRequestDispatcher("login.html").include(req, resp);
	
	 } else {
		 	int id=Integer.parseInt(req.getParameter("id"));
		 	userdao dao=new userdao();
		 	req.setAttribute("task", dao.fetchtask(id));
		 	req.getRequestDispatcher("edittask.jsp").forward(req, resp);
	 		}
 }
}