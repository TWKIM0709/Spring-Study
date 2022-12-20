package kr.co.test.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.test.model.dao.MemberDAO;
import kr.co.test.model.dto.Member;

@Service
public class JoinService {

	@Autowired
	private SqlSession sqlsession;
	
	public int insertMember(Member member){
		int result = 0;
		MemberDAO dao = sqlsession.getMapper(MemberDAO.class);
		result = dao.insertMember(member);
		return result;
	}
	
	public int idCheck(String userid){
		MemberDAO dao = sqlsession.getMapper(MemberDAO.class);
		int result = dao.idCheck(userid);
		return result;
	}
	
	public int loginCheck(String username, String password){
		MemberDAO dao = sqlsession.getMapper(MemberDAO.class);
		int result = dao.loginCheck(username, password);
		return result;
	}
}
