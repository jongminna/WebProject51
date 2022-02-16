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
@WebServlet("/boardreply_write.do")
public class BoardReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page", page);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("BoardReply/board_write.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardReplyVO vo = new BoardReplyVO();
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setPass(request.getParameter("pass"));
		vo.setParent(Integer.parseInt(request.getParameter("parent")));
		vo.setRealparent(Integer.parseInt(request.getParameter("realparent")));
		vo.setDepth(Integer.parseInt(request.getParameter("depth")));
		vo.setIndent(Integer.parseInt(request.getParameter("indent")));
		
		BoardReplyDAO dao = BoardReplyDAO.getInstance();
		int row = dao.boardWrite(vo);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("BoardReply/board_write_pro.jsp");
		dispater.forward(request, response);

		//response.sendRedirect("board_list");
	}

}
