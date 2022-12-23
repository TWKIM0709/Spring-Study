<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- css -->
<style type="text/css">
body {
	padding: 1.5em;
	background: #f5f5f5
}

table {
	border: 1px #a39485 solid;
	font-size: .9em;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	width: 100%;
	border-collapse: collapse;
	border-radius: 5px;
	overflow: hidden;
}

th {
	text-align: center;
}

thead {
	font-weight: bold;
	color: #fff;
	background: #73685d;
}

td, th {
	padding: 1em .5em;
	vertical-align: middle;
}

td {
	border-bottom: 1px solid rgba(0, 0, 0, .1);
	background: #fff;
}

a {
	color: #73685d;
}

@media all and (max-width: 768px) {
	table, thead, tbody, th, td, tr {
		display: block;
	}
	th {
		text-align: center;
	}
	table {
		position: relative;
		padding-bottom: 0;
		border: none;
		box-shadow: 0 0 10px rgba(0, 0, 0, .2);
	}
	thead {
		float: left;
		white-space: nowrap;
	}
	tbody {
		overflow-x: auto;
		overflow-y: hidden;
		position: relative;
		white-space: nowrap;
	}
	tr {
		display: inline-block;
		vertical-align: top;
	}
	th {
		border-bottom: 1px solid #a39485;
	}
	td {
		border-bottom: 1px solid #e5e5e5;
	}
}
</style>
<!-- BootStrap -->
</head>
<body>
	<table>
		<thead>
			<tr>
				<th><select id="psSelect">
						<option value='5'>5</option>
						<option value='10'>10</option>
						<option value='15'>15</option>
				</select></th>
				<th><input type="text" name="search" id="search"
					placeholder="사원번호를 입력하고 Enter"></th>
				<th colspan='2'>EmpList</th>
				<th></th>
			</tr>
			<tr>
				<th>EMPNO</th>
				<th>ENAME</th>
				<th>SAL</th>
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody id="main-container">

		</tbody>
		<tr id="inputArea">
			<td><input type="button" onclick="createinput(this)"
				value="사원등록"></td>
		</tr>
	</table>
</body>
<script type="text/javascript">

let pg = 1;
let ps = 5;
let search='';

$('#psSelect').on({
	change:(element)=>{
		let item = $('#psSelect option:selected').text();
		ps = item;
		getList(pg,ps,search);
	}
});
$('#search').on({
	//onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}"/>
	keypress:(event)=>{
		if(event.keyCode == 13 ) {
			search = $('#search').val();
			getListByEmpno(pg,ps,search);
		}
	}
})

	function getList(pg, ps, search){
		$.ajax({
			type:"get",
			url:"emp",
			dataType:"json",
			success:(emp)=>{
				console.log('asdf');
				let maincontainer = "";
				$.each(emp,(index,emp) =>{
					console.log(emp);
					maincontainer += 
						'<tr>'+
							'<th>' + emp.empno +'</th>' +
							'<th>' + emp.ename +'</th>' +
							'<th>' + emp.sal +'</th>' +
							'<th><input type="button" onclick="empupdate(this)" value="수정"></th>' +
							'<th><input type="button" onclick="empdelete(' + emp.empno + ')" value="삭제"></th>' +
						'</tr>';
				}) //each end
				$('#main-container').empty();
				$('#main-container').append(maincontainer);
			},//success Function end
			error : (error)=>{
				console.log(error)
			} //error Function end
		});//ajax end
	} //getList Function end
	
	function getListByEmpno(pg, ps, search){
		$.ajax({
			type:"get",
			url:"emp/" + search,
			dataType:"json",
			success:(emp)=>{
				console.log(emp);
				let maincontainer = "";
					maincontainer += 
						'<tr>'+
							'<th>' + emp.empno +'</th>' +
							'<th>' + emp.ename +'</th>' +
							'<th>' + emp.sal +'</th>' +
							'<th><input type="button" onclick="empupdate(this)" value="수정"></th>' +
							'<th><input type="button" onclick="empdelete(' + emp.empno + ')" value="삭제"></th>' +
						'</tr>';
				$('#main-container').empty();
				$('#main-container').append(maincontainer);
			},//success Function end
			error : (error)=>{
				console.log(error)
			} //error Function end
		});//ajax end
	} //getList Function end
	
	//update 준비 버튼?
	function empupdate(element){
		const tr = $(element).closest('tr');
		const tharr = [...tr[0].childNodes];
		
		const empno = $(tharr[0]).text()
		const ename = $(tharr[1]).text()
		const sal= $(tharr[2]).text()
		
		let td = "<td><input type='text' value='"+ empno +"' readonly></td>";
			td +="<td><input type='text' value='"+ename +"'></td>";
			td +="<td><input type='text' value='"+sal +"'></td>";
			td +="<td colspan='2'><input type='button'onclick='empupdateconfirm(this)' value='완료' value2="+empno+" /></td>";
			$(tr).empty();
			$(tr).append(td);
	}//empupdate Function end

//update 비동기 처리 함수
function empupdateconfirm(me){
		
	/* AJAX에서 아래와 같이 설정해야함.
	data : JSON.stringify(object);
	contentType: 'json' */
	console.log('a');
	var tr = $(me).closest('tr');
	var data = {"empno":tr.find("td:eq(0)").children().val(),
				"ename":tr.find("td:eq(1)").children().val(),
				"sal":tr.find("td:eq(2)").children().val()
			   }; //data end
		$.ajax({
			type : "put",
			url:"emp",
			data:JSON.stringify(data),
			contentType:'application/json',
			success : function(data){  
				console.log('b');
				getList(pg,ps,search);
			} 
		}) //ajax end
	}//empupdateconfirm Function end

	//사원등록 버튼용 함수
	function createinput(me){
		var tr = $(me).closest('tr');
		tr.empty();
		var td = "<td><input type='text'></td>";
		td +="<td><input type='text'></td>";
		td +="<td><input type='text'></td>";
		td +="<td><input type='button'onclick='empinsert(this)' value='완료'/></td>";
		td +="<td><input type='button'onclick='cancel(this)' value='취소'/></td>";
		$(tr).append(td); 
	}//createinput Function end

	//취소버튼
	function cancel(me){
		var tr = $(me).closest('tr');
		tr.empty();
		tr.append("<td colspan='10'><input type='button' onclick='createinput(this)' value='사원등록'></td>");
	}//cancle Function end
	//등록 처리
	function empinsert(me){
		console.log('a');
		var tr = $(me).closest('tr');
		console.log('b');
		var data = {"empno":tr.find("td:eq(0)").children().val(),
					"ename":tr.find("td:eq(1)").children().val(),
					"sal":tr.find("td:eq(2)").children().val()
				   };
		console.log(data);	
		$.ajax({
			type : "post",
			url:"emp",
			data:data,
			success : (data)=>{  
				getList(pg,ps,search);
				$('#inputArea').empty();
				$('#inputArea').append("<td colspan='10'><input type='button' onclick='createinput(this)' value='사원등록'></td>");
			},
			error : (error) =>{console.log(error)}
		})
	}//empinsert Function end
	
	function empdelete(empno){
		$.ajax({
			type:'delete',
			url:"emp/" + empno,
			success : (data)=>{  
				getList(pg,ps,search);
			},
			error: (error)=>{
				alert(error);
			}
		});
	}
	function empDateFormat(date){
		return date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
	}
	getList(pg,ps,search);
</script>
</html>