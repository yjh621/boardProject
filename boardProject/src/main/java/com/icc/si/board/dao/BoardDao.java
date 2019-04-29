package com.icc.si.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icc.si.board.vo.BoardVO;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate session;
	
	/**
	 * 게시판 목록을 가져온다.
	 * 
	 * @author judy621
	 * @return
	 */
	public List<BoardVO> getBoardList() {
		return session.selectList("boardMapper.getBoardList");
	}
	/**
	 * 게시물 내용을 가져온다.
	 * 
	 * @param brd_seq
	 * @author judy621
	 * @return
	 */
	public BoardVO getBoardDetail(int brd_seq) {		
		return session.selectOne("boardMapper.getBoardDetail", brd_seq);
	}
	/**
	 * 해당 게시물을 작성한 사용자를 가져옵니다. 
	 * 
	 * @param board
	 * @return
	 */
	public boolean boardWriterCheck(BoardVO board) {
		return session.selectOne("boardMapper.boardWriterCheck", board);
	}
	
	/**
	 * 게시물을 삭제합니다.
	 * 
	 * @param brd_seq
	 * @return
	 */
	public int deleteBoard(int brd_seq) {
		return session.delete("boardMapper.deleteBoard" , brd_seq);
	}
	
	/**
	 * 조회수를 올립니다.
	 * @param brd_seq
	 */	
	public void updateBoardCnt(int brd_seq) {
		session.update("boardMapper.updateBoardCnt", brd_seq);
	}
	
	/**
	 * 게시글을 등록합니다.
	 * 
	 * @param board
	 * @return
	 */
	public int registBoard(BoardVO board) {
		return session.insert("boardMapper.registBoard", board);
	}
	
	/**
	 * 게시글을 수정합니다.
	 * 
	 * @param board
	 * @return
	 */
	public int modifyBoard(BoardVO board) {
		return session.update("boardMapper.modifyBoard", board);
	}
}
