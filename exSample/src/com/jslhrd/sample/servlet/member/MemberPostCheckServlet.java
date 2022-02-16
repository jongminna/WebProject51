package com.jslhrd.sample.servlet.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.member.MemberDAO;
import com.jslhrd.sample.model.member.ZipVO;


/**
 * Servlet implementation class MemberPostCheckServlet
 */
@WebServlet("/userinfo_postcheck.do")
public class MemberPostCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberPostCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/post_check.jsp");
		dispatcher.forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String addr=null;
		if(request.getParameter("addr") != null){
			addr = request.getParameter("addr");
		}
		
		MemberDAO dao = MemberDAO.getInstance();
		List<ZipVO> list = dao.zipList(addr);
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/post_check.jsp");
		dispatcher.forward(request, response);	
		
	}

}
