package com.icc.si.board.service;


import com.icc.si.board.vo.UserVO;

public interface UserService {

	/**
	 * 사용자 로그인을 합니다.
	 * 
	 * @author judy621
	 * @param usrId
	 * @return
	 */
	public boolean userLogin(UserVO user);

}
