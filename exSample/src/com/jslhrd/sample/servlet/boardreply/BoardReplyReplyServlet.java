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
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/boardreply_reply.do")
public class BoardReplyReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
				
		BoardReplyDAO dao = BoardReplyDAO.getInstance();
		
		BoardReplyVO board = dao.boardSelect(idx);
		
		request.setAttribute("page", page);
		request.setAttribute("board", board);	
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("BoardReply/board_reply.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
