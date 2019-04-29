<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<title>내용 상세보기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/${board}.css">
</head>
<jsp:include page="/WEB-INF/views/header.jsp" />
<body>
<br>
<div class="detailBorder" >	
<h4>
<c:if test="${BoardDetail.brd_title == ''}">
제목없음
</c:if>
<c:if test="${BoardDetail.brd_title != ''}">
${BoardDetail.brd_title}
</c:if>
</h4>

${BoardDetail.brd_usr_nm} |
<c:if test="${BoardDetail.brd_mdf_date == null}">${BoardDetail.brd_reg_date}</c:if>
<c:if test="${BoardDetail.brd_mdf_date != null}">${BoardDetail.brd_mdf_date}</c:if> |
조회수 : ${BoardDetail.brd_view_cnt}
<br><hr>
${BoardDetail.brd_contents}
</div>
<c:if test="${usr_id eq BoardDetail.brd_usr_id}">
<div class="buttonDiv"> 
   <button type="button" onclick='window.location.href="${pageContext.request.contextPath}/board/modify/${BoardDetail.brd_seq}"'>수정</button>
   <input type="hidden" id="brdSeq" value="${BoardDetail.brd_seq}" />
   <button type="button" onclick="deleteBoard()">삭제</button>
</div>
<hr>
</c:if>
<h4>댓글달기</h4>
<textarea cols="60" rows="5"></textarea>
<button type="button">등록</button>
<br><br><hr>
<div class="replyList">
유호두 | 2018-11-10 10:13:10 &nbsp;&nbsp;&nbsp;반갑습니다.<br>
유호두 | 2018-11-10 10:13:10 &nbsp;&nbsp;&nbsp;반갑습니다.
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/${board}.js">
</script>
</body>
</html>