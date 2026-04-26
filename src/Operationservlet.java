package server;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Student;
import model.Model;

@WebServlet("/DeletestdsCtrl")
public class DeletestdsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sid = request.getParameter("sid");
		
		Model md = new Model();
		int page = 1;
		int deletestd = md.deleteStd(sid);
		
		ArrayList<Student> stdList = new ArrayList<Student>();		
		stdList = md.getAllStds(0,5);

		if(deletestd != 0)
		{

			RequestDispatcher rd = request.getRequestDispatcher("viewstds.jsp");
			request.setAttribute("stds", stdList);
			request.setAttribute("pageNo", page);
			request.setAttribute("UDstatus", "Student's Record Delete Successful.");	
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("viewstds.jsp");
			request.setAttribute("stds", stdList);
			request.setAttribute("pageNo", page);
			request.setAttribute("UDfail", "Student's Record Delete Fail.");
			rd.forward(request, response);			
		}
		
	}
}
