<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String myDriver="oracle.jdbc.driver.OracleDriver";
	String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jslhrd51";
	String myPass = "1234";
%>
<%
	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");
	String pass=request.getParameter("pass");
	String subject=request.getParameter("subject");
	String contents=request.getParameter("contents");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int row=0;
	
	try{
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
		String sql="insert into tbl_guest(idx,name,pass,subject,contents) " +  
				" values(tbl_guest_seq_idx.nextval, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pass);
		pstmt.setString(3, subject);
		pstmt.setString(4, contents);
		
		row = pstmt.executeUpdate();
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
		//response.sendRedirect("guest_list.jsp");
	if(row==1){	
%>
	<script>
		alert("등록되었습니다.");
		//location.replace("guest_list.jsp?row="+row);
		location.href="guest_list.jsp?row=<%=row%>";
	</script>
<%
	}else{
%>	
	<script>
		alert("잠시후 다시 등록해 주세요.");
		location.back();
	</script>
<%
	}
%>
	

