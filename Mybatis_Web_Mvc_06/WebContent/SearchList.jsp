<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���ϰ˻��ϱ�</h3>
	<form action="guest.do?cmd=search" method="post">
		<select name="column">
			<option value="name">�ۼ���</option>
			<option value="email">����</option>
			<option value="home">Ȩ������</option>
		</select>
		<input type="text" name="keyvalue">
		<input type="submit" value="�˻�">
	</form>

<h3>���߰˻��ϱ�</h3>
	�˻�: where name='kglim' or email='naver' or home='kosta'
	<form action="guest.do?cmd=search2" method="post">
		<input type="checkbox" name="name" value="name" checked>�ۼ���
		<input type="checkbox" name="email" value="email" >����
		<input type="checkbox" name="home" value="home" >Ȩ������
		<br>
		�˻���:<input type="text" name="keyvalue">
		<input type="submit" value="�˻�">
	</form>

<hr>
	<table border="1" width="600">
		<tr>
			<td>NUM</td>
			<td>Writer</td>
			<td>Email</td>
			<td>HomePage</td>
			<td>Detail</td>
			<td>Delete</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.no}</td>
				<td>${list.name}</td>
				<td>${list.email}</td>
				<td>${list.home}</td>
				<td><a href="javascript:location.href='guest.do?cmd=detail&no=${list.no}'">�󼼺���</a></td>
				<td><a href="javascript:location.href='guest.do?cmd=delete&no=${list.no}'">�����ϱ�</a></td>
			</tr>
		</c:forEach>
	</table>	
	<a href="WriteForm.html">�۾���</a>
</body>
</html>