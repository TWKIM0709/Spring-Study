<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <style type="text/css">
    	.red {
    		background-color: red;
    	}
    	.blue {
    		background-color: blue;
    	}
    	ul {
    		list-style:none;
    		display : grid;
    		grid-template-columns : repeat(3,1fr);
    	}
    	li {
    		background-color: orange;
    		border : 1px solid black;
    		padding : 10px;
    		width:100%;
    		height:200px;
    	}
    </style>
</head>
<body>
<div class="container"> <!-- 전체 div -->
	<div class="row"> <!-- 제목영역 -->
		<div class="red" > <!-- 제목 -->
			<h1>태태오톡 2.0</h1>
		</div>
	</div>
	<div class="row"> <!-- 채팅방 영역 -->
		<div class="col-md-10 col-lg-10"> <!-- 채팅방 -->
			<ul>
				<li data-index="1">1번방</li>
				<li data-index="2">2번방</li>
				<li data-index="3">3번방</li>
				<li data-index="4">4번방</li>
				<li data-index="5">5번방</li>
				<li data-index="6">6번방</li>
			</ul>
		</div>
		<div class="col-md-2 col-lg-2 blue"> <!-- 오른쪽 네비바 -->
			
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	const liList = $('li');
	
	liList.each((index, element)=>{
		$(element).on({
			click:()=> { location.href = "chatroom/" + $(element).attr('data-index'); }
		});
	});
	
/* 	.on({
		click:(element)=>{
			//$(board).attr('data-index')
			const attr = $(element).attr('data-index');
			console.log(attr);
		}
	}) */
</script>
</html>