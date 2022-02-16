package com.jslhrd.sample.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.board.BoardDAO;
import com.jslhrd.sample.model.board.BoardVO;


/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/Board/board_write.do")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
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
				request.getRequestDispatcher("/Board/board_write.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardVO vo = new BoardVO();
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setPass(request.getParameter("pass"));
		
		BoardDAO dao = new BoardDAO();
		int row = dao.boardWrite(vo);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("/Board/board_write_pro.jsp");
		dispater.forward(request, response);

		//response.sendRedirect("board_list");
	}

}
