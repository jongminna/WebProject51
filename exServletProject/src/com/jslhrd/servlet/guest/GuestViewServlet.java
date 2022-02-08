package com.jslhrd.servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.model.guest.GuestDAO;
import com.jslhrd.model.guest.GuestVO;

/**
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/Guest/guest_view.do")
public class GuestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO dao = GuestDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		//쿠키검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x=0; x<cookies.length; x++){
			info = cookies[x];
			if(info.getName().equals("guestCookie"+idx)){
				bool = true;
				break;
			}
		}
		// 쿠키값 생성
		String newValue=""+System.currentTimeMillis();
		if(!bool){//쿠키가 존재하지 않은 경우
			info = new Cookie("guestCookie"+idx, newValue);
			info.setMaxAge(24*60*60);//24시간
			response.addCookie(info);
			dao.guestHits(idx);//조회수 증가 메소드
		}
		
		GuestVO vo = dao.guestSelect(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("guest_view.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
