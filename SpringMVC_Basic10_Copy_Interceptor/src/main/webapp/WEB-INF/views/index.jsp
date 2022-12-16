<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<style>
			#main button{
				width:33%;
				margin: 0 auto;
				height: 50px;
				font-size:2em;
				margin-top:30px;
			}
		</style>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/inc/header.jsp" />
		<div id="main">
			<button id="user">회원로그인</button>
			<button id="admin">관리자 로그인</button>
			<button id="logout">로그아웃</button>
		</div>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	</body>
</html>
<script>
	$('#user').on({
		click:function(){
			location.href = "userlogin.htm";
		}
	}); //user on end
	$('#admin').on({
		click:function(){
			location.href = "adminlogin.htm";
		}
	}); //admin on end
	$('#logout').on({
		click:function(){
			location.href = "logout.htm";
		}
	}); //logout on end
</script>