<%@ page import="kosta.ibatis.dao.UserDao" %>
<%@ page import="kosta.ibatis.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserDao dao = new UserDao();
	String userid = request.getParameter("userid");
	UserDto dto = dao.findById(userid);

%>   
	<h3>회원상세정보</h3>
	ID : <%= dto.getUserid() %><hr>
	PWD: <%= dto.getUserpwd() %><hr>
	Name: <%= dto.getUsername() %><hr>
	Comment:<%= dto.getUsercmt() %><hr>
	<input type="button" value="뒤로가기" onclick="history.back()">
	<input type="button" value="가입정보수정" 
	            onclick="location='udateForm.jsp?userid=<%= userid %>'">
	<input type="button" value="탈퇴하기" 
				onclick="location='dropForm.jsp?userid=<%=userid %>'">
	
	
	
	
	
	
</body>
</html>