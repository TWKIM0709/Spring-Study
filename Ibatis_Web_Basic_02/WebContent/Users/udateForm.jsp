<%@ page import="kosta.ibatis.dao.UserDao" %>
<%@ page import="kosta.ibatis.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	UserDao dao = new UserDao();
    String userid = request.getParameter("userid");
    UserDto dto = dao.findById(userid);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원정보 수정 페이지</h3>
	<form action="updateOk.jsp" method="post">
	ID:<%= dto.getUserid() %><br>
	Pwd:<input type="password" name="userpwd" value="<%= dto.getUserpwd() %>"><br>
	Name:<input type="text" name="username" value=<%= dto.getUsername() %>><br>
	Comment:<%= dto.getUsercmt() %><br>
	<input type="hidden" name="userid" value="<%= userid %>">
	<input type="button" value="뒤로" onclick="history.back()">
	<input type="submit" value="수정">
</form>
</body>
</html>