package com.jslhrd.sample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.member.MemberDAO;


/**
 * Servlet implementation class MemberIDCheckServlet
 */
@WebServlet("/userinfo_idcheck.do")
public class MemberIDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIDCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/id_check.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.memberIDcheck(userid);
		request.setAttribute("row", row);
		request.setAttribute("userid", userid);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/id_check.jsp");
		dispatcher.forward(request, response);
	}

}
