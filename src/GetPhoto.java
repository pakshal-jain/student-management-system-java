package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Student;

public class Model {

	// Create Connection
	public Connection connect()
	{
		Connection con =null;
		final String URL = "jdbc:mysql://localhost:3308/projectA"; 
		final String USER = "root";
		final String PASSWORD = "root211";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

	// Get User Information
	public Student getUserDetails(int enterid) {
		Student std = null;
		Connection con = null;
		try
		{
				con = connect();
				PreparedStatement ps = con.prepareStatement("select * from student where sid = ? ");
				ps.setInt(1, enterid);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					std = new Student(rs.getInt("sid"), rs.getString("sname"), rs.getString("smobile"),rs.getString("spassword"),rs.getString("scourse"),rs.getString("scity"),rs.getInt("sage"),rs.getString("ucode"));
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return std;
	}

	public int StudentRegister(Student std, InputStream im) {
		int regstatus = 0;
		Connection con =null;
		
		try
		{
			con = connect();
			String regSQL = "insert into student(sname,smobile,spassword,scourse,scity,sage,ucode, sphoto) value(?,?,?, ?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(regSQL);

			ps.setString(1, std.getSname());
			ps.setString(2, std.getSmobile());
			ps.setString(3, std.getSpassword());
			ps.setString(4, std.getScourse());
			ps.setString(5, std.getScity());
			ps.setInt(6, std.getSage());
			ps.setString(7, std.getUcode());
			ps.setBlob(8, im);
			
			regstatus = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return regstatus;
	}

	public Student checkRegtedStds(String entsmobile) {
		Student chechRegStd = null;
		Connection con = null;
		
		try
		{
			con = connect();
			String checkStdSQL = "select * from student where smobile = ?";
			PreparedStatement ps = con.prepareStatement(checkStdSQL);
			ps.setString(1, entsmobile);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				chechRegStd = new Student(rs.getString("sname"), rs.getString("smobile"),rs.getString("spassword"),rs.getString("scourse"),rs.getString("scity"),rs.getInt("sage"), rs.getString("ucode"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return chechRegStd;
	}

	public ArrayList<Student> getAllStds(int nextPage, int records) {
		ArrayList<Student> stdList = new ArrayList<Student>();
		Connection con = null;		

		try
		{
			con = connect();
			String getAllStdsSQL = "select * from student limit ?, ?";			
			PreparedStatement ps = con.prepareStatement(getAllStdsSQL);
			ps.setInt(1, nextPage);
			ps.setInt(2, records);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Student std = new Student(rs.getInt("sid"), rs.getString("sname"), rs.getString("smobile"), rs.getString("spassword"), rs.getString("scourse"), rs.getString("scity"), rs.getInt("sage"), rs.getString("ucode"));
				stdList.add(std);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stdList;
	}

	public int deleteStd(String sid) {
		int deletestd = 0;
		Connection con = null;
		
		try
		{
			con = connect();
			String deleteSQL = "delete from student where sid = ?";
			PreparedStatement ps = con.prepareStatement(deleteSQL);
			ps.setString(1, sid);
			
			deletestd = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return deletestd;
	}

	public Student getStudentUpdate(String sid) {
		Student std = null;
		Connection con = null;
		
		try
		{
			con = connect();
			String getStdSQL = "select * from student where sid = ?";
			PreparedStatement ps = con.prepareStatement(getStdSQL);
			ps.setString(1, sid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				std = new Student(rs.getInt("sid"), rs.getString("sname"), rs.getString("smobile"), rs.getString("spassword"), rs.getString("scourse"), rs.getString("scity"), rs.getInt("sage"),rs.getString("ucode"));				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return std;
	}

	public int StudentUpdate(Student std, InputStream im) {
		int stdupdate = 0;
		Connection con = null;
		try
		{
			con = connect();
			String stdUpdateSQL = "update student set sname = ?, smobile=?,  spassword = ?, scourse=?, scity=?,sage=?, ucode = ?, sphoto = ? where sid = ?";
			PreparedStatement ps = con.prepareStatement(stdUpdateSQL);
			ps.setString(1, std.getSname());
			ps.setString(2, std.getSmobile());
			ps.setString(3, std.getSpassword());
			ps.setString(4, std.getScourse());
			ps.setString(5, std.getScity());
			ps.setInt(6, std.getSage());
			ps.setString(7, std.getUcode());
			ps.setBlob(8, im);
			ps.setInt(9, std.getSid());
			
			stdupdate = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stdupdate;
	}

	public byte[] getUphoto(String sid) {
		byte[] getphoto = null;
		Connection con = null;
		try
		{
			con = connect();
			String getPhotoSQL = "select sphoto from student where sid = ?";
			PreparedStatement ps = con.prepareStatement(getPhotoSQL);
			ps.setString(1, sid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				getphoto = rs.getBytes("sphoto");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return getphoto;
	}


	
	
}
