package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDAo;
import com.entity.user;
@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name=req.getParameter("name");
			String qua=req.getParameter("qua");
			String email=req.getParameter("email");
			String ps=req.getParameter("ps");
		    UserDAo dao=new UserDAo(DBConnect.getConn());
		    user u=new user(name,email,ps,qua,"user");
		    boolean f=dao.adUser(u);
		    HttpSession session=req.getSession();
		    if (f) {
				session.setAttribute("succMsg", "Registration Successfully");
				resp.sendRedirect("signup.jsp");
			}
		    else {
		    	session.setAttribute("succMsg", "something wrong on server");
		    	resp.sendRedirect("signup.jsp");
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
