package com.jslhrd.sample.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.user.UserDAO;

/**
 * Servlet implementation class UsersLoginServlet
 */
@WebServlet("/User/user_modify.do")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="User/user_login.jsp";
		
/*		
 		세션값을 이용해서 JSP에서 처리가 가능하므로 생략가능
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("user");
		request.setAttribute("user", user);
*/		
/*		
		// 세션이 없을 경우 사용
		UserDAO dao = UserDAO.getInstance();//DB 연결
		vo = dao.userSelect(vo.getUserid());
		request.setAttribute("user", user);
*/		
		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_modify.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();//DB 연결

		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_modify_pro.jsp");
		dispatcher.forward(request, response);
	}

}
