package server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = "Raja Shamra";
		String course = "Java Full Stack";
		String mobile = "9777606059";
		String city = "New York";
		
		RequestDispatcher rd = request.getRequestDispatcher("aboutus.jsp");
		
		request.setAttribute("nm", name);
		request.setAttribute("cr", course);
		request.setAttribute("mo", mobile);
		request.setAttribute("ct", city);

		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int a = Integer.parseInt(request.getParameter("amount"));
		int r = Integer.parseInt(request.getParameter("rate"));
		int t = Integer.parseInt(request.getParameter("time"));
		
		int si = a * r * t / 100;
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("intrst", si);
		rd.forward(request, response);		
	}

}
