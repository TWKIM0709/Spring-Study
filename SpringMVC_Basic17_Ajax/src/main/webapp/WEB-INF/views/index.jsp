<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Jquery Ajax Demo</title>
<style>
Table.GridOne {
	padding: 3px;
	margin: 0;
	background: lightyellow;
	border-collapse: collapse;	
	width:35%;
}
Table.GridOne Td {	
	padding:2px;
	border: 1px solid #ff9900;
	border-collapse: collapse;
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">

	function madeAjaxCall() {
		/* $.ajax({
 			type: "post",
 			url:  "response.kosa",
 			cache: false,				
 			data:'firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val(),
 		    success:function(data){ //callback  
 		    	 console.log(data);
 		    	$("#menuView").empty();
 		        var resv="";  
 		        $("#menuView").append("First Name:- " + data.firstname +"</br>Last Name:- " + data.lastname  + "</br>Email:- " + data.email + "<br>");
 		         
 		     },
 			error: function(){						
 				alert('Error while request..'	);
 			}
 		}); //ajax end */
		 /* let _param = {firstname:$("#firstName").val(), lastname:$("#lastName").val() , email:$("#email").val()};
		 _data = JSON.stringify(_param); //jsonString으로 변환
	   	 //alert(_data);
	   	 
	   	 
	   	$.ajax({
	   			  type : 'POST',
	   			  url : "response2.kosa",
	   			  cache: false,
	   			  dataType: "json",
	   			  data:_data,  
	   			  processData: false,
	   			  contentType: "application/json; charset=utf-8",
	   			  success : function(data, status){
	   			      console.log("status:"+status+","+"data:"+data);
	   			      console.log(data)
	   			      alert(data.email);
	   			  },
	   			  error: function(request, status, error){
	   			      //alert("loading error:" + request.status);
	   			      console.log("code : " +  request.statusText  + "\r\nmessage : " + request.responseText);
	   			   
	   			 }
	   			}); */
		 $.ajax({
	  			type: "post",
	  			url:  "response3.kosa",
	  			cache: false,				
	  			success:function(data){ //callback  
	  		    	 console.log(data);
	  				 console.log(data.result)
	  		     },
	  			error: function(){						
	  				alert('Error while request..'	);
	  			}
	  		}); 

	}
</script>
</head>
<body>
	<form name="employeeForm" method="post">	
		<table cellpadding="0" cellspacing="0" border="1" class="GridOne">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" id="firstName" value=""></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" id="lastName" value=""></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="Ajax Submit" id = "ajaxBtn" name = "ajaxBtn" onclick="madeAjaxCall();"></td>
			</tr>
		</table>
	</form>
	 <h1>TEST</h1>
	<div id="menuView"></div>
</body>
</html>
 