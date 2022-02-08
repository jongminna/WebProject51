<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%
	String myDriver="oracle.jdbc.driver.OracleDriver";
	String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jslhrd51";
	String myPass = "1234";
%>

<%
	request.setCharacterEncoding("utf-8");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
	}catch(Exception e){
		e.printStackTrace();	
	}

	int idx = Integer.parseInt(request.getParameter("idx"));
	String sql = "update tbl_guest set readcnt=readcnt+1 where idx=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.executeUpdate();
	
	sql ="select * from tbl_guest where idx=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, idx);
	rs = pstmt.executeQuery();
	rs.next();
%>
 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>방명록 내용 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
<script>
	function guest_list(){
		location.href="guest_list.jsp";
	}
	
	function del(){
		var flag = confirm("삭제할가요?")
		if(flag==true){
			location.href="guest_delete_pro.jsp?idx=<%=idx%>";
		}
		return;
	}
	function modify(){
		location.href="guest_modify.jsp?idx=<%=idx%>";
	}
	</script>
 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">방 명 록</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움">
                  <%= rs.getString("subject") %></font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              <%= rs.getString("name") %>  / <font size="2" face="돋움"><%= rs.getString("regdate") %> / <%= rs.getInt("readcnt") %>번 읽음</font>
             <p><%= rs.getString("contents").replace("\n", "<br>") %><p>
           </td>
         </tr>
       </table>

      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 목록보기 -->
       <input type="button" value="수정" onClick="modify()">
       <input type="button" value="삭제" onClick="del()">
       <input type="button" value="목록" onClick="guest_list()">
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>
