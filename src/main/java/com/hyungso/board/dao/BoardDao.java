package com.hyungso.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.hyungso.board.dto.BoardDto;

public class BoardDao {

	String driverName = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/webdb";
	String user = "root";
	String pass = "1234";
	
	public void write(String btitle, String bname, String bcontent) { //글쓰기
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO mvc_board(btitle, bname, bcontent) VALUES (?,?,?)";
		int resultFlag = 0;
		
		try {
	         Class.forName(driverName);//드라이버 불러오기
	         conn = DriverManager.getConnection(url, user, pass);//DB 연동
	         
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, btitle);
				pstmt.setString(2, bname);
				pstmt.setString(3, bcontent);
				

				resultFlag = pstmt.executeUpdate(); //성공하면 1로 값이 변경
				
				if(resultFlag==1) {
					JOptionPane.showMessageDialog(null, "기록완료");
					//System.out.println("기록성공");
				}else {
					System.out.println("기록실패");
				}
			
	      } catch(Exception e) {
	         e.printStackTrace();
	      }	finally {
	    	  try {
	    		  if(pstmt != null) {
	    			  pstmt.close();
	    		  }
	    		  if(conn != null) {
	    			  conn.close();
	    		  }
	    	  }catch(Exception e2) {
	    		  e2.printStackTrace();
	    	  }
	      }
	}
	public ArrayList<BoardDto> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM mvc_board ORDER BY bid DESC"; //내림차순으로 select
		ArrayList<BoardDto> dtoList  = new ArrayList<BoardDto>(); //dto여러개를 담을수 있는 비어있는 리스트 선언
		
		try {
	         Class.forName(driverName);//드라이버 불러오기
	         conn = DriverManager.getConnection(url, user, pass);//DB 연동
	         
				pstmt = conn.prepareStatement(sql);

		 rs = pstmt.executeQuery(); //ResultSet 객체인 rs로 받기
		 
		 while(rs.next()) {
			 int bid = rs.getInt("bid");
			 String btitle = rs.getString("btitle");
			 String bname = rs.getString("bname");
			 String bcontent = rs.getString("bcontent");
			 String bdate = rs.getString("bdate");
			 int bhit = rs.getInt("bhit");
			 
			 BoardDto dto = new BoardDto(bid, btitle, bname, bcontent, bdate, bhit);
//			 dto.setBid(bid);
//			 dto.setBtitle(btitle);
//			 dto.setBname(bname);
//			 dto.setBcontent(bcontent);
//			 dto.setBdate(bdate);
//			 dto.setBhit(bhit);
			 
			 dtoList.add(dto);
		 }
			
	      } catch(Exception e) {
	         e.printStackTrace();
	      }	finally {
	    	  try {
	    		  if(rs != null) {
	    			  rs.close();
	    		  }
	    		  if(pstmt != null) {
	    			  pstmt.close();
	    		  }
	    		  if(conn != null) {
	    			  conn.close();
	    		  }
	    	  }catch(Exception e2) {
	    		  e2.printStackTrace();
	    	  }
	      }
		return dtoList;
	}
}
