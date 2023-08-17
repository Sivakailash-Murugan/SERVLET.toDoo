package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tasksession extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		if (req.getSession().getAttribute("user")==null) {
			resp.getWriter().print("<h1>session expried</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			req.getRequestDispatcher("AddTask.html").include(req, resp);
		}
		
	}
}
