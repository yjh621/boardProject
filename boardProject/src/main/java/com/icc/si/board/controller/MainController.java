package com.icc.si.board.controller;


import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {		
		logger.info("-로그인 화면 진입-");	
				
		String url = null;
		if (session.getAttribute("usr_id") != null) {
			// 로그인 상태의 경우 출퇴근 화면으로 리다이렉트 시킨다.
			//redirect: 뒤에 주소로 url 요청을 다시한다. 그로인해 주소가 바뀌고 해당 url에 속하는 컨트롤러의 함수가 한번 더 호출된다.
			//redirect를 안쓰면 단순히 페이지로 넘어가고, 쓰면 같은 페이지지만 기능들이 작동되는 페이지로 넘어간다.
			url = "redirect:/board/boardList";			
			
		} else {
			
			url = "main";	
			model.addAttribute("main", url);
		}			
		return url;
	}
	
	
}
