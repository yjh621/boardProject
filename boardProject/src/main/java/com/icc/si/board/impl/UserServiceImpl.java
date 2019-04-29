package com.icc.si.board.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icc.si.board.dao.UserDao;
import com.icc.si.board.service.UserService;
import com.icc.si.board.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 사용자 로그인을 합니다.
	 */
	public boolean userLogin(UserVO user) {
		return userDao.userLogin(user);
	}	
	
}
