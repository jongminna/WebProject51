package com.jslhrd.sample.servlet.pds;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.pds.PdsDAO;
import com.jslhrd.sample.model.pds.PdsVO;
import com.jslhrd.sample.util.PageIndex;

@WebServlet("/Pds/pds_list.do")
public class PdsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PdsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PdsDAO pDao = PdsDAO.getInstance();
		
		String url = "pds_list.do";
		String s_query = "", addtag="", query = "", key = "";
		int totcount = 0;  
		//검색 조건이 포함될경우
		if(request.getParameter("key") != null && !request.getParameter("key").equals("")) {
			query = request.getParameter("search");
			key = request.getParameter("key");
			//s_query =	" where " + query + " like '%" + key + "%'";
			s_query = query + " like '%" + key + "%'";
			addtag = "&search=" + query + "&key=" + key;
			totcount = pDao.countPds(s_query);   // 총 글수 추출
		}else {
			totcount = pDao.countPds();   // 총 글수 추출
		}

		int nowpage = 1;  
		int maxlist = 10;                       // 한페이지에 출력할 글수 설정
		int totpage = 1;                        // 총 페이지수 초기화
		
		if(totcount % maxlist == 0)             // 총 글수로 총 페이지 계산
			totpage = totcount / maxlist;
		else
			totpage = totcount / maxlist + 1;
		if(totpage == 0) totpage = 1;            // 총 페이지수가 0이면 1로 초기화
		if(request.getParameter("page") != null && !request.getParameter("page").equals(""))  // 현재페이지를 받음
			nowpage = Integer.parseInt(request.getParameter("page"));
		if(nowpage > totpage)  // 현재페이지가 총페이지보다 클때 마지막 페이지로 변환
			nowpage = totpage;
		
		int pagestart = (nowpage - 1) * maxlist + 1; // 현재페이지 시작번호 구하기
		int endpage = nowpage * maxlist; // 30 이 될 겁니다. 
		int listcount = totcount - ((nowpage -1) * maxlist);

		List<PdsVO> pdsList = null;
		if(key.equals("")) {
			pdsList = pDao.listPds(pagestart, endpage);
		}else {
			pdsList = pDao.listPds(s_query, pagestart, endpage);
		}
		
		String pageSkip="";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "pds_list.do", addtag);
		}else {	
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "pds_list.do", query, key);
		}

		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", pdsList);
		request.setAttribute("query", query);
		request.setAttribute("key", key);
		request.setAttribute("pageSkip", pageSkip);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/Pds/pds_list.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
