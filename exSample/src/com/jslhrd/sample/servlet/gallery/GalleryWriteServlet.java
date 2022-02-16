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
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/Gallery/gallery_write.do")
public class GalleryWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		if(request.getParameter("page")!=null && 
				!request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		request.setAttribute("page", page);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Gallery/gallery_write.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		
		GalleryVO vo = new GalleryVO();
		//vo.setName(request.getParameter("name"));
		//vo.setEmail(request.getParameter("pass"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		
		GalleryDAO dao = GalleryDAO.getInstance();
		int row = dao.galleryWrite(vo);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
/*		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Gallery/gallery_list.jsp");
		dispater.forward(request, response);
*/
		response.sendRedirect("gallery_list.do");
	}

}
