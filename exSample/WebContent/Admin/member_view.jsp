<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>협력업체 관리 - 관리자페이지</title>
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
					<td height=40 align="center" style="font-size: 15px;"><b>회원정보 상세보기</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="25%" align="center" bgcolor="EcECEC"><strong>회원성명</strong></td>
								<td width="25%"bgcolor="ffffff">홍길동</td>
								<td width="25%" align="center" bgcolor="EcECEC"><strong>아이디</strong></td>
								<td align="center" bgcolor="ffffff">user01</td>
							</tr>
							<tr>
								<td align="center" bgcolor="EcECEC"><strong>전화</strong></td>
								<td bgcolor="ffffff">010-1111-2222</td>
								<td align="center" bgcolor="EcECEC"><strong>이메일</strong></td>
								<td align="center" bgcolor="ffffff">abc@naver.com</td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>가입일자</strong></td>
								<td bgcolor="ffffff">2020-01-01</td>
								<td align="center" bgcolor="EcECEC"><strong>최근로그인일자</strong></td>
								<td align="center" bgcolor="ffffff">2020-01-22</td>
							</tr>
						</table>
					</td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href=""><b>[답변]</b></a>&nbsp; <a href=""><b>[수정]</b></a>&nbsp; <a href=""><b>[삭제]</b></a>&nbsp; <a href=""><b>[취소]</b></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>			
</body>
</html>
