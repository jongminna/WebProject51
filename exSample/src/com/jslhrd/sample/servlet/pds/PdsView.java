package com.jslhrd.sample.servlet.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.pds.PdsDAO;
import com.jslhrd.sample.model.pds.PdsVO;

/**
 * Servlet implementation class PdsView
 */
@WebServlet("/Pds/pds_view.do")
public class PdsView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage=request.getParameter("page");

		PdsDAO pDao = PdsDAO.getInstance();
		boolean found =false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();

		for(int i=0;i<cookies.length;i++){
			info=cookies[i];
			if(info.getName().equals("pdsCookie"+idx)){
				found=true;
				break;
			}
		}//for문의 끝
		String newValue=""+System.currentTimeMillis();
		 
		if(!found) {  //쿠키가 없으면(내용을 처음보는 경우)
			info=new Cookie("pdsCookie" + idx,newValue); //쿠키 생성
			response.addCookie(info); //생성된 쿠키를 넘김
			pDao.hitsPds(idx);				//조회수를 1증가
		}//if문의 종료
		
		PdsVO pVO = pDao.selectPdsNum(idx);

		request.setAttribute("pds", pVO);
		request.setAttribute("page", nowpage);
		RequestDispatcher d = request.getRequestDispatcher("/Pds/pds_view.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
