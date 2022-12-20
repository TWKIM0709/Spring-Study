<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<hr><h3>Header 입니다.</h3>
<a href="${pageContext.request.contextPath}/join/join.htm">회원가입</a>	||

<se:authorize access="!hasRole('ROLE_USER')">
	<a href="${pageContext.request.contextPath}/join/login.htm">로그인</a> ||
</se:authorize>
<se:authentication property="name" var="LoginUser" />
<se:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
	<a href="${pageContext.request.contextPath}/logout">(${LoginUser})로그아웃</a> ||
</se:authorize>
<a href="${pageContext.request.contextPath}/notice/noticeview.htm">게시판</a>	||	로그인한 아이디 : ${LoginUser}
<se:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
	<a href="${pageContext.request.contextPath}/join/memberconfirm.htm">(${LoginUser})정보수정</a> ||
</se:authorize>

<hr>