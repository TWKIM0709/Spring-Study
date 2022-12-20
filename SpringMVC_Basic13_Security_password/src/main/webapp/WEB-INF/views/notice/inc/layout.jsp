<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
	<!-- title 영역 -->
	<tiles:getAsString name="title"/>
	</title>
	<!--  CSS -->
	<link href="notice.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- Header  영역  -->
	<tiles:insertAttribute name="header" />
	<!-- Visual 영역 -->
	<tiles:insertAttribute name="visual" />
	<!-- Main영역  -->
	<div id="main">
			<div class="top-wrapper clear">
				<!-- Content (실내용) -->
				<tiles:insertAttribute name="content" />
				<!-- Aside 영역 (Navi)  -->
				<tiles:insertAttribute name="aside" />
			</div>	
	</div>
	<!-- Footer 영역 -->
	<tiles:insertAttribute name="footer" />
</body>
</html>