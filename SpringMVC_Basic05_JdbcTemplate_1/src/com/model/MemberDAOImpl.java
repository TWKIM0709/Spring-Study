package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//기존 : Model2 기반의 MVC 패턴 : JDBC API 사용 (Connection , Statement , PrepareStatement ,ResultSet..)
//함수 사용 실행 : ResultSet rs = st.executeQuery();
//함수 사용 실행 : int result = st.executeUpdate();


//select a, b, c ,d , f , g from data;
//dto 담아라 ....
//class data { private int a , b , c , d, d ,f ....}
//while(rs.next()){ data d = new data(); d.setA(rs.getInt("a"))}
//단순한 작업을 안했으면 좋겠어요 .........



//Spring 제공하는 > JDBCTemplate(틀) > [코드량 감소] , [일원화된 코드 작업 가능] (유지보수)
//문제점) 인터페이스 기반 (설계) > 익명클래스 > 코드 생략 > 추상화 > 개발자 입장에서 가독성


//@Repository  //DAO Db작업 저장소  >> xml >> <context:component-scan base-package="com.model" />
public class MemberDAOImpl implements MemberDAO{

	/*
	JdbcTemplate template = new JdbcTemplate();
	public void m() { template.execute("select...");}
	IOC 컨테이너 안에 Bean 으로 생성 되어 있어요
	
	
	MemberDAOImpl 객체 JdbcTemplate 객체에 의존한다
	*/
	private JdbcTemplate jdbctemplate;
	
	@Autowired //by type
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	
	
	@Override
	public boolean memberInsert(String id, String name, String pwd, String email, int age) {
		String sql="insert into usermember(id,name,pwd,email,age) values(?,?,?,?,?)";
		boolean result = false;
		
				
		Object[] params = {id,name,pwd,email,age};
		//[hong][홍길동][1004][hong@naver.com][100]

		if(this.jdbctemplate.update(sql,params) > 0)
		{
			result = true;
		}
		return result;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		
		/*
			JDBC API
			preparestatement pstmt = conn....(sql)
			ResultSet rs = pstsm.executeQuery();
			
			MemberVO membervo = new MemberVO()
			while(rs.next()){
				membervo.setName(rs.getString("name"));
				..
				..
			
			}
			
			자원 해제 ...
			return membervo

            **아래 처리 자동화된 코드를 원하면 : select 컬럼명  == VO 객체 변수명이 같으면 된다  *******
		
		    >>new BeanPropertyRowMapper<MemberVO>(MemberVO.class)
			or MyBatis 사용하면 아래 코드는 자동화 된다 .....
			아래 작업을 자동화 한다 .....////////////////////////
			MemberVO membervo = new MemberVO()
			while(rs.next()){
				membervo.setName(rs.getString("name"));
				..
				..
			
			}//////////////////////////////////////////
		
		*/
		String sql="select id,name,pwd,email,age from usermember where id=?";
		//Query 문 실행 -> resultset 결과 담아서 >[ VO 객체 생성 > rs 에서 vo setter 사용 데이터 넣고 ]> VO 객체 리턴
		return this.jdbctemplate.queryForObject(sql,
				                               new BeanPropertyRowMapper<MemberVO>(MemberVO.class),
				                               id);
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException {
		String sql="select * from usermember where id=? and pwd=?";
		
		boolean result = false;
		Object[] params = {id,pwd};
		/*
		 this.jdbctemplate.queryForList(sql,params) return List<>   게시판 전체 조회 , 회원목록 조회
		 * 
		 */
		
		if(this.jdbctemplate.queryForList(sql,params).size() > 0 ) {
			result = true;
		}
		return result;
	}

}





