<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="header">
			<div class="top-wrapper">
				<h1 id="logo"><a href="/"><img src="" alt="로고" /></a></h1>
				<h2 class="hidden">메인메뉴</h2>
				<ul id="mainmenu" class="block_hlist">
					<li>
						<a href="">BIT가이드</a>
					</li>
					<li>
						<a href="" >BIT과정</a>
					</li>
					<li>
						<a href="" >BIT</a>
					</li>
				</ul>
				<form id="searchform" action="" method="get">
					<fieldset>
						<legend class="hidden">
							과정검색폼
						</legend>
						<label for="query">과정검색</label>
						<input type="text" name="query" />
						<input type="submit" class="button" value="검색" />
					</fieldset>
				</form>
				<h3 class="hidden">로그인메뉴</h3>
				<ul id="loginmenu" class="block_hlist">
					<li>
						<a href="./index.jsp">HOME</a>
					</li>
					<li>
						<a href="joinus/login.htm">로그인</a>
					</li>
					<li>
						<a href="joinus/join.htm">회원가입</a>
					</li>
				</ul>
				<h3 class="hidden">회원메뉴</h3>
				<ul id="membermenu" class="clear">
					<li>
						<a href=""><img src="images/menuMyPage.png" alt="마이페이지" /></a>
					</li>
					<li>
						<a href="customer/notice.htm"><img src="images/menuCustomer.png" alt="고객센터" /></a>
					</li>
				</ul>
			</div>
		</div>
		<div id="main">
			
		</div>
		<div id="footer">
			<div class="top-wrapper">
				<h2><img src="" alt=""/></h2>
				<p>				
					<address id="ad">
						사업자등록번호 
						<br/>
						주소 : 
					</address>
				</p>				
				<p>
					Copyright ⓒ kosta.com All Right Reserved. </p>
			</div>
		</div>
	</body>
</html>
