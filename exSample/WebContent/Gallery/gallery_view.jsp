<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/Include/topmenu.jsp" %>
 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>포토 겔러리 내용 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
   <script>
	function gallery_del(){
		url="gallery_delete.do?page=${page}&idx=${board.idx}";
		window.open(url, "gallery_delete","width=300, height=200");		
	}
</script>
   
 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		 <!--  다음에 추가할 부분 -->
   <%@ include file="/Include/login_form.jsp" %>

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">포토 겔러리</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움">${board.subject}</font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              나종민  / <font size="2" face="돋움">2007-10-22 / 1번 읽음</font>
             <p>${board.contents}<p>
           </td>
         </tr>
       </table>

      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 새글쓰기 -->
       <a href="gallery_write.do?page=${page}">
       <img src="/Gallery/img/write.jpg" border="0"></a>&nbsp;&nbsp;
	   <!-- 수정하기 -->
       <a href="gallery_modify.do?idx=${board.idx}&page=${page}">
       <img src="/Gallery/img/edit.gif" border="0"></a>&nbsp;&nbsp;
         <!-- 삭제하기 -->
       <a href="javascript:gallery_del()"><img src="/Gallery/img/del.gif" border="0"></a>&nbsp;&nbsp;
      
       <!-- 목록보기 -->
       <a href="gallery_list.do?page=${page}"><img src="/Gallery/img/list-2.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>
