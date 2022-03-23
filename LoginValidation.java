package com.mypack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.bean.User1;
import com.mypack.dao.EmpDao;

@WebServlet("/loginservlet")
public class LoginValidation extends HttpServlet{
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String username= req.getParameter("user");
		String password= req.getParameter("pass");
		
		User1 user=new User1();
		user.setUsername(username);
		user.setPassword(password);
		try{
		EmpDao empDao = new EmpDao();
		Boolean result = empDao.validatin(user);
		
		if(result==true){
			//res.sendRedirect("wel");
			RequestDispatcher rd=req.getRequestDispatcher("wel");
			rd.forward(req, res);
		}else{
			//res.sendRedirect("err");
			RequestDispatcher rd=req.getRequestDispatcher("err");
			rd.forward(req, res);
		}
		}
		
		catch (SQLException e) {
			out.println(e);
		}catch (ClassNotFoundException e) {
			out.println(e);
		}
		out.println("<br><br><a href='index.html'>Back</a>");
}
}