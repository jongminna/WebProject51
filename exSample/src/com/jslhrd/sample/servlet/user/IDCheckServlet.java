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
 * Servlet implementation class IDCheckServlet
 */
@WebServlet("/user_idcheck.do")
public class IDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //id 중복체크 jsp 파일
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_idcheck.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		//id 중복 검사 메소드 호출
		UserDAO dao = UserDAO.getInstance();
		int row = dao.idCheck(userid);
		
		request.setAttribute("row", row);
		request.setAttribute("userid", userid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_idcheck.jsp");
		dispatcher.forward(request, response);
	}

}
