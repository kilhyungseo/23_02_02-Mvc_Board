package com.hyungso.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyungso.board.dao.BoardDao;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao() ;
				
		request.setAttribute("dtoList", dao.list());

	}

}
