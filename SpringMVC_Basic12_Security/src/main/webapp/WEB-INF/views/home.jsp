<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>HOME</h3>
		<se:authorize access="isAnonymous()">
			<p>
				<a href="<c:url value="/login/loginForm.do" />">로그인</a>
			</p>	
		</se:authorize>
		<se:authorize access="isAuthenticated()">
			<form action="${pageContext.request.contextPath}/logout">
				<input type="submit" value="로그아웃">
			</form>
		</se:authorize>
		
		<h3>
			[<a href="<c:url value="/intro/introduction.do" />">소개페이지</a>]<br>
			[<a href="<c:url value="/admin/adminHome.do" />">관리자홈</a>]
		</h3>
</body>
</html>