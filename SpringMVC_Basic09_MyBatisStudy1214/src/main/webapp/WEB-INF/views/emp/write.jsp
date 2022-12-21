<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
   <meta charset="UTF-8">
   <title>Manage the EMP table</title>
   <style>
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
   text-align: left;
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
      text-align: right;
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
</head>
<body>
		<form method="post">
   <table class="table">
   <thead>
         <tr>
            <th scope="col">EMPNO</th>
            <th scope="col">ENAME</th>
            <th scope="col">JOB</th>
            <th scope="col">MGR</th>
            <th scope="col">SAL</th>
            <th scope="col">COMM</th>
            <th scope="col">DEPTNO</th>
         </tr>
      </thead>
      <tbody>
      		<tr>
	            <th scope="col"><input type="text" name="empno" ></input></th>
	            <th scope="col"><input type="text" name="ename" ></input></th>
	            <th scope="col"><input type="text" name="job" ></input></th>
	            <th scope="col"><input type="number" name="mgr" ></input></th>
	            <th scope="col"><input type="number" name="sal" ></input></th>
	            <th scope="col"><input type="number" name="comm" ></input></th>
	            <th scope="col"><input type="number" name="deptno" ></input></th>
      		</tr>
      		<tr>
      			<td><input type="submit" value="사원등록"></input></td>
      			<td></td>
      		</tr>
      </tbody>
      </table>
       </form>
</body>
</html>