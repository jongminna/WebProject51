<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
<HEAD>
<TITLE>사용자의 아이디를 체크합니다.</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
<script>
	function id_check(){
		if(idcheck.userid.value==""){
			alert("아이디입력");
			idcheck.userid.focus();
			return;
		}
	}
	
	function win_close(){
		var s = '${row}';
		if(s != 0){
			self.close();
		}else{
			opener.login.userid.value='${userid}';
			self.close();
		}
	}
</script>
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./Member/img/u_b02.gif"></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>아이디 중복 체크</FONT></td>
    <td align=right><img src="./Member/img/u_b03.gif"></td>
  </tr>
</table>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
<TR BGCOLOR=#948DCF>
  <TD>
    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
  	  <TR BGCOLOR="#FFFFFF">
        <TD ALIGN="center">
        <c:if test="${!empty userid}"  >
         <c:if test="${row ==0 }" >
           <br><FONT FACE="굴림"><B>사용 가능합니다.</B></FONT><br>
           <BR><FONT COLOR="#483cae"><b>${userid}</b></FONT>는 아직 사용되지 않은 아이디입니다.
           <BR><FONT COLOR="#483cae"><b>${userid}</b></FONT>로 등록하셔도 됩니다.
         </c:if>
         <c:if test="${row !=0 }">
           <br><font face="굴림"><b>죄송합니다</b></font><br>
    	   <BR><FONT COLOR="#483cae"><b>${userid}</b></FONT>는 이미 사용 중인 아이디입니다<br>
    	 </c:if>
    	</c:if>
    	<c:if test="${empty userid}"  >
    	사용할 아이디 검색 :
    	<form name="idcheck" method="post" action="id_check.do">
           <INPUT NAME=userid type=text size=16 maxlength=16>
      	   <input type=image src="./Member/img/u_bt08.gif" border=0 vspace=0 onClick="id_check()">
		</form>
		</c:if>
        </TD>
      </TR>
    </TABLE>
 </TD>
</TR>
</TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./Member/img/u_b04.gif"></td>
    <td align=right><img src="./Member/img/u_b05.gif"></td>
  </tr>
  <tr>
    <td colspan=3 align=center>
      <a href="#" onClick="win_close()"><img src="./Member/img/u_bt13.gif" border=0 vspace=5></a>
    </td>
  </tr>
</table>
</BODY>
</HTML>