package com.jslhrd.sample.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.sample.model.user.UserDAO;
import com.jslhrd.sample.model.user.UserVO;
import com.jslhrd.sample.util.UserSHA256;

/**
 * Servlet implementation class UsersLoginServlet
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
		String url="/User/user_login.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			url="/User/userlogin_ok.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid= request.getParameter("userid");
		//비번이 암호화 된경우
		String passwd = UserSHA256.getSHA256(request.getParameter("passwd"));
		//암호화하지 않은 경우
		//String passwd = request.getParameter("passwd");

		UserDAO dao = UserDAO.getInstance();//DB 연결
		int row = dao.userLogin(userid, passwd);
		request.setAttribute("row", row);
		
		if (row == 1) {
			UserVO vo = dao.userSelect(userid);
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);
			session.setMaxInactiveInterval(1800);
			request.setAttribute("message", "로그인 성공했습니다.");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/userlogin_ok.jsp");
		dispatcher.forward(request, response);
	}

}
