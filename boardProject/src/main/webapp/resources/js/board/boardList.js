$(document).ready(function(){
	getListProcess(); //게시글 목록 가져오기.	
});


function getListProcess() {
	$.ajax({
		url : getContextPath() + '/process/board/boardList',
		method : "POST",
		dataType : 'json',
		beforeSend : function(xmlHttpRequest) {
			xmlHttpRequest.setRequestHeader("AJAX", true); //session interceptor처리를 위해 header에 기록한다.
		},
		success : function(data) {		
			getBoardList(data);			
		},
		error : function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function getBoardList(data) {
	var html = "";	
		
	if(data.length > 0) {		
		for(var i=0; i<data.length; i++) {
			var title = data[i].brd_title;
			if(title =="") {
				title = "제목없음";
			}
			html += '<tr>';		
			html += '<td><a href="' + getContextPath()  +'/board/boardDetail/'+ data[i].brd_seq +'">';
			html += title;
			html += '</a></td>';
			html += '<td>' + data[i].brd_usr_nm  + '</td>';
			html += '<td>'  + data[i].brd_reg_date  + '</td>';
			html += '<td>'  + data[i].brd_view_cnt  +  '</td>';	
			html += '</tr>';
		}
	} else {
		html += '<tr>';
		html += '<td colspan="4">동록된 글이 없습니다.</td>';
		html += '</tr>';	
	}
	
	$("#getBoardList").append(html);
	
}