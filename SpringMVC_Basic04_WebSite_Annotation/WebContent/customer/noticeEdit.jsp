<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../css/customer.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="header">
			<div class="top-wrapper">
				<h1 id="logo"><a href="/"><img src="" alt="로고" /></a></h1>
				<h2 class="hidden">메인메뉴</h2>
				<ul id="mainmenu" class="block_hlist">
					<li>
						<a href="">kosta가이드</a>
					</li>
					<li>
						<a href="" >kosta과정</a>
					</li>
					<li>
						<a href="" >kosta</a>
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
						<a href="../index.jsp">HOME</a>
					</li>
					<li>
						<a href="../joinus/login.jsp">로그인</a>
					</li>
					<li>
						<a href="../joinus/join.jsp">회원가입</a>
					</li>
				</ul>
				<h3 class="hidden">회원메뉴</h3>
				<ul id="membermenu" class="clear">
					<li>
						<a href=""><img src="../images/menuMyPage.png" alt="마이페이지" /></a>
					</li>
					<li>
						<a href="notice.jsp"><img src="../images/menuCustomer.png" alt="고객센터" /></a>
					</li>
				</ul>
			</div>
		</div>
		<div id="visual" class="customer">
			<div class="top-wrapper">
				
			</div>
		</div>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항수정
						</li>
					</ul>
					<form action="" method="post">
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								&nbsp;<input name="title" value="제 1회 경진대회 " />
							</dd>
						</dl>	
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								작성자
							</dt>
							<dd class="article-detail-data half-data" >
								코스타
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								조회수
							</dt>
							<dd class="article-detail-data half-data">
								1235
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								첨부파일
							</dt>
							<dd class="article-detail-data">
								&nbsp;<input type="file" id="txtFile" name="file" />
							</dd>
						</dl>

						<div class="article-content" >
							<textarea id="txtContent" class="txtContent" name="content"><img src="http://sstatic.naver.net/keypage/outside/info/2011031017145546407.jpg" /><br />동해물과 백두산이 마르고 닳도록
							</textarea>
						</div>						
					</div>
					<p class="article-comment margin-small">
						<a class="btn-save button" href="noticeEditProc.jsp">수정</a>
						<a class="btn-cancel button" href="noticeDetail.jsp">취소</a>						
					</p>		
					</form>					
				</div>				
				<div id="navi">
					<h2>고객센터</h2>
					<h3 class="hidden">고객센터메뉴</h3>
					<ul id="navi-menu">
						<li>
							<a href="">소식</a>
						</li>
						<li>
							<a href="" class="current">공지사항</a>
						</li>
						<li>
							<a href="">1:1 고객문의</a>
						</li>
						<li>
							<a href="">학습도구</a>
						</li>
						<li>
							<a href="">학습안내</a>
						</li>
					</ul>
					<h3 id="fav-title">추천사이트</h3>
					<ul class="margin-small">
						<li>
							<a href=""><img src="" alt="" /></a>
						</li>
						<li>
							<a href=""><img src="" alt="" /></a>
						</li>
						<li>
							<a href=""><img src="" alt="" /></a>
						</li>
					</ul>
				</div>
			</div>
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
