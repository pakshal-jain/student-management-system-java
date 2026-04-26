package server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

/**
 * Servlet implementation class GetPhoto
 */
@WebServlet("/GetPhoto")
public class GetPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String sid = request.getParameter("sid");
		
		Model md =  new Model();
		byte[] getphoto = md.getUphoto(sid);
		
		if(getphoto != null)
		{			
			ServletOutputStream os = response.getOutputStream();
			os.write(getphoto);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
