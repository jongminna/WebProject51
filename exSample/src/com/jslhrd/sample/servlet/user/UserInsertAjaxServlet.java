package com.jslhrd.sample.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.user.UserDAO;
import com.jslhrd.sample.model.user.UserVO;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/User/user_insert_ajax.do")
public class UserInsertAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_insert_ajax.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		UserVO vo = new UserVO();
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setTel(request.getParameter("tel"));
		vo.setEmail(request.getParameter("email1")+"@"+request.getParameter("email2"));
		
		UserDAO dao = UserDAO.getInstance();
		int row = dao.userInsert(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_insert_ajax_pro.jsp");
		dispatcher.forward(request, response);
	}

}
