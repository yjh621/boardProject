
function modifyBoard() {
	
	var brdSeq = $("#brdSeq").val();
	
	if($("#title").val() == "" && $("#contents").val() == "") {
		alert("제목과 글 내용 중 하나랃 입력해주세요.")
		return false;
	}
			
	var requestData = {
		brd_title : $("#title").val(),
		brd_contents : $("#contents").val(),	
		brd_seq : brdSeq
	}
	
	$.ajax({
		url : getContextPath() + '/process/board/modify/' + brdSeq,
		method : "PUT",
		dataType : "json",
		contentType : "application/json; charset=UTF-8",		
		beforeSend : function(xmlHttpRequest) {
			xmlHttpRequest.setRequestHeader("AJAX", true); //session interceptor처리를 위해 header에 기록한다.
		},
		data : JSON.stringify(requestData),
		success : function(responseData) {
			if(responseData.result) {
				alert(responseData.desc);
				window.location.href = getContextPath() + '/board/boardList';
			} else {
				alert(responseData.desc);
			}
		}, 
		error : function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		
	})
}