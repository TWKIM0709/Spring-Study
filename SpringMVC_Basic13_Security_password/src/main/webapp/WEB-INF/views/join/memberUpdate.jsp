<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>email</th>
		</tr>
		<tr>
			<td><input type="text" value="${member.userid}" name="userid" readonly></td>
			<td><input type="password" value="" name="pwd"></td>
			<td><input type="text" value="${member.name}" name="name"></td>
			<td><input type="text" value="${member.gender}" name="gender" readonly></td>
			<td><input type="text" value="${member.cphone}" name="cphone"></td>
			<td><input type="text" value="${member.email}" name="email"></td>
		</tr>
		<tr>
			<td colspan="5"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>
