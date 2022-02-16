<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${row==1}">
		   <script language="javascript">
     		//window.opener.location.replace("list.do?page=${page}");
     		//self.close();
     		location.replace("gallery_list.do?page=${page}");
   		   </script>
		</c:when>
		<c:otherwise>
		    <script language="javascript">
     			alert("비밀번호가 맞지 않습니다.\n\n글 작성시의 비밀번호를 입력해 주세요.");
     			history.back();
   			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>