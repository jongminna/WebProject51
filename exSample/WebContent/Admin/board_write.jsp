<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>협력업체 관리 - 관리자페이지</title>
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
					<td height=40 align="center" style="font-size: 15px;"><b>협력업체[등록][수정][삭제]</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>제목</strong></td>
								<td bgcolor="ffffff"><input name="subject" type="text" style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
								<td bgcolor="ffffff">
										<textarea name="contents" cols="62" rows="10" class="textfield"> </textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</form>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href=""><b>[답변][수정][등록]</b></a>&nbsp; <a href=""><b>[취소]</b></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>	
</body>
</html>
