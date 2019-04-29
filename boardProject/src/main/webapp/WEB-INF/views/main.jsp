<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/${main}.css">
<jsp:include page="/WEB-INF/views/header.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/${main}.js">
	
</script>
</head>
<body>
	<h1 style="color:green">로그인</h1>

	<strong>aaaaId :</strong>
	<input type="text" id="userId" /> Password :
	<input type="password" id="userPwd" />
	<button type="button" onclick="loginCheck()">로그인</button>

</body>
</html>
