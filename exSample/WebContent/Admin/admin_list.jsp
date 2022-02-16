<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>관리자 정보 - 관리자페이지</title>
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
}
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
					<td height=40 align="center" style="font-size: 15px;"><b>관리자 [등록][수정]</b>
					</b></td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<form name="frm" method="post" >
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="30%" align="center" bgcolor="EcECEC"><strong>관리자아이디</strong></td>
								<td bgcolor="ffffff"><input name="adminid" type="text" value=""  style="width:150; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="30%" align="center" bgcolor="EcECEC"><strong>관리자비밀번호</strong></td>
								<td bgcolor="ffffff"><input name="adminpass" type="text" value=""  style="width:150; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="30%" align="center" bgcolor="EcECEC"><strong>관리자등급</strong></td>
								<td bgcolor="ffffff"><select name="rate">
								<option value="1">1등급</option>
								<option value="2">2등급</option>
								<option value="3">3등급</option>
								<option value="4">4등급</option>
								</select>
								</td>
							</tr>
						</table>
					</td>
					</form>
				</tr>

			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center>
					[수정]&nbsp;[등록]&nbsp;[취소]</td>
				</tr>
			</table>
		</td>
	</tr>
</table>			
</body>
</html>
