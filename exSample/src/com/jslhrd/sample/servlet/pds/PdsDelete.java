package com.jslhrd.sample.servlet.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.sample.model.pds.PdsDAO;

@WebServlet("/Pds/pds_delete.do")
public class PdsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PdsDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage = request.getParameter("page");
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", nowpage);
		
		RequestDispatcher d = request.getRequestDispatcher("/Pds/pds_delete.jsp");
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage = request.getParameter("page");
		String pass = request.getParameter("pass");
		
		PdsDAO DAO = PdsDAO.getInstance();
		
		String filename = DAO.searchFile(idx);
		int row = DAO.deletePds(idx, pass); //
		if(row==1) {//성공
			// 파일 삭제
			ServletContext context = getServletContext();
			String path = context.getRealPath("Pds/upload/");// 파일 저장 경로
			File file = new File(path+filename);
			if(file.exists()) {
				file.delete();
			}

			request.setAttribute("sw", 1);
			request.setAttribute("page", nowpage);
		}else {//실패
			request.setAttribute("sw", 0);
		}

		RequestDispatcher d = request.getRequestDispatcher("/Pds/pds_delete_pro.jsp");
		d.forward(request, response);
	}

}
