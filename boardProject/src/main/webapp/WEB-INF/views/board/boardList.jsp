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
<select>
  <option>제목</option>
  <option>작성자</option>
</select>
<input type="text">
<br><br>
<table>
	<thead>
		<tr>		
			<th class="row2">제목</th>
			<th class="row3">작성자</th>
			<th class="row4">작성일</th>
			<th class="row5">조회수</th>
		</tr>
	</thead>
	<tbody id="getBoardList">
	
	</tbody>
</table>
<button type="button" onclick='window.location.href="${pageContext.request.contextPath}/board/regist"'>글쓰기</button>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/${board}.js">
</script>
</body>
</html>
