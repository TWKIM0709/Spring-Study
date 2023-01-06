<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <!-- <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/main.css" rel="stylesheet">
    <!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <!-- <script src="/webjars/sockjs-client/sockjs.min.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js" integrity="sha512-1QvjE7BtotQjkq8PxLeF6P46gEpBRXuskzIVgjFpekzFVF4yjRgrQvTG1MTOJ3yQgvTteKAcO7DSZI92+u/yZw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>    
    <!-- <script src="/webjars/stomp-websocket/stomp.min.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js" integrity="sha512-iKDtgDyTHjAitUDdLljGhenhPwrbBfqTKWO1mkhSFH3A7blITC9MhYon6SjnMhp4o0rADGw9yAC6EW4t5a4K3g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- <script src="app.js"></script> -->
</head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
var stompClient = null; //웹소켓 정보를 담고 있을 객체 미리 생성

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
	// 웹 소켓 접속 경로 설정 - WebSokcketConfig.java 에 정의된 EndPoint로 접속을 요청한다.
    var socket = new SockJS('/Study_SpringWebSocket_STOMP/gs-guide-websocket');
    console.log(socket);
    stompClient = Stomp.over(socket); // 접속 설정 2
    console.log(stompClient);
    stompClient.connect({}, function (frame) { //웹 소켓 접속
        console.log(3);
        setConnected(true); //setConnected - 웹소켓 접속 상태를 true로 설정
        console.log('Connected: ' + frame);
        // 메세지를 받았을 때 (웹소켓 -> 클라이언트 로 데이터가 왔을 때) 실행할 함수
        stompClient.subscribe('/topic/greetings', function (greeting) {
        	// STOMP 프로토콜은 데이터 전달을 JSON 으로 주고 받는다.
        	// 익명함수에 들어있는 greeting은 Greeting.java(DTO) 형식의 JSON 데이터가 담겨서 온다.
        	// showGreeting 함수 - 받은 파라미터를 화면에 출력해주는 함수
        	// 									Greeting 객체의 content 를 받아 화면에 출력하도록 사용함.
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() { //{name : "접속한 유저 이름"}
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

/*
connect() 메서드는 SockJS와 stomp.js를 사용해서 /gs-guide-websocket에 대한 커넥션을 생성한다.
이 때 SockJS 서버는 연결을 대기하고, 성공 시 클라이언트는 서버가 greeting message를 publish 할 path인 /topic/greetings 를 subscribe한다.
해당 topic에서 greeting 메시지를 수신하면 이를 표시하기 위해 DOM에 paragraph 요소를 추가한다.

sendName() 메서드는 사용자가 입력한 이름을 STOMP 클라이언트를 이용해서 /app/hello로 전송한다. 이 메시지는 GreetingController의 greeting() 메서드로 전달된다.  
 */
</script>
</html>