package com.jslhrd.sample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.sample.model.member.MemberDAO;
import com.jslhrd.sample.model.member.MemberVO;


@WebServlet("/userinfo_modify.do")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo2 = dao.memberSelect(vo.getUserid());
		
		request.setAttribute("vo", vo2);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/userinfo_modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
