package kosta.ibatis.dto;

public class UserDto {
	private String userid;
	private String username;
	private String userpwd;
	private String usercmt;
	
	public UserDto(){}
	public UserDto(String userid , String username, String userpwd , String usercmt)
	{
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.usercmt = usercmt;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsercmt() {
		return usercmt;
	}
	public void setUsercmt(String usercmt) {
		this.usercmt = usercmt;
	}
	
	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", username=" + username
				+ ", userpwd=" + userpwd + ", usercmt=" + usercmt + "]";
	}
	
}
