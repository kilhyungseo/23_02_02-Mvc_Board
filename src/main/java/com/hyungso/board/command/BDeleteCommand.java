package com.hyungso.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyungso.board.dao.BoardDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao();
		dao.deleteOk(bid);
		
		
	}

}
