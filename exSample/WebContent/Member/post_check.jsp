<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<TITLE>우편번호 찾기</TITLE>

<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000}
a    { font-family: 돋움, Verdana; color: #000000; text-decoration: none}
     a:link { font-family:돋움; font-size:9pt; text-decoration:none}
     a:visited { font-family:돋움; font-size:9pt; text-decoration:none}
     a:hover { font-family:돋움; text-decoration:underline }
-->
</STYLE>

<script>
	function check(){
		if(inquery.addr.value==""){
			alert("동이름을 입력하세요");
			inquery.addr.focus();
			return false;
		}
	}	
	//우편번호 주소 리턴
	function sendAddr(code,sido,gugun,dong,bunji){
		addr = sido+" "+gugun+" " + dong+" "+ bunji;
		opener.login.zip.value=code;
		opener.login.addr1.value=addr;
		self.close();
		
	}
</script>
</HEAD>

<BODY BGCOLOR="#FFFFFF" onLoad="document.inquiry.addr.focus();">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./Member/img/u_b02.gif"></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>우편번호 찾기</FONT></td>
    <td align=right><img src= "./Member/img/u_b03.gif"></td>
  </tr>
</table>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330><TR><TD BGCOLOR=#948DCF>
  <TABLE CELLPADDING=0 CELLSPACING=1 BORDER=0 WIDTH=330><TR><TD>
    <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=3 WIDTH=100% BGCOLOR=#FFFFFF>
    <FORM NAME="inquiry" METHOD="post" ACTION="post_check.do" onSubmit="return check();">
      <TR>
        <TD ALIGN=CENTER><br>
          동이름 입력 : <INPUT NAME="addr" TYPE="text" style="width:120">
          <INPUT TYPE="image" src="./Member/img/u_bt08.gif" hspace=10>
        </TD>
      </TR>
      <TR>
        <TD ALIGN=CENTER>
        ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.
        </TD>
      </TR>
   <c:if test="${!empty addr }" > 
     <c:forEach var="zip" items="${list }"> 
      <TR>
        <TD><a href="javascript:sendAddr('${zip.zipcode}','${zip.sido}','${zip.gugun}','${zip.dong}','${zip.bunji}')"> ${zip.zipcode} ${zip.sido} ${zip.gugun} ${zip.dong} ${zip.bunji}</a>
        </TD>
      </TR>
      </c:forEach>
   </c:if>  
   <c:if test="${empty list }" >       
      <TR>
        <TD> 등록된 우편번호가 존재하지 않습니다.
        </TD>
      </TR>
	</c:if>
    </FORM>
    </TABLE>
  </TD></TR></TABLE>
</TD></TR></TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./Member/img/u_b04.gif"></td>
    <td align=right><img src="./Member/img/u_b05.gif"></td>
  </tr>
  <tr>
    <td colspan=2 align=center>
      <a href="#" onClick="self.close()"><img src="./Member/img/u_bt13.gif" border=0 vspace=5></a>    </td>
  </tr>
</table>
</BODY>
</HTML>
