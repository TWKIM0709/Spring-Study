package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.bit.dto.User;
import kr.or.bit.service.SqlMapClient;

public class program {
	public static void main(String[] args) {
		//method scope
	    SqlSessionFactory sqlsession=SqlMapClient.getSqlSession();
	    
	    SqlSession session= sqlsession.openSession();
	    
	    //session.selectOne("매퍼가 가지고 있는 이름(namespace.id)", 파라미터)
	    
	    User user = (User)session.selectOne("Emp.getone", "ALLEN");
	    System.out.println(user.getEmpno());
	    System.out.println(user.getEname());
	    session.close();

	}

}



