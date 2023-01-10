<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link href="resources/home.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		* {
		    margin: 0;
		    padding: 0;
		}
		
		html, body {
		    width: 100%;
		    height: 100%;
		}
		
		body {
		    background: #ffeee3;
		    -webkit-animation: burn 2s infinite alternate;
		    -moz-animation: burn 2s infinite alternate;
		    -o-animation: burn 2s infinite alternate;
		    animation: burn 2s infinite alternate;
		}
		
		.flux {
		  background: #f3cc80;
		  width: 200px;
		  height: 200px;
		  border-radius: 50%;
		  overflow: hidden;
		  position: relative;
		  margin-left:-100px;
		  left: 50%;
		  margin-top: -100px;
		  top: 50%;
		}
		
		.flux:before {
		  content: '';
		  position: absolute;
		  display: block;
		  background: #f49f36;
		  width: 25%;
		  height: 25%;
		  border-radius: 50%;
		  top: 38%;
		  right: 18%;
		  border: 3px solid white;
		}
		
		.flux:after {
		  content: '';
		  position: absolute;
		  display: block;
		  background: #8099c2;
		  height: 90%;
		  width: 90%;
		  top: 40%;
		  left: -10%;
		  border-radius: 45% 12% 45% 42%;
		  -webkit-transform: rotate(40deg);
		  -moz-transform: rotate(40deg);
		  -o-transform: rotate(40deg);
		  transform: rotate(40deg);
		}
		
		
		@-webkit-keyframes burn {
		  0%   { background: #ffcfb0; }
		  100% { background: #fffdfd; }
		}
		@-moz-keyframes burn {
		  0%   { background: #ffcfb0; }
		  100% { background: #fffdfd; }
		}
		@-o-keyframes burn {
		  0%   { background: #ffcfb0; }
		  100% { background: #fffdfd; }
		}
		@keyframes burn {
		  0%   { background: #ffcfb0; }
		  100% { background: #fffdfd; }
		}
	</style>
</head>
<body>
<jsp:include page="inc/nav.jsp"/>
<div class="flux"></div>
</body>
</html>
