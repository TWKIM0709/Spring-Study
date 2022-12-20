<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<!-- http://localhost:8090/kosa_Security_Password/join/join.css -->
		<link href="${pageContext.request.contextPath}/joinus/join.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/inc/header.jsp" />
		<jsp:include page="inc/visual.jsp" />
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<form action="" method="post">
						<h2>마이페이지</h2>
						<h3 class="hidden">방문페이지 로그</h3>
						<p id="breadscrumb" class="block_hlist clear"><img alt="Step1 개인정보 등록" src="images/step2.png" /></p>
						<h3 class="hidden">회원가입 폼</h3>
						<div id="join-form" class="join-form margin-large" >
							<dl class="join-form-row">
								<dt class="join-form-title">
									비밀번호 확인
								</dt>
								<dd class="join-form-data">
									<input type="password" name="pwd" />
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
