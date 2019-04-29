package com.icc.si.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icc.si.board.service.UserService;
import com.icc.si.board.vo.UserVO;

@RequestMapping("/user")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
	@Autowired
	private UserService userService;
	
	/**
	 * 로그인을 처리합니다.
	 * 	 
	 * @param usrId
	 * @param usrPwd
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/process/login", produces = "application/json", method = RequestMethod.POST)
	public Map<String, Object> userLoginProcess(@RequestBody UserVO user, HttpSession session) throws IOException {
		
		Map<String, Object> result = new HashMap<String, Object>();	
		
		try {
			
			if (userService.userLogin(user)) { // 아이디, 패스워드 체크
					// 로그인 성공 시
				logger.info("-로그인 성공-");				
			
					session.setAttribute("usr_id", user.getUsr_id());			
					result.put("result", true);		
				
				} else {
					// 비밀번호가 일치하지 않을 때
				
					logger.info("-로그인 실패-");
					result.put("result", false);				
					result.put("desc", "아이디나 비밀번호 확인을 다시해주세요.");					
				}
		
		} catch (IllegalArgumentException e) {
			/**
			 * 잘못된 비밀번호 입력 시
			 */
			logger.info("-로그인 실패-");
			e.printStackTrace();
			result.put("result", false);			
			result.put("desc", "비밀번호는 숫자 4자리로 입력해주세요.");
		
		} catch (Exception e) {
			// 그외 서버 에러
			e.printStackTrace();
			// logger.info("-로그인 실패-");
			result.put("result", false);			
			result.put("desc", "서버 에러입니다.");
		}
		return result;
	}
	
	/**
	 * 로그아웃을 처리합니다.
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/process/logout", produces = "application/json", method = RequestMethod.POST)
	public Map<String, Object> userLogoutProcess(HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {			
			session.removeAttribute("usr_id");			
			result.put("result", true);	
			
		} catch (Exception e) {			
			e.printStackTrace();
			result.put("result", false);
			result.put("desc", "서버 에러입니다.");			
		}
		
		return result;
		
	}
	
}
