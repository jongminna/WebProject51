<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
 <head>
   <title>공지사항 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
<script>
function go_del() {
	flag = confirm("정말로 삭제하시겠습니까?");
	return (flag);
}
</script>
 </head>
 <body topmargin="0" leftmargin="0">

<%@ include file="/Include/topmenu.jsp" %>

   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

			<%@ include file="/Include/login_form.jsp" %> 

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="/Notice/img/bullet-01.gif"> 
              <font color="blue" size="3">공 지 사 항</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="/Notice/img/bullet-04.gif"> <font size="2" face="돋움">
              ${notice.subject}</font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              관리자 / <font size="2" face="돋움"> / ${notice.readcnt}번 읽음</font>
             <p>${contents}<p><!--contents의 내용을 <BR>태그로 처리-->
           </td>
         </tr>
       </table>
  <!--
      <p align="center">
      <font size="2">
       <a href="notice_write.do?page=${nowpage}">
       <img src="/SampleMVC/Notice/img/write.jpg" border="0"></a>&nbsp;&nbsp;
       <a href="notice_write.do?num=${notice.num}&page=${nowpage}">
       <img src="/SampleMVC/Notice/img/edit.gif" border="0"></a>&nbsp;&nbsp;
       <a onclick="return go_del()" href="notice_delete.do?page=${nowpage}&num=${notice.num}"><img src="/SampleMVC/Notice/img/del.gif" border="0"></a>&nbsp;&nbsp;
       <a href="notice_list.do?page=${nowpage}"><img src="/SampleMVC/Notice/img/list-2.gif" border="0"></a>&nbsp;&nbsp;
      </font> -->
    </td>
  </tr>
  </table>
  </body>
  </html>

