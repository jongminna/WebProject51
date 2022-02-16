<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Include/topmenu.jsp" %>

<!-- include libraries(jQuery, bootstrap) --> 
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> 
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js--> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet"> 
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script> 
    
<!DOCTYPE html>
<html>
   <head><title>포토 겔러리 작성</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">   
 <script>
	function send(){
		alert("등록");
		gallery.submit();
	}
	
	$(document).ready(function() {
        $('#summernote').summernote(); 
   });

</script>

</head>
 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">
   <!-- 다음에 추가할 부분 -->
   <%@ include file="/Include/login_form.jsp" %>
   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="/Gallery/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>포토겔러리</b></font>
     <font size="2"> - 포토겔러리 등록</font><p>
     <img src="/Gallery/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="/Gallery/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form method="post" action="gallery_write.do" name="gallery">
     <input type="hidden" name="page" value="${page}">
      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="/Gallery/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%"><input type="text" size="20" name="name"></td>
       </tr>
       <tr>
         <td width="5%" align="right"><img src="/Gallery/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">비밀번호</font></td>
         <td width="80%"><input type="text" size="20" name="name"> 수정삭제시 필요</td>
       </tr>
       <tr>
         <td align="right"><img src="/Gallery/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject"></td>
       </tr>
       <tr>
         <td align="right"><img src="/Gallery/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea id="summernote"  wrap="physical" rows="10" name="contents" cols="60"></textarea></td>
       </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
          <a href="javascript:send()">◀등 록▶</a>&nbsp;&nbsp;&nbsp;
          <a href="">◀취 소▶</a>
          </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
  </table>
  </body>
  </html>
