<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>설문조사 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css"> 
<!-- 
body,td,tr,table{font-size:9pt; font-family:tahoma;color:#666666;line-height:160%;} 

A:link {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:visited {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:active {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:hover {font-family:tahoma;font-size:9pt;color:#009900;text-decoration:underline;} 
--> 
</style> 

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
  <tr>
    <td align="center" height="100%" valign=middle><br>
       <table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
         <tr> 
           <td height=40 align="center" style="font-size: 15px;"><b>설문조사 결과표</b></a>
           </b></td>
         </tr>
      </table>
      <table width="80%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="20">
                    설문제목 : 설문제목입니다
          </td>
        </tr>
       <tr>
    <table border="0" width="640" bgcolor="white"> 
      <tr> 
        <td colspan="2" ><font size="2">&nbsp;&nbsp;&nbsp;(총투표자수: 50명)</font></td></tr>
      <tr>
        <td colspan="2" height="5"></td>
	  </tr><!-- 공간 띄우기용 빈 줄입니다. -->
      <tr>
        <td width="300">&nbsp;<font size="2">   
             답변내용 1입니다 - 15명( 17% )</font></td>
         <td width="390">  <!-- 설문 결과 그래프로 표시 -->
			<hr width="25" align="left" size="7" color="orange"></td>
          <td width="390">&nbsp;</td>
      </tr>
      <tr>
        <td width="300">&nbsp;<font size="2"> 
           답변내용 2입니다 - 21명( 25% )</font></td>
         <td width="390"><!-- 설문 결과 그래프로 표시 -->
         <hr width="33" align="left" size="7" color="orange"></td>
          <td width="390">&nbsp;</td>
      </tr>
      <tr>
        <td width="300">&nbsp;<font size="2"> 
           답변내용 3입니다 - 5명( 7% )</font></td>
         <td width="390"><!-- 설문 결과 그래프로 표시 -->
         <hr width="15" align="left" size="7" color="orange"></td>
          <td width="390">&nbsp;</td>
      </tr>
      <tr>
        <td width="700">&nbsp;<font size="2"> 
        답변내용 4입니다 - 5명( 7% )</font></td>
         <td width="390"><!-- 설문 결과 그래프로 표시 -->
         <hr width="15" align="left" size="7" color="orange"></td>
          <td width="390">&nbsp;</td>
      </tr>
	 </table>
 </td>
  </tr> 
</table>   
</body>          
</html>

