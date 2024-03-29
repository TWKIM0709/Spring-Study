<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <!-- <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js" integrity="sha512-1QvjE7BtotQjkq8PxLeF6P46gEpBRXuskzIVgjFpekzFVF4yjRgrQvTG1MTOJ3yQgvTteKAcO7DSZI92+u/yZw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js" integrity="sha512-iKDtgDyTHjAitUDdLljGhenhPwrbBfqTKWO1mkhSFH3A7blITC9MhYon6SjnMhp4o0rADGw9yAC6EW4t5a4K3g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <style type="text/css">
    	.nameArea {
    		width:20%;
    	}
    	.contentArea {
    		width : 80%;
    	}
    	#greetings{
    	    display:flex;
		   flex-direction: column-reverse;
		   overflow-y:auto;
		   height:535px;
    	}
    </style>
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
                <input type="text" id="content" placeholder="content  message here"><button id="send" class="btn btn-default" type="submit">Send</button><button class="btn btn-default"  onclick="loadChat()" type="button">LoadChat</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th colspan="2">Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings" >
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
const roomId ='${id}' 
console.log(roomId);
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
//    loadChat();
} // setConnected Function End

function connect() {
    var socket = new SockJS('/Study_SpringWebSocket3_STOMP_chat3/room-chat');
    stompClient = Stomp.over(socket); 
    stompClient.connect({}, function (frame) { 
        setConnected(true); 
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/' + roomId, function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        }); //stompClient.subscribe End
    });// stompClient.connect End
}//connect Function End

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
} // disconnect Function end

function sendName() {
    stompClient.send("/app/" + roomId, {}, JSON.stringify({'name': $("#name").val(),'content':$("#content").val(),'roomid':roomId}));
    $("#content").val('');
}// sendName Function end

function showGreeting(message) { 	
	if(message.chat_result == 'success'){		
    	$("#greetings").prepend("<tr><td class='nameArea'>" + message.chat_name + "</td><td class='contentArea'>" + message.chat_content + "</td></tr>");
	} else {
		if(message.name == $("#name").val()){ 
			$("#greetings").prepend("<tr><td colspan='2'>채팅 전송을 실패했습니다.</td></tr>");
		}
	}
} // showGreeting Function end

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
}); //onload Event Function end

function loadChat(){
	console.log(1);
 	$.ajax({
		'url' : 'chatdata/' +roomId,
		'type' : 'get',
		'dataType':'json',
		'success' : (data)=>{
			$("#greetings").prepend(data.map((message)=>"<tr><td class='nameArea'>" + message.chat_name + "</td><td class='contentArea'>" + message.chat_content + "</td></tr>"))
		},
		'error' : (error)=>{
			console.log(error);
		}
	});//ajax end 
}//loadChat Function End

</script>
</html>