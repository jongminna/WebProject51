<%@ page contentType="text/html; charset=UTF-8" %>

 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>방명록 내용 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
<script>
	function guest_del(){
		var flag = confirm("삭제할가요?");
		if(flag==true){
			location.href="guest_delete.do?idx=${vo.idx}&page=${page}"
		}
	}
	function guest_delete(){
		var url="guest_delete.do?idx=${vo.idx}&page=${page}";
		window.open(url,"guest_delete","width=300, height=200");
	}
	
</script>   
 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">방 명 록</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움">${vo.subject}</font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              ${vo.name}  / <font size="2" face="돋움">${vo.regdate} / ${vo.readcnt}번 읽음</font>
             <p>${vo.contents}<p>
           </td>
         </tr>
       </table>

      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 목록보기 -->
       <a class="list" href="guest_modify.do?idx=${vo.idx}&page=${page}">[수정]</a>&nbsp;&nbsp;&nbsp;&nbsp;
       <a class="list" href="javascript:guest_del()">[삭제]</a>&nbsp;&nbsp;&nbsp;&nbsp;
       <a class="list" href="guest_write.do?page=${page}">[등록]</a>&nbsp;&nbsp;&nbsp;&nbsp;
       <a class="list" href="javascript:history.back()">[뒤로]</a>&nbsp;&nbsp;&nbsp;&nbsp;       
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>
