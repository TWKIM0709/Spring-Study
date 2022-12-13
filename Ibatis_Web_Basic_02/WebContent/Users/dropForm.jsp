<%@ page import="kosta.ibatis.dao.UserDao" %>
<%@ page import="kosta.ibatis.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<% 
	UserDao dao = new UserDao();
	dao.delete(request.getParameter("userid"));
	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
삭제 처리 되었습니다
<a href="list.jsp">목록가기</a>
</body>
</html>