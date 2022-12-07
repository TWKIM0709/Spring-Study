package springbook.user.main;

import java.sql.SQLException;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class program {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();

		User user = new User();
		user.setId("kglim");
		user.setName("홍길동");
		user.setPassword("1004");

		// insert
		// 정상적인 방법은: try{}catch(Ex...... 
		dao.add(user);
		System.out.println(user.getId() + "등록성공");

		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user.getId() + "조회성공");

	}

}
/*
create table users
(
  id varchar2(20) primary key,
  name varchar2(20) not null,
  password varchar2(20) not null
);

*/