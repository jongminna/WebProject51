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
		<c:when test="${sw==1}">
		   <script language="javascript">
		   	alert("정상적으로 등록되었습니다.");  
		   	location.replace("pds_list.do?page=${page}");
   		   </script>
		</c:when>
		<c:otherwise>
		    <script language="javascript">
     			alert("DB 점속오류.\n\n잠시후 다시 등록하세요");
     			history.back();
   			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>