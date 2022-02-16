package com.jslhrd.sample.servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.guest.GuestDAO;
import com.jslhrd.sample.model.guest.GuestVO;


/**
 * Servlet implementation class GuestWriteServlet
 */
@WebServlet("/Guest/guest_write.do")
public class GuestWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("page", page);
		RequestDispatcher rd = 
				request.getRequestDispatcher("guest_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = new GuestVO();

		int page = Integer.parseInt(request.getParameter("page"));
		
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));

		int row = dao.guestWrite(vo);
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		response.sendRedirect("guest_list.do?page="+page);
/*
		RequestDispatcher rd = 
				request.getRequestDispatcher("guest_write_pro.jsp");
		rd.forward(request, response);
*/		
	}

}
