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
	String userid=request.getParameter("userid");
	String passwd=request.getParameter("passwd");
	String gubun=request.getParameter("gubun");
	String tel=request.getParameter("tel");
	String email=request.getParameter("email");
	String[] farr=request.getParameterValues("fa");
	String job=request.getParameter("job");
	String intro=request.getParameter("intro");
	//관심분야가 여러개일경우 (콤마)로 구분하여 저장
	String favorite="";
	if(farr != null){
		favorite=farr[0];
		for(int x=1; x<farr.length; x++){
			favorite = favorite+","+farr[x];
		}
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	int row=0;
	
	try{
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
		String sql="insert into tbl_member(name,userid,passwd,gubun,tel,email,favorite,job,intro) " +  
				" values(?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, userid);
		pstmt.setString(3, passwd);
		pstmt.setString(4, gubun);
		pstmt.setString(5, tel);
		pstmt.setString(6, email);
		pstmt.setString(7, favorite);
		pstmt.setString(8, job);
		pstmt.setString(9, intro);
		
		row = pstmt.executeUpdate();
	
	}catch(Exception e){
		e.printStackTrace();
	}
	out.print("row :" + row);
	//response.sendRedirect("userinfo_list.jsp");
%>
	

