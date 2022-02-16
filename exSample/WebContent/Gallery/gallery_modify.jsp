<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/Include/topmenu.jsp" %>
 <html>
   <head><title>포토 겔러리 수정</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">
<!-- include libraries(jQuery, bootstrap) --> 
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> 
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js--> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet"> 
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script> 

<script type="text/javascript">
	function check(){
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

   <!-- 다음에 추가할 부분 "-->
   <%@ include file="/Include/login_form.jsp" %>

   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="/Gallery/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>포토 겔러리</b></font>
     <font size="2"> - 수정하기</font><p>
     <img src="/Gallery/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="/Gallery/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     
     <form name="gallery" method="post" action="gallery_modify.do">
		<input type="hidden" name="idx" value="${board.idx}">
		<input type="hidden" name="page" value="${page}">
      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="/Gallery/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" name="name" value="${board.name}"></td>
       </tr>
       <tr>
         <td align="right"><img src="/Gallery/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject" value="${board.subject}"></td>
       </tr>
       <tr>
         <td align="right"><img src="/Gallery/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea  id="summernote" wrap="physical" rows="10" name="contents" cols="60" >${board.contents}</textarea></td>
       </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
          	<a href="javascript:check()"><img src="/Gallery/img/edit2.gif" border=0></a>&nbsp;
          	<a href="javascript:history.back()"><img src="/Gallery/img/cancle.gif" border=0></a>
          </td></tr>
      </table>
      </form>
    </td></tr>
  </table>
  </body>
  </html>
   