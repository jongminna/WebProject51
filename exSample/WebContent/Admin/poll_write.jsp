<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>설문조사 관리 - 관리자페이지</title>
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
	<tr>
		<td>  <!-- 탑메뉴 incluse -->     </td>
	</tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>설문조사 등록</b>
					</b></td>
				</tr>
			</table><br>
			<table width="80%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<form>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>설문제목</strong></td>
								<td bgcolor="ffffff">
									<input name="question" type="text" style="width:400; height:18; padding:2; border:1 solid slategray"> 
								</td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>답변문항 1</strong></td>
								<td bgcolor="ffffff"><input name="reply1" type="text" style="width:400; height:18; padding:2; border:1 solid slategray" ></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>답변문항 2</strong></td>
								<td bgcolor="ffffff"><input name="reply2" type="text" style="width:400; height:18; padding:2; border:1 solid slategray" ></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>답변문항 3</strong></td>
								<td bgcolor="ffffff"><input name="reply3" type="text" style="width:400; height:18; padding:2; border:1 solid slategray" ></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>답변문항 4</strong></td>
								<td bgcolor="ffffff"><input name="reply4" type="text" style="width:400; height:18; padding:2; border:1 solid slategray" ></td>
							</tr>
						</table>
					</td>
					</form>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center>
						[등록]&nbsp;[취소]
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
