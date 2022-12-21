<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#ajaxBtn').click(function(){
				 const array = new Array();
				     array[0] = "a";
				     array[1] = "b";
				 $.ajax(
						 { //json  방식
							type : "post",
							url  : "json.kosa",
							data : "command=AjaxTest&name=java&arr="+array,
							success : function(data){  //서버 {"menu",list}   //data > {}
								console.log(data);
								$('#menuView').empty();
								var opr="";
								$.each(data.menu,function(index,value){ //data.menu > ["치킨맥주","돈까스","치킨피자"]
									console.log(index + "/" + value);
									opr += index + "." + value + "<br>";
								});
								$('#menuView').append(opr);
							} 
						 } 
				       )    
			});
			
			
			$('#ajaxBtn2').click(function(){
				 $.ajax(
						 {   
							type : "post",
							url  : "json2.kosa",
							data : "command=AjaxTest2&name=java2",
							success : function(data){
								console.log(data);
								$('#menuView').empty();
								var opr="";
								$.each(data.menu,function(index,obj){  //obj > {}
									console.log(index + "/" + obj);
									opr += obj.beer + "<br>";
									opr += obj.food + "<br>";
									opr += index +"<br><hr>"
								});
								$('#menuView').append(opr);
							} 
						 } 
				       )    
			});
			
			
			$('#ajaxBtn3').click(function(){
				 $.ajax(
						 {
							type : "post",
							url  : "json3.kosa",
							success : function(data){
								console.log(data);
								$('#menuView').empty();
								var opr="";
								$.each(data.data,function(index,obj){
									console.log(index + "/" + obj);
									opr += obj.firstname + "<br>";
									opr += obj.lastname + "<br>";
									opr += obj.email + "<br>";
									opr += index +"<br><hr>"
								});
								$('#menuView').append(opr);
							} 
						 } 
				       )    
			});
			
			
			$('#ajaxBtn4').click(function(){
				var aaa = [];
				bbb = "NEWDATA";
				ccc = '[{"Product" : "Mouse", "Maker":"Samsung", "Price":23000},{"Product" : "KeyBoard", "Maker":"LG", "Price":12000}]';
				aaa.push(10);
				aaa.push(20);
				aaa.push(30);
				aaa.push(40);


				 $.ajax(
						 {
							type : "post",
							url  : "json4.kosa",
							data : {aaa:aaa, bbb:bbb, ccc:ccc}, //?aaa=aaa&bbb=bbb&
							success : function(data){
								console.log(data);
							} 
						 } 
				       )    
			});
			
		});
	
	</script>
</head>
<body>
	<input type="button" value="Spring-json1" id="ajaxBtn">
	<input type="button" value="Spring-json2" id="ajaxBtn2">
	<input type="button" value="Spring-json3" id="ajaxBtn3">
	<input type="button" value="Spring-json4" id="ajaxBtn4">
	<hr>
	<span id="menuView"></span>
</body>
</html>