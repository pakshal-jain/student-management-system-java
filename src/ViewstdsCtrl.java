package server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Student;
import model.Model;

@WebServlet("/Userlogin")
public class UserLoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String enteruser = request.getParameter("user");
		int enterid = Integer.parseInt(request.getParameter("uid"));
		String enterpass = request.getParameter("upassword");
		
		Model m = new Model();
		Student std =  m.getUserDetails(enterid); 

		HttpSession session = request.getSession();

		if(std == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("res", "User not found in System");
			rd.forward(request, response);
		}
		
		if( enterid == std.getSid() && enterpass.equals(std.getSpassword()) && enteruser.equals(std.getUcode()))
		{
			
//			RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
			response.sendRedirect("adminlogin.jsp");
			//request.setAttribute("user", ul.getUname());
			session.setAttribute("user", std.getSname());
			session.setMaxInactiveInterval(1000 * 60 * 30);
		}
		else	
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("res"," Enter ID or Password not Match");
			rd.forward(request, response);			
		}
	}
}
