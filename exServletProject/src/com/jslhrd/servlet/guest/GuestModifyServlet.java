package com.jslhrd.servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.model.guest.GuestDAO;
import com.jslhrd.model.guest.GuestVO;

/**
 * Servlet implementation class GuestModifyServlet
 */
@WebServlet("/Guest/guest_modify.do")
public class GuestModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestModifyServlet() {
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

		GuestVO vo = dao.guestSelect(idx);
		
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("guest_modify.jsp");
		rd.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
