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
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

//-->
</script>
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
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>포토갤러리 []</b></a>
					</b></td>
				</tr>
			</table><br>
					<table width="620" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="5"></td>
                  </tr>
                  <tr>
                    <td><table width="620" border="0" cellspacing="1" cellpadding="6" bgcolor="#dddddd">
											<tr align="center" bgcolor="#E3F3FF">
                        <td width=150 height="30" align="center">구분</td>
                        <td colspan="5" align="left" bgcolor="#ffffff">
							<select name="gubun" class="select">
								<option >구분1</option>
								<option >아기사진(돌)</option>
								<option >아기사진(돌)</option>
								<option >아기사진(돌)</option>
							</select>
						</td>
                      </tr>
                      <tr align="center" bgcolor="#E3F3FF">
                        <td width=150 height="30" align="center">제목</td>
                        <td colspan="5" align="left" bgcolor="#ffffff"><input name="subject" value="" type="text" size="50"></td>
                      </tr>
                      <tr align="center" bgcolor="#E3F3FF">
                        <td height="30" align="center">이미지</td>                      
                        <td colspan="5" align="left" bgcolor="#ffffff"><input name="photo" type="file" size="30" align="absmiddle"> (사이즈 : 765*335)</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="30" align="center" bgcolor="#ffffff"><a href=""><b>[등록하기]</b></a>&nbsp;<a href=""><b>[취소]</b></a></td>
                  </tr>
                </table>
<!--------------------------------------------------------------------------------------------------------->
		</TD>
	</TR>
</TABLE>
</body>
</html>