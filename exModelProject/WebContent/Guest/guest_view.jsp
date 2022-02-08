<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.jslhrd.exmodel.model.guest.*, com.jslhrd.exmodel.util.*" %>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	int nowpage = Integer.parseInt(request.getParameter("page"));
	
	GuestDAO dao = GuestDAO.getInstance();
	//쿠키검사
	boolean bool = false;
	Cookie info = null;
	Cookie[] cookies = request.getCookies();
	for(int x=0; x<cookies.length; x++){
		info = cookies[x];
		if(info.getName().equals("guestCookie"+idx)){
			bool = true;
			break;
		}
	}
	// 쿠키값 생성
	String newValue=""+System.currentTimeMillis();
	if(!bool){
		info = new Cookie("guestCookie"+idx, newValue);
		info.setMaxAge(24*60*60);//24시간
		response.addCookie(info);
		//dao.guestHit(idx);//조회수 증가 메소드
	}
	//검색
	


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
                  홈페이지 제작</font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              나종민  / <font size="2" face="돋움">2007-10-22 / 1번 읽음</font>
             <p>
             내용이 들어가는 부분<p>
           </td>
         </tr>
       </table>

      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 목록보기 -->
       <a href="guest_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>
