package com.icc.si.board.service;

import java.util.List;

import com.icc.si.board.vo.BoardVO;

public interface BoardService {

    /**
     * 게시판 목록을 보여줍니다.
     * 
     * @return
     */
	public List<BoardVO> getBoardList();
	
	/**
	 * 게시판 내용을 보여줍니다.
	 * 
	 * @param brd_seq
	 * @return
	 */
	public BoardVO getBoardDetail(int brd_seq);	

	/**
	 * 해당 게시물을 작성한 사용자를 가져옵니다. 
	 * 
	 * @param board
	 * @return
	 */
	public boolean boardWriterCheck(String brd_usr_id, int brd_seq);
	
	/**
	 * 게시물을 삭제합니다.
	 * 
	 * @param brd_seq
	 * @return
	 */
	public int deleteBoard(int brd_seq);
	
	/**
	 * 조회수를 올립니다.
	 * @param brd_seq
	 */	
	public void updateBoardCnt(int brd_seq);
	
	/**
	 * 게시글을 등록합니다.
	 * 
	 * @param board
	 * @return
	 */
	public int registBoard(BoardVO board);
	
	/**
	 * 게시글을 수정합니다.
	 * 
	 * @param board
	 * @return
	 */
	public int modifyBoard(BoardVO board);
}
