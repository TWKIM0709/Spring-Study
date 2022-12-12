<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
</head>
<body>
	Session Value : <c:out value="${sessionScope.USERID}" />
	
	<form action="${pageContext.servletContext.contextPath}/login.do" method="post">
		<table border="1">
			<tr>
				<td>아이디:</td>
				<td>
					<input type="text" name="id" size="20">
				</td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td>
					<input type="password" name="pwd" size="20">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>