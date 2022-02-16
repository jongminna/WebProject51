<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>포토갤러리 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #606060;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	background-image:    url(img/bg_img01.gif);
}
-->
</style>
<link href="style.css" rel="stylesheet" type="text/css">

<style type="text/css">
<!--
.style1 {color: #4692c9}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="40%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>포토갤러리</b> 
							</b></td>
				</tr>
			</table>
			<br>
			<!--------------------------------------------------------------------------------------------->		
			<TABLE border=0 cellpadding=0 cellspacing=0 width=85% bgcolor=#FFFFFF>
				<TR valign=top>
					<TD align=right><b><a href="">[등록하기]</a></b></td>
				</tr>
				<TR>
					<TD>&nbsp;</td>
				</tr>
				<TR>
					<TD height=1 bgcolor=#cccccc></td>
				</tr>
				<TR>
					<TD>&nbsp;</td>
				</tr>
			</table>
			<TABLE border=0 cellpadding=0 cellspacing=1 width=85%>
				<TR valign=top>
					<td width="150" align=center>
						<TABLE border=0 cellpadding=0 cellspacing=1 width=100% height=135 bgcolor=#E4E4E4>
							<COLGROUP style="padding: 2 6;" align=center bgcolor=#FFFFFF><COL span=99 width=25%></COLGROUP>
							<tr>
								<TD align=center>사진<IMG SRC="../photo/" WIDTH="168" HEIGHT="120" BORDER="0" ><!-- 이미지사진 --></td>
							</TR>
							<TR valign=top>
								<TD align=center>[<a href="">수정</a>][<a href="">삭제</a>]</td>
							</TR>
						</table>
					</td>
				</tr>
			</TABLE>
<!--------------------------------------------------------------------------------------------->
		</TD>
	</TR>
</TABLE>
</body>
</html>
