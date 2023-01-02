<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	button{
	margin: 5px;
	    width:10%;
		height:6%;
		font-family: 'Heebo', sans-serif;
	   text-align: center;
	    position: relative;
	    border: none;
	    display: inline-block;
	    padding: 5px;
	    border-radius: 15px;
	    font-family: "paybooc-Light", sans-serif;
	    box-shadow: 0 3px 3px rgba(0, 0, 0, 0.1);
	    text-decoration: none;
	    font-size:10px;
	    font-weight: 500;
	    transition: 0.25s;
	    background: linear-gradient(-45deg, #33ccff 0%, #ff99cc 100%);
	    color: white;
	}
</style>
</head>
<body>
<h1>태태우톡 v0.16</h1>
	<div id="one">
		별명 : <input type="text" id="nickname" />
		<button id="enter" value="입장" >입장</button>
		<button type="button" id="exit" value="퇴장" >퇴장</button>
	</div>
	<div id="two" >
		<div id="chatarea"
			style="width: 400px; height: 600px; border: 1px solid;overflow:scroll; "></div>
			
		<!-- <input type="textarea" style="width: 400px; height: 600px; border: 1px solid;"> -->
		
		<input type="text" id="message" /> <button type="button" id="send"
			value="보내기" >보내기</button>
	</div>

</body>
<script>
	// = = = = = 이벤트 등록 부분 = = = = = =
	document.getElementById('message').addEventListener("keypress",function(event){
		if ( event.which == 13 ) {
	         send();
	     }
	});
	document.getElementById("enter").addEventListener("click", function() {
		//웹 소켓 연결해주는 함수 호출 
		connect();
	});
	document.getElementById("exit").addEventListener("click", function() {
		//연결을 해제해주는 함수 호출 
		disconnect();
	});
	document.getElementById("send").addEventListener("click", function() {
		//연결을 해제해주는 함수 호출 
		send();
	});
			
	// = = = = = WebSocket 함수 부분 = = = = = =
	let websocket; //WebSocket 변수
	
	//입장 버튼을 눌렀을 때 호출되는 함수 
	function connect() {
		//websocket = new WebSocket("ws://192.168.0.32:8090/kosa/chat-ws");
		websocket = new WebSocket("ws://" + location.host+"/kosa/chat-ws");
		console.log(websocket);
		console.log("websocket");
		// 192.168.0.32
		//웹 소켓에 이벤트가 발생했을 때 호출될 함수 등록 
		websocket.onopen = onOpen;
		websocket.onmessage = onMessage;
		websocket.onclose = onClose;
	}
	//퇴장 버튼을 눌렀을 때 호출되는 함수 
	function disconnect() {
		msg = document.getElementById("nickname").value;
		websocket.send(msg + "님이 퇴장하셨습니다");
		websocket.close();
	}
	//보내기 버튼을 눌렀을 때 호출될 함수 
	function send() {
		nickname = document.getElementById("nickname").value;
		msg = document.getElementById("message").value;
		websocket.send(nickname + ":" + msg);
		document.getElementById("message").value = "";
	}
	//웹 소켓에 연결되었을 때 호출될 함수 
	function onOpen() {
		nickname = document.getElementById("nickname").value;
		websocket.send(nickname + "님 입장하셨습니다.");
	}
	//웹 소켓에서 연결이 해제 되었을 때 호출될 함수 
	function onMessage(evt) {
		data = evt.data;
		chatarea = document.getElementById("chatarea");
		chatarea.innerHTML = data + "<br><br>" + chatarea.innerHTML
	}
	function onClose() {

	}
</script>
</html>