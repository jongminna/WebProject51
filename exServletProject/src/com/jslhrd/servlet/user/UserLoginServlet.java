package com.jslhrd.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.model.user.UserDAO;
import com.jslhrd.model.user.UserVO;
import com.jslhrd.util.UserSHA256;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/User/user_login.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="user_login.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			url="userlogin_ok.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		
		String userid = request.getParameter("userid");
		String passwd = UserSHA256.getSHA256(request.getParameter("passwd"));
		
		int row = dao.userLogin(userid, passwd);
		//row =1 -> 로그인 성공
		request.setAttribute("row", row);
		UserVO vo=null;
		HttpSession session=null;
		if(row==1) {
			vo = dao.userSelect(userid);
			session = request.getSession();//세션객체 생성
			session.setAttribute("user", vo);
			session.setMaxInactiveInterval(1800);//30분
		}
		
		 RequestDispatcher rd = request.getRequestDispatcher("userlogin_ok.jsp");
		 rd.forward(request, response);
		
	}

}
