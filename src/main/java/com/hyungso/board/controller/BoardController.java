package com.hyungso.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyungso.board.command.BCommand;
import com.hyungso.board.command.BContentViewCommand;
import com.hyungso.board.command.BDeleteCommand;
import com.hyungso.board.command.BListCommand;
import com.hyungso.board.command.BModifyOkCommand;
import com.hyungso.board.command.BWriteCommand;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri =request.getRequestURI();
		String conPath = request.getContextPath(); // 컨택스트 패스만 분리하여 저장
		String command =uri.substring(conPath.length());
		
		System.out.println(command);
		
		BCommand bCommand=null;
		String viewPage = "/error.jsp"; // view의 이름
		
		if(command.equals("/writeForm.do")) {
			viewPage = "/write_form.jsp";
		}else if(command.equals("/write.do")) {
			bCommand = new BWriteCommand();
			bCommand.execute(request, response);
			
			viewPage = "/list.do";
		}else if(command.equals("/list.do")) {
			bCommand = new BListCommand();
			bCommand.execute(request, response);
			
			viewPage = "/board_list.jsp";
		}else if(command.equals("/contentView.do")) {
			bCommand = new BContentViewCommand();
			bCommand.execute(request, response);
			
			viewPage = "/content_view.jsp";
		}else if(command.equals("/contentModify.do")) {
			bCommand = new BContentViewCommand();
			bCommand.execute(request, response);
			
			viewPage = "/content_Modify.jsp";
		}else if(command.equals("/modify.do")) {
			bCommand = new BModifyOkCommand();
			bCommand.execute(request, response);
			
			viewPage = "/list.do";
		}else if(command.equals("/delete.do")) {
			bCommand = new BDeleteCommand();
			bCommand.execute(request, response);
			
			viewPage = "/list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);	
		
		
		
	}
}
