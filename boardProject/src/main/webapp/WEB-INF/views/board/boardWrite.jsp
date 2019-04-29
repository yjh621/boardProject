<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/${board}.css">
</head>
<jsp:include page="/WEB-INF/views/header.jsp" />
<body>
<br><br><br>

제목 : <input type="text" id="title" style="width:50%;">
<br><br>
<textarea id="contents" cols="100" rows="10"></textarea>
<br>
<button type="button" onclick="registBoard()">등록</button>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/${board}.js">
</script>
</body>
</html>
