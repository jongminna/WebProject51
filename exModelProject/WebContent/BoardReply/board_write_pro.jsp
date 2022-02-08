<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jslhrd.exmodel.model.boardreply.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	BoardReplyDao dao = BoardReplyDao.getInstance();
	BoardReplyVO vo = new BoardReplyVO();
	vo.setParent(Integer.parseInt(request.getParameter("parent")));
	vo.setRealparent(Integer.parseInt(request.getParameter("realparent")));
	vo.setDepth(Integer.parseInt(request.getParameter("depth")));
	vo.setIndent(Integer.parseInt(request.getParameter("indent")));
	
	vo.setName(request.getParameter("name"));
	vo.setEmail(request.getParameter("email"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	vo.setPass(request.getParameter("pass"));

	int row = dao.boardWrite(vo);
	
	response.sendRedirect("board_list.jsp");

%>
