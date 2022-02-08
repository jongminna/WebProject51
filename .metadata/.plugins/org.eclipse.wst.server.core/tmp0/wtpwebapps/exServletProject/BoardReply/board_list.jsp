<%@ page contentType="text/html; charset=UTF-8" %>


<html>
<head><title>게시판 읽기</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
<style type="text/css">
  a.list {text-decoration:none;color:black;font-size:10pt;}
</style>

</head>
<body bgcolor="#FFFFFF" topmargin="0" leftmargin="0">
<table border="0" width="800">
  <tr>
    <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">

	<!-- 다음에 추가할 부분 --></td>

	<td width="80%" valign="top">	
		<br>
    <table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <img src="./img/bullet-01.gif"> <b>자 유 게 시 판</b></font></td></tr>
      <tr>
        <td colspan="5" align="right" valign="middle" height="20">
		<font size="2" face="고딕">전체 : <b>15</b>건 - 1/ 2 Pages</font></td></tr>
 	   <tr bgcolor="e3e9ff">
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">번 호</font></td>
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제 목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>

			<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
        <td align="center" height="25">
        <font face="돋움" size="2" color="#000000">5</font></td>
			<td align="left" height="20">&nbsp;
				<font face="돋움" size="2" color="#000000">
				<a class="list" href="">제목부분입니다</a></td>
					<td align="center" height="20"><font face="돋움" size="2">
					<a class="list" href="mailto:ein1027@nate.com">나종민</a></font></td>
				<td align="center" height="20"><font face="돋움" size="2">2007-10-22</font></td>
				<td align="center" height="20"><font face="돋움" size="2">
				3</font></td>
			</tr>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
        <td align="center" height="25">
        <font face="돋움" size="2" color="#000000">5</font></td>
			<td align="left" height="20">&nbsp;
				<img src="./img/reply2.gif">
				<font face="돋움" size="2" color="#000000">
				<a class="list" href="">제목부분입니다</a></td>
					<td align="center" height="20"><font face="돋움" size="2">
					<a class="list" href="mailto:ein1027@nate.com">나종민</a></font></td>
				<td align="center" height="20"><font face="돋움" size="2">2007-10-22</font></td>
				<td align="center" height="20"><font face="돋움" size="2">
				3</font></td>
			</tr>


	 <div align="center">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">        
                <div align="center">[1][2][3]</div>
			  </td>
			 </tr>
		</table>

	<table width="600">
		<tr>
			<td width="25%"> &nbsp;</td>
			<td width="50%" align="center">
				<table>
					<form>	
					<!-- 검색어를 이용하여 글제목, 작성자, 글내용 중에 하나를 입력 받아 처리하기 위한 부분 -->
						<tr>
							<td>
								<select name="search">
									<option value="">글제목</option>
									<option value="">작성자</option>
									<option value="">글내용</option>
								</select>
							</td>
							<td> <input type="text" size=20 name=""></td>
							<td> <a href="#"><img src="./img/search2.gif" border="0"></a></td>
						</tr>
					</form>
				</table>
			</td>
			<td width="25%" align="right">
			<a href="#"><img src="./img/write.gif" border="0"></a>
			</td>
		</tr>
	</table>
</body>
</html>

