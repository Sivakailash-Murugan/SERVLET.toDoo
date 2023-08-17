package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import dto.Task;
import dto.myuser;
@WebServlet("/changestatus")
public class changestatus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myuser user=(myuser)req.getSession().getAttribute("user");
		if ("user"==null) {
			resp.getWriter().print("<h1>This change Task servlet</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			int id=Integer.parseInt(req.getParameter("id"));
			userdao dao=new userdao();
			Task task=dao.fetchtask(id);
			
			if(task.isStatus())
				task.setStatus(false);
			else
				task.setStatus(true);
			
			dao.update(task);
			
			myuser user1=dao.findmyemail(user.getEmail());
			req.getSession().setAttribute("user", user1);
			resp.getWriter().print("<h1>Status changed succesfully</h1>");
			
			req.setAttribute("list", user.getTask());
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		}
	}

}
