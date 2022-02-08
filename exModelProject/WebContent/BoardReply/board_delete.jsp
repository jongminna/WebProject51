<%@ page contentType="text/html; charset=UTF-8" %>
<%
	int idx = Integer.parseInt(request.getParameter("idx"));
%>
<html>
<head><title>방명록 삭제</title>
 <link rel="stylesheet" type="text/css" href="/stylesheet.css">
 <script>
 	function send(){
 		if(board_del.pass.value==""){
 			alert("No Pass");
 			board_del.pass.focus();
 			return;
 		}
 		board_del.action="board_delete_pro.jsp";
 		board_del.submit();
 	}
 </script>
 </head>
 <body>
 <form name="board_del" method="post" >
 <input type="hidden" name="idx" value="<%=idx%>">
   <table border="0" cellpadding="0" cellspacing="0" width="300" align="center">
     <tr>
       <td height="50">
       <img src="./img/bullet-05.gif"><b><font size="3" color="red">잠깐 !!</font></b></td></tr>
     <tr>
       <td valign="middle" height="30">
       <font size="2" face="돋움">게시물은 작성하신 분만 삭제할 수 있습니다.<br>
       글작성시 입력한 비밀번호를 입력해 주세요...</font></td></tr>
     <tr>
       <td valign="middle" height="40">
       <font size="2" face="돋움">
       비밀번호 <input type="password" name="pass" size="8"></font>
       <input type="button" value="삭제" onClick="send()">
       <input type="button" value="닫기" onClick="self.close()"></td></tr>
   </table>
   </form>
 </body>
 </html>
