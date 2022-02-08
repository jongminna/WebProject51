<%@ page contentType="text/html; charset=UTF-8" %>

<html>
   <head><title>방명록 작성</title>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
<script>
	function send(){
		if(guest.name.value==""){
			alert("이름을 입력하세요");
			guest.name.focus();
			return;
		}
		if(guest.pass.value==""){
			alert("비밀번호을 입력하세요");
			guest.pass.focus();
			return;
		}
		if(guest.subject.value==""){
			alert("제목을 입력하세요");
			guest.subject.focus();
			return;
		}
		if(guest.contents.value==""){
			alert("내용을 입력하세요");
			guest.contents.focus();
			return;
		}
		guest.submit();
	}
	
	function reclear(){
		guest.reset();
		guest.name.focus();
	}
</script>

</head>
 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">
   <!-- 다음에 추가할 부분 -->
   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="/Guest/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>방명록</b></font>
     <font size="2"> - 글쓰기</font><p>
     <img src="/Guest/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="/Guest/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form method="post" action="guest_write_pro.jsp" name="guest">
      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="/Guest/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%"><input type="text" size="20" name="name"></td>
       </tr>
       <tr>
         <td width="5%" align="right"><img src="/Guest/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">비밀번호</font></td>
         <td width="80%"><input type="password" size="20" name="pass"> 수정삭제시 필요</td>
       </tr>
       <tr>
         <td align="right"><img src="/Guest/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject"></td>
       </tr>
       <tr>
         <td align="right"><img src="/Guest/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60"></textarea></td>
       </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
            <a href="#" onClick="send()">◀등 록▶</a>&nbsp;&nbsp;&nbsp;
            <a href="#" onClick="reclear()">◀다시쓰기▶</a>&nbsp;&nbsp;&nbsp;
            <a href="javascript:history.back()">◀취 소▶</a>
          </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
  </table>
  </body>
  </html>
