package com.hyungso.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyungso.board.dao.BoardDao;
import com.hyungso.board.dto.BoardDto;

public class BContentViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		System.out.println(bid);
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.contentView(bid);
		
		request.setAttribute("dto", dto);
		

	}

}
