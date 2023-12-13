package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAo;
import com.entity.jobs;

@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String title=req.getParameter("title");
			String location=req.getParameter("location");
			String category=req.getParameter("category");
			String status=req.getParameter("status");
			String desc=req.getParameter("desc");
			
			jobs j=new jobs();
			j.setId(id);
			j.setTitle(title);
			j.setLocation(location);
			j.setDescription(desc);
			j.setCategory(category);
			j.setStatus(status);
			
            HttpSession session=req.getSession();
			
			JobDAo dAo=new JobDAo(DBConnect.getConn());
			boolean f=dAo.updateJob(j);
			if (f) {
				session.setAttribute("succMsg","jobs update Successfully..");
				resp.sendRedirect("view_jobs.jsp");
			}
			else {
				session.setAttribute("succMsg", "job Post successfully...");
				resp.sendRedirect("view_jobs.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
