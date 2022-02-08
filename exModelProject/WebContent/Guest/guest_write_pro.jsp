<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.jslhrd.exmodel.model.guest.*" %>
<%
	request.setCharacterEncoding("utf-8");
	GuestDAO dao = GuestDAO.getInstance();
	GuestVO vo = new GuestVO();

	vo.setName(request.getParameter("name"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));

	int row = dao.guestWrite(vo);
	if(row==1){
		response.sendRedirect("guest_list.jsp");
	}else{
%>
	<script>
		history.back();
	</script>

<%
	}
%>
    