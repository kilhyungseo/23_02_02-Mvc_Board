package com.hyungso.board.dto;

import java.sql.Timestamp;

public class BoardDto {
	int bid;
	String btitle;
	String bname;
	String bcontent;
	String bdate;
	int bhit;
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int bid, String btitle, String bname, String bcontent, String bdate, int bhit) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bname = bname;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
}
