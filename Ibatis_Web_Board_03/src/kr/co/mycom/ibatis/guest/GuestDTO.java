package kr.co.mycom.ibatis.guest;

import java.util.Date;

public class GuestDTO {
	//no, name, pwd, email, home, content, regdate
	
	private int no;
	private String name;
	private String pwd;
	private String email;
	private String home;
	private String content;
	private Date regdate;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "GuestDTO [no=" + no + ", name=" + name + ", pwd=" + pwd
				+ ", email=" + email + ", home=" + home + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	
	
}//end
