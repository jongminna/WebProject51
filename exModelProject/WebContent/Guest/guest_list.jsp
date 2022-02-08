<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.jslhrd.exmodel.model.guest.*, com.jslhrd.exmodel.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	GuestDAO dao = GuestDAO.getInstance();
	
	String s_query="", query="", key="";
	int totcount=0;// 게시글 수
	List<GuestVO> list = null;
	if(request.getParameter("key") != null){
		query = request.getParameter("query");
		key = request.getParameter("key");
		s_query = query + " like '%" + key + "%'";
		totcount = dao.guestCount(s_query);
		//totcount = dao.guestCount(query, key);
		//list = dao.guestList(s_query);
		//list = dao.guestList(query, key);
	}else{
		totcount = dao.guestCount();
		//list = dao.guestList();
	}

	int nowpage=1;//현재페이지
	int maxlist=10;//페이지당 글수
	int totpage=1;//총페이지
	//페이지수 계산
	if(totcount % maxlist == 0){
		totpage = totcount / maxlist;
	}else{
		totpage = totcount / maxlist + 1;
	}
	if(totpage==0) totpage=1;
	
	if(request.getParameter("page") != null){
		nowpage = Integer.parseInt(request.getParameter("page"));
	}
	if(nowpage > totpage)
		nowpage=totpage;
	
	int startpage = (nowpage-1)*maxlist+1; //시작페이지
	int endpage = nowpage * maxlist;
	int listcount = totcount-((nowpage-1)*maxlist);

	if(key.equals("")){
		list = dao.guestList(startpage, endpage);
	}else{
		list = dao.guestList(s_query, startpage, endpage);			
	}
	//페이지 처리 클래스 호출
	String pageSkip="";
	if(key.equals("")){
		pageSkip=PageIndex.pageList(nowpage,totpage,"guest_list.jsp","");
	}else{
		pageSkip=PageIndex.pageListHan(nowpage,totpage,"guest_list.jsp",query,key);
	}
%>
<html>
<head><title>방명록 읽기</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<style type="text/css">
  a.list {text-decoration:none;color:black;font-size:10pt;}
</style>
<script>
	function guest_search(){
		if(gSearch.key.value==""){
			alert("검색어을 입력하세요");
			gSearch.key.focus();
			return
		}
		gSearch.submit();
	}
</script>
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
        <img src="./img/bullet-01.gif"> <b>방 명 록</b></font></td></tr>
      <tr>
        <td colspan="5" align="right" valign="middle" height="20">
		<font size="2" face="고딕">전체 : <%=totcount %></b>건 - <%= nowpage %> Pages</font></td></tr>
 	   <tr bgcolor="e3e9ff">
 	      <td width="10%"align="center" height="20"><font face="돋움" size="2">번호</font></td>
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
<%
	if(list.size() != 0){
		for(GuestVO vo : list){
%>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
          <td align="center" height="25"><font face="돋움" size="2" color="#000000"><%=listcount--%></font></td>
          <td align="left" height="20"><font face="돋움" size="2" color="#000000"><a href="guest_view.jsp?idx=<%=vo.getIdx()%>&page=<%=nowpage%>"><%=vo.getSubject()%></a></td>
          <td align="center" height="20"><font face="돋움" size="2">
                <a class="list" href="mailto:ein1027@nate.com"><%=vo.getName()%></a></font></td>
          <td align="center" height="20"><font face="돋움" size="2"><%=vo.getRegdate().substring(0,10)%></font></td>
          <td align="center" height="20"><font face="돋움" size="2"><%=vo.getReadcnt()%></font></td>
      </tr>
<%
		}
	}else{
%>      
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
          <td align="center" colspan="5" height="25">
          <font face="돋움" size="2" color="#000000">등록된 자료가 없습니다.</font></td>
		</tr>
<%
	}
%>
     <div align="center">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">        
                <div align="center"><%= pageSkip %></div>
			  </td>
			 </tr>
		</table>
		
		<table width="700">
		<tr>
			<td width="25%"> &nbsp;</td>
			<td width="50%" align="center">
				<table>
					<form name="gSearch" method="post" action="guest_list.jsp">	
					<!-- 검색어를 이용하여 글제목, 작성자, 글내용 중에 하나를 입력 받아 처리하기 위한 부분 -->
						<tr>
							<td>
								<select name="query">
									<option value="subject" <% if(query.equals("subject")){ %> selected  <% } %>>글제목</option>
									<option value="name" <% if(query.equals("name")){ %> selected  <% } %>>작성자</option>
									<option value="contents" <% if(query.equals("contents")){ %> selected  <% } %>>글내용</option>
								</select>
							</td>
							<td> <input type="text" size=20 name="key" value="<%= key %>"></td>
							<td> <a href="javascript:guest_search()"><img src="./img/search2.gif" border="0"></a></td>
						</tr>
					</form>
				</table>
			</td>
			<td width="25%" align="right">
			<a href="guest_write.jsp"><img src="./img/write.gif" border="0"></a>
			</td>
		</tr>
	</table>
		
		</div>
	</body>
	</html>

