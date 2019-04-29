package com.icc.si.board.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

public class UserVO implements Serializable {

	//Serializable는 이 클래스에 있는 객체에 저장된 데이터를 외부로 내보내거나 네트워크로 전송될수 있도록 사용하는 것이다. ex)FileOutputStream
	//Map 같은 것은 Serializable가 내장되어 있다. 
	private static final long serialVersionUID = 1L;
	

	private String usr_id;
	private int usr_pwd;
	private String usr_nm;
	
	
	public UserVO() {}
	
	public UserVO( String usr_id, int usr_pwd, String usr_nm) {
		
		this.usr_id = usr_id;
		this.usr_pwd = usr_pwd;
		this.usr_nm = usr_nm;
	}	
	
	
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public int getUsr_pwd() {
		return usr_pwd;
	}
	public void setUsr_pwd(int usr_pwd) {
		this.usr_pwd = usr_pwd;
	}
	public String getUsr_nm() {
		return usr_nm;
	}
	public void setUsr_nm(String usr_nm) {
		this.usr_nm = usr_nm;
	}
			
	@Override
	public String toString() {
		return "UserVo [usr_id=" + usr_id + ",usr_pwd=" + usr_pwd + ", usr_nm=" + usr_nm + "]";
	}
	
}
