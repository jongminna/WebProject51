<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${row==1 }">	
	<script>
		alert("감사합니다. \n수정처리되었습니다");
		location.href="guest_list?page=${page}";
	</script>
</c:if>	
<c:if test="${row==0}">	
	<script>
	alert("죄송합니다. \n잠시 후 다시 수정해 주세요");
		history.back();
	</script>
</c:if>
    

    