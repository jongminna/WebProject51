package com.jslhrd.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.model.user.UserDAO;
import com.jslhrd.model.user.UserVO;
import com.jslhrd.util.UserSHA256;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/User/user_insert.do")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("user_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		request.setCharacterEncoding("utf-8");
		
		UserVO vo = new UserVO();
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPasswd(UserSHA256.getSHA256(request.getParameter("passwd")));
		vo.setTel(request.getParameter("tel"));
		vo.setEmail(request.getParameter("email1")+"@"+request.getParameter("email2"));
		
		int row = dao.userInsert(vo);

/*		
		RequestDispatcher rd = request.getRequestDispatcher("user_login.jsp");
		rd.forward(request, response);
*/		
		response.sendRedirect("/User/user_login.do");
	}

}
