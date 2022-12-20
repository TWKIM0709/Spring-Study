<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btnCheckUid').click(function(){
			$.ajax(
				{
					type:"post",
					url:"idcheck.htm",
					data:{"userid" : $('#userid').val()},
					success:function(data){
						if(data.result=="fail"){
							alert('중복된 아이디 입니다.');
							$('#userid').focus();
						}else{
							alert('사용가능한 아이디 입니다.');
						}
					}
				}	
			);
		});
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="content"/>
	
	<tiles:insertAttribute name="footer"/>
</body>
</html>