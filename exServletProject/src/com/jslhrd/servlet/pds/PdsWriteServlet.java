package com.jslhrd.servlet.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.model.pds.PdsDAO;
import com.jslhrd.model.pds.PdsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class PdsWriteServlet
 */
@WebServlet("/Pds/pds_write.do")
public class PdsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("pds_write.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo = new PdsVO();
		
		// 실제 서버경로 지정
		ServletContext context = getServletContext();
		String path = context.getRealPath("Pds/upload");
		String encType="UTF-8";
		int sizeLimit = 2*1024*1024;//파일 크기 2M
		MultipartRequest multi = new MultipartRequest(request, path,sizeLimit,
				encType, new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy() 파일 중복처리(a.bmp - a1.bmp)
		
		vo.setName(multi.getParameter("name"));
		vo.setPass(multi.getParameter("pass"));
		vo.setEmail(multi.getParameter("email"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContents(multi.getParameter("contents"));
		vo.setFilename(multi.getFilesystemName("filename"));
		
		int row = dao.pdsWrite(vo);
		
		response.sendRedirect("pds_list.do");
	}

}
