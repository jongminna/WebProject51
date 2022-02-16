<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<c:if test="${row==0}">
	<script>
		alert("비밀번호가 틀림");
		history.back();
	</script>
</c:if>

<c:if test="${row != 0}">
	<script>
		alert("삭제됨");
		opener.location.replace("gallery_list.do?page=${page}");
		self.close();
	</script>
</c:if>
 
