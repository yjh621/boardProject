$(document).ready(function(){
	
});

function loginCheck() {
	
	//아이디는 영대소문자, 숫자, - , _ 만 가능하도록 하며
	//패스워드는 숫자 4자리만 가능하도록 한다.
	//var idChk = /([^a-zA-Z0-9-_])/;	
	
	var idChk = /^[A-za-z0-9]/g;	
	var pwdChk = /^[0-9]{4,}$/;
	
	var userId = $("#userId").val();
	var userPwd = $("#userPwd").val();
	
	if (userId == '') {	
		alert("아이디를 입력해주세요.");
		userId.focus();
		return false;
	}
	
	if (idChk.test(userId) == false) {
		alert("아이디는 영대소문자, 숫자만 가능합니다.");
		$("#userId").val('');
		$("#userId").focus();
		return false;
	}
	
	if (userPwd == '') {	
		alert("비밀번호를 입력해주세요.");
		$("#userPwd").focus();
		return false;
	}
	
	if (pwdChk.test(userPwd) == false) {
		alert("비밀번호는 숫자4자리로만 입력해주세요.");
		$("#userPwd").val('')
		$("#userPwd").focus();
		return false;
	}
	
	var data = {
			usr_id : userId,
			usr_pwd : userPwd
		};
	
	$.ajax({
		url : getContextPath() + "/user/process/login",
		method : "POST",
		dataType : "json",		
		data : JSON.stringify(data),
		contentType: "application/json; charset=UTF-8",
		beforeSend : function(xmlHttpRequest) {
			xmlHttpRequest.setRequestHeader("AJAX", true); //session interceptor처리를 위해 header에 기록한다.
		},
		success : function(data) {
			if(data.result) {
				window.location.href = getContextPath() + "/board/boardList";
			} else {
				alert(data.desc);
				$("#userId").val('');
				$("#userPwd").val('');
			}
		},
		error : function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		
	});
	
}

function logout() {
	if(confirm("정말로 로그아웃을 하시겠습니까?") == true) {
		$.ajax({
			url : getContextPath() + "/user/process/logout",
			method : "POST",
			dataType : "json",		
			success : function(data) {
				if (data.result) {
					window.location.href = getContextPath();
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