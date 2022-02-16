package com.jslhrd.sample.servlet.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.notice.NoticeDAO;
import com.jslhrd.sample.model.notice.NoticeVO;
import com.jslhrd.sample.util.PageIndex;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/Notice/notice_list.do")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO dao = NoticeDAO.getInstance();
		String s_query="", addtag="", query="",key="";
		
		int totcount = 0; // 게시글 총수
		//post 방식(검색일 경우)
		if(request.getParameter("key") != null) {
			//key = URLDecoder.decode(request.getParameter("key"));
			key = request.getParameter("key");
			query = request.getParameter("search");
			s_query = query + " like '%" + key + "%'";
			addtag = "&search="+query+"&key="+ key;
			totcount = dao.noticeCount(s_query);
		}else {
			totcount = dao.noticeCount();	
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
		
		List<NoticeVO> list = null;
		if(key.equals("")) {
			list = dao.noticeList(pagestart,endpage);
		}else {
			list = dao.noticeList(s_query, pagestart,endpage);
		}
		String pageSkip="";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "notice_list.do", addtag);
		}else {	
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "notice_list.do", query, key);
		}
		request.setAttribute("totcount", totcount);
		request.setAttribute("list", list);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", query);
		request.setAttribute("key", key);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/Notice/notice_list.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
