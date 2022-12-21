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
<link rel="stylesheet" href="resources/index.css">
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
				<th>
					<input type="text" name="search" id="search" placeholder="사원이름을 입력하고 Enter">
				</th>
				<th colspan='7'>EmpList</th>
				<th></th>
			</tr>
			<tr>
				<th>EMPNO</th>
				<th>ENAME</th>
				<th>JOB</th>
				<th>MGR</th>
				<th>HIREDATE</th>
				<th>SAL</th>
				<th>COMM</th>
				<th>DEPTNO</th>
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
			getList(pg,ps,search);
		}
	}
})

	function getList(pg, ps, search){
		$.ajax({
			type:"post",
			url:"ajaxEmpSearch.do",
			data:{
				"pg" : pg,
				"ps" : ps,
				"search" : search
			},
			success:(emp)=>{
				let maincontainer = "";
				$.each(emp,(index,emp) =>{
					console.log(emp);
					maincontainer += 
						'<tr>'+
							'<th>' + emp.empno +'</th>' +
							'<th>' + emp.ename +'</th>' +
							'<th>' + emp.job +'</th>' +
							'<th>' + emp.mgr+'</th>' +
							'<th>' + emp.hiredate+'</th>' +
							'<th>' + emp.sal +'</th>' +
							'<th>' + emp.comm+'</th>' +
							'<th>' + emp.deptno+'</th>' +
							'<th><input type="button" onclick="empupdate(this)" value="수정"></th>' +
							'<th><input type="button" onclick="empdelete(' + emp.empno + ')" value="삭제"></th>' +
						'</tr>';
				}) //each end
				$('#main-container').empty();
				$('#main-container').append(maincontainer);
			},//success Function end
			error : ()=>{
				console.log('error')
				alert('error');
			} //error Function end
		});//ajax end
	} //getList Function end
	
	//update 준비 버튼?
	function empupdate(element){
		const tr = $(element).closest('tr');
		const tharr = [...tr[0].childNodes];
		
		const empno = $(tharr[0]).text()
		const ename = $(tharr[1]).text()
		const job= $(tharr[2]).text()
		const mgr= $(tharr[3]).text()
		const hiredate= $(tharr[4]).text()
		const sal= $(tharr[5]).text()
		const comm= $(tharr[6]).text()
		const deptno= $(tharr[7]).text()
		
		let td = "<td><input type='text' value='"+ empno +"' readonly></td>";
			td +="<td><input type='text' value='"+ename +"'></td>";
			td +="<td><input type='text' value='" + job +"'></td>";
			td +="<td><input type='text' value='"+mgr +"'></td>";
			td +="<td><input type='text' value='"+hiredate +"' readonly></td>";
			td +="<td><input type='text' value='"+sal +"'></td>";
			td +="<td><input type='text' value='"+comm +"'></td>";
			td +="<td><input type='text' value='"+deptno +"'></td>";
			td +="<td colspan='2'><input type='button'onclick='empupdateconfirm(this)' value='완료' value2="+empno+" /></td>";
			$(tr).empty();
			$(tr).append(td);
	}//empupdate Function end

//update 비동기 처리 함수
function empupdateconfirm(me){
	var tr = $(me).closest('tr');
	var data = {empno:tr.find("td:eq(0)").children().val(),
				ename:tr.find("td:eq(1)").children().val(),
				job:tr.find("td:eq(2)").children().val(),
				mgr:tr.find("td:eq(3)").children().val(),
				hiredate:tr.find("td:eq(4)").children().val(),
				sal:tr.find("td:eq(5)").children().val(),
				comm:tr.find("td:eq(6)").children().val(),
				deptno:tr.find("td:eq(7)").children().val(),
			   }; //data end
		$.ajax({
			type : "post",
			url:"ajaxEmpUpdate.do",
			data:data,
			success : function(data){  
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
		td +="<td><input type='text'></td>";
		td +="<td><input type='text'></td>";
		td +="<td><input type='text'></td>";
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
		var tr = $(me).closest('tr');
		var data = {empno:tr.find("td:eq(0)").children().val(),
					ename:tr.find("td:eq(1)").children().val(),
					job:tr.find("td:eq(2)").children().val(),
					mgr:tr.find("td:eq(3)").children().val(),
					hiredate:tr.find("td:eq(4)").children().val(),
					sal:tr.find("td:eq(5)").children().val(),
					comm:tr.find("td:eq(6)").children().val(),
					deptno:tr.find("td:eq(7)").children().val(),
				   };
		$.ajax({
			type : "post",
			url:"ajaxEmpInsert.do",
			data:data,
			success : (data)=>{  
				getList(pg,ps,search);
				$('#inputArea').empty();
				$('#inputArea').append("<td colspan='10'><input type='button' onclick='createinput(this)' value='사원등록'></td>");
			},
			error : (data) =>{alert(data)}
		})
	}//empinsert Function end
	
	function empdelete(empno){
		$.ajax({
			type:'post',
			url:"ajaxEmpDelete.do",
			data:{"empno" : empno},
			success : (data)=>{  
				getList(pg,ps,search);
			},
			error: (error)=>{
				alert(error);
			}
		});
	}
	getList(pg,ps,search);
</script>
</html>