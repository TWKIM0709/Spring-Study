<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="join.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/inc/header.jsp" />
		<jsp:include page="inc/visual.jsp" />
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<form action="" method="post">
						<h2>회원가입</h2>
						<h3 class="hidden">방문페이지 로그</h3>
						<p id="breadscrumb" class="block_hlist clear"><img alt="Step1 개인정보 등록" src="images/step2.png" /></p>
						<h3 class="hidden">회원가입 폼</h3>
						<div id="join-form" class="join-form margin-large" >						
							<dl class="join-form-row">
								<dt class="join-form-title">
									아이디
								</dt>
								<dd class="join-form-data">
									<input type="text" name="userid" />
									<input id="btnCheckUid" class="button" type="button" value="중복확인" />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									비밀번호
								</dt>
								<dd class="join-form-data">
									<input type="password" name="pwd" />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									비밀번호 확인
								</dt>
								<dd class="join-form-data" >
									<input type="password" name="pwd2" />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									이름
								</dt>
								<dd class="join-form-data">
									<input type="text" name="name" />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									성별
								</dt>
								<dd class="join-form-data">
									<select name="gender">
										<option>남성</option>
										<option>여성</option>
									</select>
								</dd>
							</dl>
							<dl class="join-form-row birthday">
								<dt class="join-form-title">
									생년월일
								</dt>
								<dd class="join-form-data">								
	                                <span>
	                                    <input type="text" id="year" />년
	                                    <input type="text" id="month" />월
	                                    <input type="text" id="day" />일
	                                    <input type="hidden" name="Birth" id="Birth" />
	                                </span>
	                                <span class="moon">
	                                    <input type="radio" name="IsLunar" value="Solar" id="IsSolar" checked />양력
	                                    <input type="radio" name="IsLunar" value="Lunar" id="IsLunar" />음력
	                                </span>
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									핸드폰 번호
								</dt>
								<dd class="join-form-data">
									<input type="text" name="cphone" /><span>[대시(-)를 포함할 것: 예) 010-3456-2934]</span>
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									이메일
								</dt>
								<dd class="join-form-data">
									<input type="text" name="email" />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									취미
								</dt>
								<dd class="join-form-data habit">
									<input type="checkbox" name="habit" id="music" /><label for="music">음악</label>
									<input type="checkbox" name="habit" id="movie" /><label for="movie">영화</label>
									<input type="checkbox" name="habit" id="trip" /><label for="trip">여행</label>
								</dd>
							</dl>						
						</div>
						<div id="buttonLine">
						<input class="btn-okay button" type="submit" value="가입" />
						</div>
					</form>	
					
				</div>
				<jsp:include page="inc/aside.jsp" />
			</div>
		</div>
		<jsp:include page="../inc/footer.jsp" />
	</body>
</html>
