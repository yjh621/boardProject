<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
	
<script type="text/javascript">
	function getContextPath() {
		var contextPath = "<%=request.getContextPath()%>";
		return contextPath;
	}
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/library/jquery-3.3.1.min.js"></script>
<body>
<c:if test="${sessionScope.usr_id != null}">
<header>
	<h2 class="boardTitle">게시판</h2>
	<button type="button" class="logout" onclick="logout()">로그아웃</button>
	<hr>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/main.js">
</script>
</header>
</c:if>
</body>
</html>	