package com.icc.si.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.icc.si.board.vo.UserVO;

@Repository
public class UserDao {

	
	@Autowired
	private SqlSessionTemplate session;
	
	/**
	 * 사용자 로그인을 합니다.
	 * 
	 * @author judy621
	 * @param usrId
	 * @return
	 */
	public boolean userLogin(UserVO user) {
		return session.selectOne("userMapper.userLogin", user);
	}
	
	
}
