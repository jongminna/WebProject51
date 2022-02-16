package com.jslhrd.sample.servlet.boardreply;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.boardreply.BoardReplyDAO;
import com.jslhrd.sample.model.boardreply.BoardReplyVO;


/**
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/boardreply_modify.do")
public class BoardReplyModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		BoardReplyDAO dao = BoardReplyDAO.getInstance();
		BoardReplyVO board = dao.boardSelect(idx);
		
		request.setAttribute("page", page);
		request.setAttribute("board", board);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("BoardReply/board_modify.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardReplyVO board = new BoardReplyVO();
		board.setIdx(Integer.parseInt(request.getParameter("idx")));
		board.setEmail(request.getParameter("email"));
		board.setSubject(request.getParameter("subject"));
		board.setContents(request.getParameter("contents"));
		board.setPass(request.getParameter("pass"));
		
		BoardReplyDAO dao = BoardReplyDAO.getInstance();
		int row = dao.boardUpdate(board);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("BoardReply/board_modify_pro.jsp");
		dispater.forward(request, response);
		//response.sendRedirect("board_list.do?page="+page);
	}

}
