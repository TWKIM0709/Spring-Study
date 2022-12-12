package com.model;

import java.sql.SQLException;

//CRUD 함수를 인터페이스 기반 설계
public interface MemberDAO {
	
	//회원가입 
	boolean memberInsert(String id, String name, String pwd , String email, int age);
	
	//회원상세조회
	MemberVO selectMemberById(String id) throws SQLException;
	
	//회원유뮤 판단
	boolean memberCheck(String id, String pwd) throws SQLException;
}
