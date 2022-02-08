<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jslhrd.exmodel.model.boardreply.*" %>
<%
	BoardReplyDao dao = BoardReplyDao.getInstance();

	int idx = Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	int cnt = dao.countReply(idx);//답변글 수 카운트
	int row = 0;
	if(cnt==0){
		row=dao.boardDelete(idx, pass);
	}
	
	if(cnt !=0){//답변글이 있는 경우
%>
	<script>
		alert("답변글이 있어 삭제 불가\n 답변글을 먼저 삭제하세요");
		history.back();
	</script>
<%
	}else if(row==1){
%>	
	<script>
		alert("삭제성공");
		window.opener.location.replace("board_list.jsp");
		self.close();
	</script>
<%
	}else if(row==0){
%>	
	<script>
		alert("비번오류");
		history.back();
	</script>
<%
	}
%>