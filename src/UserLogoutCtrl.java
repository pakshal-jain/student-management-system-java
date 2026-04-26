package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Student;


@WebServlet("/mylogin")
public class Operationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String eid = "admin23";
		String epass = "admin@5550";
		
		String enterid = request.getParameter("uid");
		String enterpass = request.getParameter("upass");
		
		System.out.println(enterid +" "+enterpass);
		if(enterid.equals(eid) && enterpass.equals(epass))
		{
			RequestDispatcher rd = request.getRequestDispatcher("viewstds.html");
			rd.forward(request, response);
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.print("Incorrect ID or Password");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String eid = "admin23";
//		String epass = "admin@5550";
//		String uname = "ADMIN";
		
		int sid = 0;
		String spass = null;
//		String sname = null;
		
		Student std = null;
		
		int enterid = Integer.parseInt(request.getParameter("uid"));
		String enterpass = request.getParameter("upass");
		
//		System.out.println(enterid +" "+enterpass);

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/projectA", "root", "root211");
			
			PreparedStatement ps = con.prepareStatement("select * from student where sid = ?");
			ps.setInt(1, enterid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				std = new Student(rs.getInt("sid"), rs.getString("sname"), rs.getString("smobile"),rs.getString("spassword"), rs.getString("scourse"), rs.getString("scity"), rs.getInt("sage"), rs.getString("ucode"));
			}
			
			sid = std.getSid();
			spass = std.getSpassword();
//			sname = std.getSname();		
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}	
		
		if(enterid == sid && enterpass.equals(spass))
		{
			RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
			request.setAttribute("std", std);
			rd.forward(request, response);
		}
		else
		{
//			PrintWriter out = response.getWriter();
//			out.print("Incorrect ID or Password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("res", "Invalid Loign Details");
			rd.forward(request, response);
		}	
	}

}
