<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int row=(int)request.getAttribute("row");
	if(row==1){
%>    
	<script>
		alert("삭제성공");
		location.href="guest_list.do?page=${page}";
	</script>
<%
	}else{
%>
	<script>
		alert("삭제오류(비번오류)");
		location.history.back();
	</script>

<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>