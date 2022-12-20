package kr.co.test.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.test.model.dao.MemberDAO;
import kr.co.test.model.dto.Member;

@Service
public class MemberService {

	@Autowired
	private SqlSession sqlsession;
	
	public Member getMember(String userid){
		MemberDAO dao = sqlsession.getMapper(MemberDAO.class);
		Member member = dao.getMember(userid);
		return member;
	}
	
	public void updateMember(Member member){
		MemberDAO dao = sqlsession.getMapper(MemberDAO.class);
		int result = dao.updateMember(member);
		if(result > 0){
			System.out.println("업데이트 성고");
		}else{
			System.out.println("업데이트 실패");
		}
	}
}
