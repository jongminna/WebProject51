package com.jslhrd.sample.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
/*	
	public static Connection getConnection() {		
		String myDriver="oracle.jdbc.driver.OracleDriver";
		String myURL="jdbc:oracle:thin:@localhost:1521:xe";
		String myID="jslhrd51";
		String myPass="1234";
		
		Connection conn = null;
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL, myID, myPass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
*/
	//커넥션 풀 설정
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			Context env = (Context)init.lookup("java:/comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
