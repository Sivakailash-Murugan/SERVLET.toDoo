package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import dto.myuser;
@WebServlet("/signup")
public class signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("Password");
		String number=req.getParameter("number");
		String gender=req.getParameter("gender");
		String DOB=req.getParameter("DOB");
		String address=req.getParameter("addr");
		String[] language=req.getParameterValues("lang");
		
	myuser user=new myuser();
	user.setAddress(address);
	user.setDOB(LocalDate.parse(DOB));
	user.setEmail(email);
	user.setGender(gender);
	user.setLanguage(language);
	user.setName(name);
	user.setNumber(Long.parseLong(number));
	user.setPassword(password);
	
		userdao dao=new userdao();
		myuser myuser=dao.findmyemail(email);
		if(myuser==null)
		{
			dao.save(user);	
			req.getRequestDispatcher("login.html").include(req, resp);
			resp.getWriter().print("<h1 style='color:green'>Account Created Successfully</h1>");
		}else {
		resp.getWriter().print("<h1 style='color:green'>Email should not be repeated</h1>");
		req.getRequestDispatcher("signup.html").include(req, resp);
		}

	

}
}
