
function deleteBoard() {
	
	var brdSeq = $("#brdSeq").val();
	
	if(confirm("정말로 삭제하시겠습니까?") == true){
		$.ajax({
			url : getContextPath() + '/process/board/delete/' + brdSeq,
		    method : 'POST',
		    dataType : 'json',
		    data : {
		    	"brd_seq" : brdSeq
		    },
		    success : function(data) {
		    	if(data.result) {
		    		alert("삭제가 완료되었습니다.");
		    		window.location.href = getContextPath() + '/';
		    	} else {
		    		alert(data.desc);
		    	}
		    }, 
		    error : function(request,status,error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
    }
}

