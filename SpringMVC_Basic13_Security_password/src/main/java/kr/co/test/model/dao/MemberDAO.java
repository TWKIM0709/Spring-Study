package kr.co.test.model.dao;

import kr.co.test.model.dto.Member;

public interface MemberDAO {

	//회원가입
	public int insertMember(Member member);
	
	public int idCheck(String userid);
	
	public int loginCheck(String username, String password);
	
	public Member getMember(String userid);
	
	//회원수정
	public int updateMember(Member member);

}
