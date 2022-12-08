<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기화면</title>
</head>
<body>
	<h3>게시판 글쓰기 입력 폼</h3>
	<form method="post">
		<input type="hidden" name="parentId" value="0"><br>
		제목:<input type="text" name="title"><br>
		내용:<input type="text" name="content"><br>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>