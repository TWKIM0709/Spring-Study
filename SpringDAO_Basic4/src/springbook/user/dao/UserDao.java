package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	//DB연결을 가지고 있는  SimpleConnectionMaker 클래스 사용
	//UserDao 각 SimpleConnectionMaker 를 의존 **********
	/*
	private SimpleConnectionMaker simpleconnectionmaker;
	public UserDao(){
		this.simpleconnectionmaker = new SimpleConnectionMaker();
	}
	*/
	
	//Interface 활용 타입제어
	//***UserDao 특정 클래스에 의존하지 않는다 ************
	private ConnectionMaker connectionmaker;
	public UserDao(ConnectionMaker simpleconnectionmaker){
		this.connectionmaker = simpleconnectionmaker;
		
		//this.connectionmaker = new DConnectionMaker();
		//this.connectionmaker = new NConnectionMaker();
	}
	
	
	//Data Add
	public void add(User user) throws ClassNotFoundException , SQLException {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","spring","1004");
		//Connection c = getConnection();
		Connection c = connectionmaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
		
	}
	
	//Data Get
	public User get(String id) throws ClassNotFoundException , SQLException {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","spring","1004");
		//Connection c = simpleconnectionmaker.getConnection();
		
		Connection c = connectionmaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id =?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		return user;
	}
	
	//Oracle -> MySql
	//중복관심에 대한 하나의 관심사로 모았다(DB연결)
	/*private Connection getConnection() throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","spring","1004");
		return c;
	}*/
	
	//2차 요구사항
	//벤더 마다 다른 연결을 가지고 싶다
	//벤더가 자기 회사의 연결을 강제 구현
	
	//3차 요구사항()
	//abstract protected Connection getConnection() throws ClassNotFoundException ,SQLException;

	
	
}
