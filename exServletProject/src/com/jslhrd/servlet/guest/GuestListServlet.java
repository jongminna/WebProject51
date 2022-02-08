package com.jslhrd.servlet.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.model.guest.GuestDAO;
import com.jslhrd.model.guest.GuestVO;
import com.jslhrd.util.PageIndex;

/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/Guest/guest_list.do")
public class GuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO dao = GuestDAO.getInstance();
		
		String s_query="", query="", key="";
		int totcount=0;// 게시글 수
		List<GuestVO> list = null;
		if(request.getParameter("key") != null){
			query = request.getParameter("query");
			key = request.getParameter("key");
			s_query = query + " like '%" + key + "%'";
			totcount = dao.guestCount(s_query);
			//totcount = dao.guestCount(query, key);
			//list = dao.guestList(s_query);
			//list = dao.guestList(query, key);
		}else{
			totcount = dao.guestCount();
			//list = dao.guestList();
		}

		int nowpage=1;//현재페이지
		int maxlist=10;//페이지당 글수
		int totpage=1;//총페이지
		//페이지수 계산
		if(totcount % maxlist == 0){
			totpage = totcount / maxlist;
		}else{
			totpage = totcount / maxlist + 1;
		}
		if(totpage==0) totpage=1;
		
		if(request.getParameter("page") != null){
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if(nowpage > totpage)
			nowpage=totpage;
		
		int startpage = (nowpage-1)*maxlist+1; //시작페이지
		int endpage = nowpage * maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);

		if(key.equals("")){
			list = dao.guestList(startpage, endpage);
		}else{
			list = dao.guestList(s_query, startpage, endpage);			
		}
		//페이지 처리 클래스 호출
		String pageSkip="";
		if(key.equals("")){
			pageSkip=PageIndex.pageList(nowpage,totpage,"guest_list.do","");
		}else{
			pageSkip=PageIndex.pageListHan(nowpage,totpage,"guest_list.do",query,key);
		}

		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("query", query);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("guest_list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
