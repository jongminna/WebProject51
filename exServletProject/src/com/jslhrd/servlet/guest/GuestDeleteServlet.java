package com.jslhrd.servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.model.guest.GuestDAO;

/**
 * Servlet implementation class GuestDeleteServlet
 */
@WebServlet("/Guest/guest_delete.do")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO dao = GuestDAO.getInstance();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
/*		//비밀번호 입력창 이용시
		//RequestDispatcher rd = request.getRequestDispatcher("guest_delete.jsp");
		//rd.forward(request, response);
*/
		// 비번 미이용시
		int row = dao.guestDelete(idx);
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("guest_delete_pro.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO dao = GuestDAO.getInstance();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		
		int row = dao.guestDelete(idx, pass);
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("guest_delete_pro.jsp");
		rd.forward(request, response);
	
	}

}
