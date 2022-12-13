<%@page import="kosta.ibatis.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="kosta.ibatis.dto.UserDto"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	UserDao dao = new UserDao();
	dao.insert(dto);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= dto.getUsername() %>님 회원가입 되었습니다 <hr>
	<a href="list.jsp">회원목록 이동</a>
</body>
</html>