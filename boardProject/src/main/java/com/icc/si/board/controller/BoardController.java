package com.icc.si.board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icc.si.board.service.BoardService;
import com.icc.si.board.vo.BoardVO;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 게시판 화면 진입
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/board/boardList", method = RequestMethod.GET)
	public String board(Model model, HttpSession session) {
		String url = null;
		if(session.getAttribute("usr_id") == null) {
			url = "redirect:/";			
		} else {
			
			url = "board/boardList";
		}
		logger.info("-게시판 화면 진입-");		
		
		model.addAttribute("board", url);		
		
		return url;
	}
	
	@ResponseBody
	@RequestMapping(value="/process/board/boardList", method=RequestMethod.POST)
	public List<BoardVO> processBoardList() throws Exception{
		List<BoardVO> boardList = boardService.getBoardList();
		
		return boardList;
	}
	
	@RequestMapping(value="/board/boardDetail/{brd_seq}", method=RequestMethod.GET)
	public String boardDetailPage(Model model, HttpSession session, BoardVO board, @PathVariable(value="brd_seq") int brd_seq) {		
		
		String url = null;
	
		if(session.getAttribute("usr_id") == null) {
			url = "redirect:/";			
		} else {
			
			boardService.updateBoardCnt(brd_seq); //조회수를 증가시킵니다.
			BoardVO getBoardDetail = boardService.getBoardDetail(brd_seq); //선택한 글의 내용을 봅니다.			
			model.addAttribute("BoardDetail", getBoardDetail);			
			
			url = "board/boardDetail";
		}
		logger.info("-게시판 내용 상세보기 진입-");
		model.addAttribute("board", url);		
		
		return url;		
	}
	
	@RequestMapping(value="/board/regist", method=RequestMethod.GET) 
	public String boardregistPage(Model model, HttpSession session) {
		String url = null;
		if(session.getAttribute("usr_id") == null) {
			url = "redirect:/";			
		} else {
			url = "board/boardWrite";
		}
		logger.info("-게시판 글쓰기 화면 진입-");		
		
		model.addAttribute("board", url);		
		
		return url;
	}
	
	@ResponseBody
	@RequestMapping(value="/process/board/regist/{brd_seq}", produces="application/json", method=RequestMethod.PUT)
	public Map<String, Object> processBoardRegist(@RequestBody BoardVO board, @PathVariable(value="brd_seq") int brd_seq, HttpSession session) throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>(); //클라이언트로 전송하기 위한 것.		
		String writer = null;
		
		try {
			writer = session.getAttribute("usr_id").toString();					
		} catch(Exception e) {
			e.printStackTrace();
			resultMap.put("result", false);
			resultMap.put("desc", "로그인을 해주세요.");
			return resultMap;
		} 
		
		board.setbrd_usr_id(writer);
				
		try {
				if(boardService.registBoard(board) == 1) {				
					logger.info("-게시판 글 등록 성공-");	
					resultMap.put("result", true);
					
				} else {
					logger.info("-글 등록 실패-");
					resultMap.put("result", false);
					resultMap.put("desc", "글 등록에 실패하였습니다.");
				}
				
		} catch(Exception e) {
			e.printStackTrace();
			resultMap.put("result", false);
			resultMap.put("desc", "서버 에러입니다.");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value="/board/modify/{brd_seq}", method=RequestMethod.GET)
	public String boardModifyPage(Model model, HttpSession session, @PathVariable(value="brd_seq") int brd_seq ) {
		String url = null;
		
		if(session.getAttribute("usr_id") == null) {
			url = "redirect:/";			
		} else {			
			if(boardService.boardWriterCheck(session.getAttribute("usr_id").toString(), brd_seq)) {
				BoardVO getBoardDetail = boardService.getBoardDetail(brd_seq); //선택한 글의 내용을 봅니다.			
				model.addAttribute("BoardDetail", getBoardDetail);			
				
				url = "board/boardModify";
			} else {
				url = "redirect:/";
			}
		}
		logger.info("-게시판 수정 화면 진입-");		
		
		model.addAttribute("board", url);		
		
		return url;
	}
	
	@ResponseBody
	@RequestMapping(value="/process/board/modify/{brd_seq}", produces="application/json", method=RequestMethod.PUT)
	public Map<String, Object> boardModifyProcess(HttpSession session, @PathVariable(value="brd_seq") int brd_seq, 
			@RequestBody BoardVO board) {
		Map<String, Object> result = new HashMap<String, Object>();
		String writer = null;
		
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mdfDate = transFormat.format(date);
		
		try {
			writer = session.getAttribute("usr_id").toString();
		} catch(Exception e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("desc", "로그인을 해주세요.");		
			return result;
		}
		
		board.setBrd_mdf_date(mdfDate);
		
		try {
			board.setbrd_usr_id(writer);
			
			if(boardService.boardWriterCheck(writer, brd_seq)) {
				if(boardService.modifyBoard(board) == 1) {
					result.put("result", true);
					result.put("desc", "성공적으로 게시물이 수정되었습니다.");
					System.out.println(board.getBrd_mdf_date());
				} else {
					result.put("result", false);
					result.put("desc", "게시물 수정을 실패하였습니다.");
				}
				
			} else {
				result.put("result", false);
				result.put("desc", "게시물을 작성한 사용자가 아니면 해당 글을 수정할 수 없습니다.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("desc", "서버 에러입니다.");
		}
				
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/process/board/delete/{brd_seq}", produces="application/json", method=RequestMethod.POST)
	public Map<String, Object> boardDeleteProcess(HttpSession session, @PathVariable(value="brd_seq") int brd_seq) {
		Map<String, Object> result = new HashMap<String, Object>();
		String writer = null;
				
		try {
			writer = session.getAttribute("usr_id").toString();
		} catch(Exception e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("desc", "로그인을 해주세요.");		
			return result;
		}
		
		
		try {
			if(boardService.boardWriterCheck(writer, brd_seq)) {
				if(boardService.deleteBoard(brd_seq) == 1) {
					result.put("result", true);				
				
				} else {
					result.put("result", false);
					result.put("desc", "게시물 삭제에 실패하였습니다.");
				}
				
			} else {
				result.put("result", false);
				result.put("desc", "게시물을 작성한 사용자가 아니면 해당 글을 삭제할 수 없습니다.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("desc", "서버 에러입니다.");
		}
				
		return result;
	}
	
	
}
