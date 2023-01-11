<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link href="resources/home.css?after" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="inc/nav.jsp"></jsp:include>
<div class="login-page">
  <div class="form">
    <form class="register-form">
    <p class="message">다중 메일 보내기</p>
      <input type="text" placeholder="name"/>
      <input type="password" placeholder="password"/>
      <input type="text" placeholder="email address"/>
      <button>create</button>
      <button id="thymeleafButton" type="button">타임리프시험용</button>
      <p class="message">Already registered? <a href="#login">Sign In</a></p>
    </form>
    
    <form class="login-form">
    <h1 class="message">일반 메일 보내기</h1>
      <input type="text" placeholder="From.." id="fromEmail"  name="fromEmail" value="dhkdtpdn1998@naver.com" readonly="readonly"/>
      <input type="text" placeholder="To.." id="toEmail"  name="toEmail" />
		<label for="Timer" class="timer codeCheck">남은 시간:</label>
		<input id="Timer" class="timer codeCheck" type="text" value="" readonly/>
		<button id="codeCheckButton" type="button" class="codeCheck">Check</button>
      <button id="normalMailButton" type="button">Send</button>
      <button id="RegisterButton" type="button">Register</button>
      <p class="message">Not registered? <a href="#register">Create an account</a></p>
    </form>
  </div>
</div>
</body>
<script type="text/javascript">
	$('.message a').click(function(){
		   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	}); // .message a ClickEventFunction end
	
	// Send Button
	$('#normalMailButton').on({
		click : ()=>{
			$.ajax({
				url : "sendMail",
				type : "post",
				data : {
					"fromEmail" : $('#fromEmail').val(),
					"toEmail" : $('#toEmail').val()
				},
				success : (data)=>{
					console.log(data);
					if(data == 'success'){
						//html/css Change
						$('#toEmail').attr('readonly','readonly'); //readonly="readonly"
						$('#toEmail').after('<input type="text" placeholder="code" id="code"  name="hint" />');
						$('#normalMailButton').toggleClass('codeCheck');
						$('#codeCheckButton').toggleClass('codeCheck');
						$('.Timer').toggleClass('codeCheck');

						// Timer Start
						TIMER();
						setTimeout(function(){
							clearInterval(PlAYTIME);
						},180000);//3분이 되면 타이머를 삭제한다.
					}
				},
				error : (error)=>{
					console.log(error);
				}
			}); // ajax end
		}
	}) // Send Button Event end
	
	//CheckButton
	$('#codeCheckButton').on({
		click:()=>{
			$.ajax({
				url:"codeCheck",
				type:"post",
				data : {
					"email" : $('#toEmail').val(),
					"code" : $('#code').val()
				},
				success : (data) =>{
					console.log(data);
					if(data == 'success') {
						alert("체크 성공!");
						signup();
					} else {
						alert("체크 실패..");
					}
				},
				error : (error) =>{
					console.log(error);
				}
			})//ajax end
		}
	})//Check Button Event End

	function signup(){
		$.ajax({
			url: "join",
			type:"post",
			data :{
				"email" : $('#toEmail').val()
			},
			success :(result)=>{
				console.log(result)
			},
			error : (error)=>{
				console.log(error)
			}
		});
	}
	
	
	
	
	// Timer Setting
	const Timer=document.getElementById('Timer'); //스코어 기록창-분
	let time= 180000;
	let min=3;
	let sec=60;

	Timer.value=min+":"+'00'; 

	function TIMER(){
	    PlAYTIME=setInterval(function(){
	        time=time-1000; //1초씩 줄어듦
	        min=time/(60*1000); //초를 분으로 나눠준다.

	       if(sec>0){ //sec=60 에서 1씩 빼서 출력해준다.
	            sec=sec-1;
	            Timer.value=Math.floor(min)+':'+sec; //실수로 계산되기 때문에 소숫점 아래를 버리고 출력해준다.
	           
	        }
	        if(sec===0){
	         	// 0에서 -1을 하면 -59가 출력된다.
	            // 그래서 0이 되면 바로 sec을 60으로 돌려주고 value에는 0을 출력하도록 해준다.
	            sec=60;
	            Timer.value=Math.floor(min)+':'+'00'
	        }     
	   
	    },1000); //1초마다 
	}

	// Thymeleaf 실험용
	$('#thymeleafButton').on({
		click : ()=>{
			$.ajax({
				url:"/thymeleaf",
				type : "post",
				success : (result)=>{
					console.log(result)
				}
			});
		}
	})// thymeleafButton Event end
</script>
</html>
