package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import dto.Task;
import dto.myuser;
@WebServlet("/addtask")
public class AddTask extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("user")==null) {
			resp.getWriter().print("<h1>This change Task servlet</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		} else {
		String name=req.getParameter("name");
		String description=req.getParameter("description");
		int days=Integer.parseInt(req.getParameter("days"));
		
		Task task1=new Task();
		task1.setTaskname(name);
		task1.setTaskDiscription(description);
		task1.setTaskdate(LocalDate.now());
		task1.setCompletiondate(LocalDate.now().plusDays(days));
		
		userdao userdao=new userdao();
	    userdao.save(task1);
	    
	    
	    
		 myuser user1=(myuser)req.getSession().getAttribute("user");
		 List<Task> list=user1.getTask();
		 if (list==null) 
			list=new ArrayList<Task>();
		 list.add(task1);
		 user1.setTask(list);
		 
		 userdao.update(user1);
		 
		 resp.getWriter().print("<h1 style='color:green'>Task added success</h1>");
		 req.setAttribute("list", user1.getTask());
		 req.getRequestDispatcher("Home.jsp").include(req, resp);
		 
	}
	}
}
