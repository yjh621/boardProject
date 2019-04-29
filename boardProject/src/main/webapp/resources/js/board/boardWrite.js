$(document).ready(function(){
	
});

function registBoard() {
		
	if($("#title").val() == "" && $("#contents").val() == "") {
		alert("제목과 글 내용 중 하나랃 입력해주세요.")
		return false;
	}
			
	var requestData = {
		brd_title : $("#title").val(),
		brd_contents : $("#contents").val()		
	}
	
	$.ajax({
		url : getContextPath() + '/process/board/regist',
		method : "PUT",
		dataType : "json", //ajax통신으로 받을 데이터 타입
		contentType : "application/json; charset=UTF-8", //ajax 통신으로 보낼 데이터 타입		
		beforeSend : function(xmlHttpRequest) {
			xmlHttpRequest.setRequestHeader("AJAX", true); //session interceptor처리를 위해 header에 기록한다.
		},
		data : JSON.stringify(requestData),
		success : function(responseData) {
			if(responseData.result) {
				window.location.href = getContextPath() + '/board/boardList';
			} else {
				alert(responseData.desc);
			}
		},
		error : function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		
	});
}