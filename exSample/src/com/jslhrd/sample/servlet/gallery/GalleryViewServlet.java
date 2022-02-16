package com.jslhrd.sample.servlet.gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.gallery.GalleryDAO;
import com.jslhrd.sample.model.gallery.GalleryVO;

/**
 * Servlet implementation class GalleryViewServlet
 */
@WebServlet("/Gallery/gallery_view.do")
public class GalleryViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = 1;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
		}

		GalleryDAO dao = GalleryDAO.getInstance();
		
		GalleryVO board = dao.gallerySelect(idx);
		//String content = board.getContents();
		//board.setContents(content.replace("\n","<br>"));
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Gallery/gallery_view.jsp");
		dispater.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
