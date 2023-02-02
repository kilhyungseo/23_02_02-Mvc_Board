package com.hyungso.board.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyungso.board.dao.BoardDao;



public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String btitle = request.getParameter("btitle");
		String bname = request.getParameter("bname");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao();
		dao.write(btitle, bname, bcontent);
		
		

	}

}
