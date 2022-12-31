<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- JQuery , WebSocket CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js" integrity="sha512-1QvjE7BtotQjkq8PxLeF6P46gEpBRXuskzIVgjFpekzFVF4yjRgrQvTG1MTOJ3yQgvTteKAcO7DSZI92+u/yZw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
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
	<div style="width: 800px; height: 700px; padding: 10px; border: solid 1px #e1e3e9;">
		<div id="divChatData"></div>
	</div>
	<div style="width: 100%; height: 10%; padding: 10px;">
		<input type="text" id="message" size="110" onkeypress="if(event.keyCode==13){webSocket.sendChat();}" />
		<input type="button" id="btnSend" value="채팅 전송" onclick="webSocket.sendChat()" />
	</div>

</body>
<script>
	// = = = = = WebSocket 함수 부분 (교수님 예제 버전) = = = = = =
	//Web
	let webSocket = {
		init: function(param) { //채팅 접속 요청 함수
			this._url = param.url; //입력 받은 접속 주소를 _url에 저장
			this._initSocket();		//저장한 접속 주소로 채팅 접속 함수 실행 
		},
		sendChat: function() { //채팅 보내기 요청 함수
			this._sendMessage($('#message').val());	//_sendMessage 함수(채팅 보내기 처리 함수) 실행 뒤
			$('#message').val('');										// input 태그 초기화
		},
		receiveMessage: function(str) {		// 채팅을 받았을 때 함수
			$('#divChatData').append('<div>' + str + '</div>');	 //전달 받은 채팅을 채팅 영역에 추가
		},
		closeMessage: function(str) { // 소켓 연결이 끊어졌을 때 실행되는 함수
			$('#divChatData').append('<div>' + '연결 끊김 : ' + str + '</div>');
		},
		disconnect: function() { //채팅 연결을 끊는 함수
			this._socket.close();
		},
		_initSocket: function() { // 소켓에 연결히는 처리를 하는 함수
			this._socket = new SockJS(this._url);		//_url (접속주소)를 사용해 소켓 객체 생성 
			this._socket.onmessage = function(evt) {//생성된 소켓 객체의 onmessage 이벤트에 (메세지를 받았을 때 이벤트)
				webSocket.receiveMessage(evt.data);	//receiveMessage 함수 설정(채팅 영역에 받은 메세지 추가함) 
			};
			this._socket.onclose = function(evt) { //소켓 연결이 끊길 때의 이벤트에 closeMessage() 함수 설정
				webSocket.closeMessage(evt.data);
			}
		},
		_sendMessage: function(str) { 	// 메세지를 보내는 함수
			this._socket.send(str);				// 소켓 객체의 send() 함수를 사용해 메세지를 보낸다. 
		}
	};
	$(document).ready(function() {
		/* webSocket.init('/kosa/chat-ws');	 */
		webSocket.init({ url: '<c:url value="/chat-ws" />' });
	})

</script>
</html>