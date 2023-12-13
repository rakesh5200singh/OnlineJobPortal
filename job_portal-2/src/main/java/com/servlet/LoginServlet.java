package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.UserDataHandler;

import com.DB.DBConnect;
import com.dao.UserDAo;
import com.entity.user;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String em=req.getParameter("email");
			String ps=req.getParameter("password");
			user u=new user();
			HttpSession session=req.getSession();
			if ("admin@gmail.com".equals(em)&&"admin@121".equals(ps)) {
				session.setAttribute("userobj", u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
			}
			else {
				UserDAo dao=new UserDAo(DBConnect.getConn());
				user us=dao.login(em, ps);
				if (us!=null) {
					session.setAttribute("userobj", us);
					resp.sendRedirect("home.jsp");
				}
				else {
					session.setAttribute("succMsg", "Invalid Email& password");
					resp.sendRedirect("home.jsp");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
