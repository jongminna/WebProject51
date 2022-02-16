package com.jslhrd.sample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.member.MemberDAO;
import com.jslhrd.sample.model.member.MemberVO;


/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/userinfo_insert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/userinfo_insert.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String zip = request.getParameter("zip");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String[] farr = request.getParameterValues("fa");
		String job = request.getParameter("job");
		String intro = request.getParameter("intro");
		
		String  favorite=null;
		if(farr==null) {
			favorite=null;
		}else{
			favorite= farr[0];
			if(farr.length >1) {
				for(int i=1;i<farr.length;i++) {
					favorite =favorite + "," + farr[i];
				}
			}
		}
		
		MemberVO mem = new MemberVO();
		mem.setName(name);
		mem.setUserid(userid);
		mem.setPasswd(passwd);
		mem.setZipcode(zip);
		mem.setAddr1(addr1);
		mem.setAddr2(addr2);
		mem.setTel(tel);
		mem.setEmail(email);
		mem.setFavorite(favorite);
		mem.setJob(job);
		mem.setIntro(intro);
		
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.memberWrite(mem);
		
		response.sendRedirect("userinfo_list");
	/*	
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/userinfo_list.jsp");
		dispatcher.forward(request, response);
	*/
	}

}
