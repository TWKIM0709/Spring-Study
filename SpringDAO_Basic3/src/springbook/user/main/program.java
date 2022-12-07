package springbook.user.main;

import java.sql.SQLException;

import springbook.user.dao.SimpleConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
		//공통 코드
		
		UserDao dao = new UserDao();
		//각 벤더 마다 구현되는 클래스를 달리 하여야 한다
		
		
				
		User user = new User();
		user.setId("kglim");
		user.setName("홍길동");
		user.setPassword("1004");

		// insert
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