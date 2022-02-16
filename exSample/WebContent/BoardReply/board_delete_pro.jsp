<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${row==1}">
			<script>
				alert("삭제되었습니다");
				window.opener.location.replace("boardreply_list.do?page=${page}");
				self.close();
			</script>
		</c:when>
		<c:when test="${row==-1}">
			<script>
				alert("답변글이 있어 삭제할 수 없습니다");
				window.opener.location.replace("boardreply_list.do");
				self.close();				
				</script>
		</c:when>		
		<c:when test="${row==0}">
			<script>
				alert("비밀번호 오류 입니다");
				history.back();
				</script>
		</c:when>
	</c:choose>
</body>
</html>