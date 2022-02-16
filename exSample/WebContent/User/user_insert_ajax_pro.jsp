<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:if test="${row==1}">
	<script>
		alert("환영합니다 \n 회원가입되었읍니다");
		location.href="user_login";
	</script>
</c:if>

<c:if test="${row==0}">
	<script>
		alert("오류입니다.\n 다시입력");
		history.back();
	</script>
</c:if>