<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="kr.co.mycom.ibatis.guest.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List list = GuestDAO.getGuestList();
	//out.println("list = "+ list);
%>
<c:set var="list" value="<%=list%>" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>방명록 리스트</title>
</head>
<body>
<h1>방명록 리스트</h1>
<c:forEach var="g" items="${list}">
	${g.name} (${g.email}) ${g.home} <br/>
	${g.content}
	<hr/>
</c:forEach>
<a href="writeform.jsp">방명록 쓰기</a><br>
</body>
</html>