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


@WebServlet("/deletetask")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myuser myUser = (myuser) req.getSession().getAttribute("myUser");
		if (myUser == null) {
			resp.getWriter().print("<h1 style='color:red'>Session Expired</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			int id=Integer.parseInt(req.getParameter("id"));
			userdao dao=new userdao();
			Task task=dao.fetchtask(id);
			
			//logic to remove mapping
			myUser.getTask().remove(task);
			dao.update(myUser);
			//logic to delete
			dao.remove(task);
			
			myuser user1=dao.findmyemail(myUser.getEmail());
			req.getSession().setAttribute("user", user1);
			resp.getWriter().print("<h1>Status changed succesfully</h1>");
			
			req.setAttribute("list", myUser.getTask());
			req.getRequestDispatcher("Home.jsp").include(req, resp);

			
		}
	}
}
