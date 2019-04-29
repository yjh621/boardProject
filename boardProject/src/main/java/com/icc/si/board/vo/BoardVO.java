package com.icc.si.board.vo;

//import java.io.Serializable;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class BoardVO{
	
	private int brd_seq;
	private String brd_title;
	private String brd_contents;
	private String brd_usr_id;
	private String brd_usr_nm;
	private String brd_reg_date;
	private String brd_mdf_date;
	private int brd_view_cnt;
	
	public BoardVO() {}

	public BoardVO(int brd_seq, String brd_title, String brd_contents, String brd_usr_id, String brd_usr_nm,
			String brd_reg_date, String brd_mdf_date, int brd_view_cnt) {
		
		this.brd_seq = brd_seq;
		this.brd_title = brd_title;
		this.brd_contents = brd_contents;
		this.brd_usr_id = brd_usr_id;
		this.brd_usr_nm = brd_usr_nm;
		this.brd_reg_date = brd_reg_date;
        this.brd_mdf_date = brd_mdf_date;
        this.brd_view_cnt = brd_view_cnt;
	}
	
	public int getBrd_seq() {
		return brd_seq;
	}

	public void setBrd_seq(int brd_seq) {
		this.brd_seq = brd_seq;
	}


	public String getBrd_title() {
		return brd_title;
	}


	public void setBrd_title(String brd_title) {
		this.brd_title = brd_title;
	}


	public String getBrd_contents() {
		return brd_contents;
	}


	public void setBrd_contents(String brd_contents) {
		this.brd_contents = brd_contents;
	}


	public String getbrd_usr_id() {
		return brd_usr_id;
	}

	public void setbrd_usr_id(String brd_usr_id) {
		this.brd_usr_id = brd_usr_id;
	}


	public String getBrd_usr_nm() {
		return brd_usr_nm;
	}


	public void setBrd_usr_nm(String brd_usr_nm) {
		this.brd_usr_nm = brd_usr_nm;
	}


	public String getBrd_reg_date() {
		return brd_reg_date;
	}


	public void setBrd_reg_date(String brd_reg_date) {
		this.brd_reg_date = brd_reg_date;
	}


	public String getBrd_mdf_date() {
		return brd_mdf_date;
	}


	public void setBrd_mdf_date(String brd_mdf_date) {
		this.brd_mdf_date = brd_mdf_date;
	}


	public int getBrd_view_cnt() {
		return brd_view_cnt;
	}


	public void setBrd_view_cnt(int brd_view_cnt) {
		this.brd_view_cnt = brd_view_cnt;
	}


	@Override
	public String toString() {
		return "BoardVO [brd_seq=" + brd_seq + ", brd_title=" + brd_title + ", brd_contents=" + brd_contents
				+ ", brd_usr_id=" + brd_usr_id + ", brd_usr_nm=" + brd_usr_nm + ", brd_reg_date=" + brd_reg_date
				+ ", brd_mdf_date=" + brd_mdf_date + ", brd_view_cnt=" + brd_view_cnt + "]";
	}
 
}
