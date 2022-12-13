<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 쓰기</title>
</head>
<body>
	<h1>방명록 쓰기</h1>
	<form action="write.jsp" method="post" >
		
		<!-- no, name, pwd, email, home, content, regdate -->
		
		<table width="600">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" size="12" maxlength="4">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pwd" size="12" maxlength="12">
				</td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email" size="30" maxlength="30">
				</td>
			</tr>
			
			<tr>
				<th>홈페이지</th>
				<td>
					<input type="text" name="home" size="50" maxlength="50">
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="30" name="content"></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="쓰기">
					<input type="reset" value="취소">
				</td>
			</tr>
			
		</table>
		
	</form>
</body>
</html>