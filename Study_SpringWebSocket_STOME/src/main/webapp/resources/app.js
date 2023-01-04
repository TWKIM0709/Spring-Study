var stompClient = null;

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
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
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

function sendName() {
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