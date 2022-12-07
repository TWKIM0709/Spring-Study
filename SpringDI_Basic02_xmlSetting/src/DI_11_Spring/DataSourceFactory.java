package DI_11_Spring;

public class DataSourceFactory {
	private String jdbcdriver;
	private String jdbcurl;
	private String username;
	private String password;
	
	public void setJdbcdriver(String jdbcdriver) {
		this.jdbcdriver = jdbcdriver;
	}
	public void setJdbcurl(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DataSourceFactory [jdbcdriver=" + jdbcdriver + ", jdbcurl=" + jdbcurl + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}
