package com.jslhrd.sample.servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.board.BoardDAO;
import com.jslhrd.sample.model.board.BoardVO;
import com.jslhrd.sample.util.PageIndex;

@WebServlet("/Board/board_list.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardDAO dao = BoardDAO.getInstance();
		BoardDAO dao = new BoardDAO();
		String s_query="", addtag="", query="",key="";
		
		int totcount = 0; // 게시글 총수
		//post 방식(검색일 경우)
		if(request.getParameter("key") != null) {
			//key = URLDecoder.decode(request.getParameter("key"));
			key = request.getParameter("key");
			query = request.getParameter("search");
			s_query = query + " like '%" + key + "%'";
			addtag = "&search="+query+"&key="+ key;
			totcount = dao.boardCount(s_query);
		}else {
			totcount = dao.boardCount();	
		}
		
		int nowpage= 1;   // 현재 페이지
		int maxlist= 10;  // 페이지당 글 수
		int totpage = 1;  //총 페이지수		
		
		if(totcount%maxlist == 0 ) {
			totpage=totcount/maxlist;
		}else{
			totpage=totcount/maxlist+1;
		}
		
		if(request.getParameter("page") != null) {
			nowpage=Integer.parseInt(request.getParameter("page"));
		}
		
		int pagestart=(nowpage-1)*maxlist+1;
		int endpage=nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		List<BoardVO> list = null;
		if(key.equals("")) {
			list = dao.boardList(pagestart,endpage);
		}else {
			list = dao.boardList(s_query, pagestart,endpage);
		}
		String pageSkip="";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "board_list.do", addtag);
		}else {	
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "board_list.do", query, key);
		}
		request.setAttribute("totcount", totcount);
		request.setAttribute("list", list);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", query);
		request.setAttribute("key", key);
			
		RequestDispatcher dispater = 
				request.getRequestDispatcher("/Board/board_list.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
