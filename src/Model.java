package dto;

public class Student {

	private int sid;
	private String sname;
	private String smobile;
	private String spassword;
	private String scourse;
	private String scity;
	private int sage;
	private String ucode;	

	public Student() {
	}
		
	// Get student
	public Student(int sid, String sname, String smobile, String spassword, String scourse, String scity, int sage,
			String ucode) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.smobile = smobile;
		this.spassword = spassword;
		this.scourse = scourse;
		this.scity = scity;
		this.sage = sage;
		this.ucode = ucode;
	}

	// New Insert
	public Student(String sname, String smobile, String spassword, String scourse, String scity, int sage, String ucode) {
		this.sname = sname;
		this.smobile = smobile;
		this.spassword = spassword;
		this.scourse = scourse;
		this.scity = scity;
		this.sage = sage;
		this.ucode = ucode;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getScourse() {
		return scourse;
	}
	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}	
	public String getUcode() {
		return ucode;
	}
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	
}
