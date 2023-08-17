package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Task;
import dto.myuser;

public class update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	myuser user =(myuser)req.getSession().getAttribute("user");
	
		
		
		Task task=new Task();
	task.setTaskname();
	}

}
