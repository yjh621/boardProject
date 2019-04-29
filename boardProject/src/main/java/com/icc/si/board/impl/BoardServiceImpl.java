package com.icc.si.board.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icc.si.board.dao.BoardDao;
import com.icc.si.board.service.BoardService;
import com.icc.si.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	/**
	 * 게시물 목록을 보여줍니다.
	 * 
	 * @author judy621
	 * @return
	 */
	
	public List<BoardVO> getBoardList() {		
		return boardDao.getBoardList();
	}
	
	/**
	 * 게시물 내용을 가져온다.
	 * 
	 * @author judy621
	 * @return
	 */
	public BoardVO getBoardDetail(int brd_seq) {	
		return boardDao.getBoardDetail(brd_seq);
	}
	
	/**
	 * 해당 게시물을 작성한 사용자를 가져옵니다. 
	 * 
	 * @param board
	 * @return
	 */
	public boolean boardWriterCheck(String brd_usr_id, int brd_seq) {
		BoardVO board = new BoardVO();
		board.setbrd_usr_id(brd_usr_id);
		board.setBrd_seq(brd_seq);
		
		return boardDao.boardWriterCheck(board);
	}
	
	/**
	 * 게시물을 삭제합니다.
	 * 
	 * @param brd_seq
	 * @return
	 */
	public int deleteBoard(int brd_seq) {
		return boardDao.deleteBoard(brd_seq);
	}
	
	/**
	 * 조회수를 올립니다.
	 * @param brd_seq
	 */	
	public void updateBoardCnt(int brd_seq) {
		boardDao.updateBoardCnt(brd_seq);
	}
	
	/**
	 * 게시글을 등록합니다.
	 * 
	 * @param board
	 * @return
	 */
	public int registBoard(BoardVO board) {
		return boardDao.registBoard(board);
	}
	
	/**
	 * 게시글을 수정합니다.
	 * 
	 * @param board
	 * @return
	 */
	public int modifyBoard(BoardVO board) {
		return boardDao.modifyBoard(board);
	}

	
}
