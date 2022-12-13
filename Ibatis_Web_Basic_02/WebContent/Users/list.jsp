<%@page import="kosta.ibatis.dao.UserDao"%>
<%@page import="kosta.ibatis.dto.UserDto" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDao dao = new UserDao();
		List<UserDto> list = dao.list();
	%>
	회원가입 : <a href="Register.jsp">회원가입</a><br>
	전체회원수 : <%= list.size() %><hr>
	<c:forEach items="<%=list%>" var="user">
		[회원ID] <a href="detail.jsp?userid=${user.userid}">${user.userid}</a><br>
		[회원이름] ${user.username}<hr>
	</c:forEach>
</body>
</html>




