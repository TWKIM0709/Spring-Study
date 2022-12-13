<%@page import="kr.co.mycom.ibatis.guest.GuestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="d" class="kr.co.mycom.ibatis.guest.GuestDTO" />
<jsp:setProperty property="*" name="d"/>

<%
	//out.print("dto="+d.toString());
	GuestDAO.insertGuest(d); 
	//GuestDAO.insertParamGuest(d);
%>
<a href="list.jsp">List</a>