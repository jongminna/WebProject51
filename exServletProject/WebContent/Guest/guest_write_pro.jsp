<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int row = (int)request.getAttribute("row");
	if(row==0){
%>
	<script>
		alert("실패");
		history.back();
	</script>

<%
	}else{
%>
	<script>
		alert("성공");
		location.href="guest_list.do?page=${page}";
	</script>
        
<%
	}
%>    