<%@ page import="kosta.ibatis.dao.UserDao" %>
<%@ page import="kosta.ibatis.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<jsp:useBean id="dto" class="kosta.ibatis.dto.UserDto"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	UserDao dao = new UserDao();
	dao.update(dto);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3><%= dto.getUsername() %>님 정보수정</h3><br>
<a href="list.jsp">목록</a>
</body>
</html>