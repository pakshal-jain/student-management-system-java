package server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.Student;
import model.Model;

@WebServlet("/UpdatestdsCtrl")
@MultipartConfig(maxFileSize = 1000000) // 1MB

public class UpdatestdsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("sid");
		Model md = new Model();

		Student std = md.getStudentUpdate(sid);	

		if(std != null )
		{
			RequestDispatcher rd  =  request.getRequestDispatcher("updateStd.jsp");
			request.setAttribute("STDInfo", std);
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("/aaStudent/ViewstdsCtrl");
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;

		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		String smobile = request.getParameter("smobile");
		
		if(smobile.length() <10)
		{
			smobile =null;
		}		
		String spassword = request.getParameter("spassword");
		String scourse = request.getParameter("scourse");
		String ucity = request.getParameter("ucity");
		int uage = Integer.parseInt(request.getParameter("uage"));
		String ucode = request.getParameter("ucode");
		
		Part uphoto = request.getPart("uphoto");		
		InputStream im = uphoto.getInputStream();

		int stdUpdate = 0;
		Model md = new Model();

		ArrayList<Student> stdList = new ArrayList<Student>();
		stdList = md.getAllStds(0,5);
		
		Student stdCheck = md.checkRegtedStds(smobile);
			
		if(stdCheck == null)
		{
			Student std = new Student(sid,sname,smobile,spassword,scourse,ucity,uage,ucode);
			stdUpdate = md.StudentUpdate(std, im);
			
			if(stdUpdate != 0 )
			{
				stdList = md.getAllStds(0,5);
				RequestDispatcher rd = request.getRequestDispatcher("viewstds.jsp");
				request.setAttribute("stds", stdList);	
				request.setAttribute("pageNo", page);
				request.setAttribute("UDstatus", std.getUcode()+ " Update Successful..");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("viewstds.jsp");
				request.setAttribute("stds", stdList);	
				request.setAttribute("pageNo", page);
				request.setAttribute("UDfail", std.getUcode()+ "Update Failed...");
				rd.forward(request, response);
			}	
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("viewstds.jsp");
			request.setAttribute("stds", stdList);
			request.setAttribute("UDfail", "User Already Registered given Mobile No.");
			rd.forward(request, response);
		}
	}

}
