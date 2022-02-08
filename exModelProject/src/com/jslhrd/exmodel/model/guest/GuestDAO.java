package com.jslhrd.exmodel.model.guest;
import java.util.*;

import com.jslhrd.exmodel.util.DBManager;

import java.sql.*;
public class GuestDAO {
	private GuestDAO() {}
	private static GuestDAO instance = new GuestDAO();
	public static GuestDAO getInstance() {
		return instance;
	}
/*	
	private static Connection getConnection() throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = 
                 DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","hr","1234");
        return conn;   
    }
*/

	// 전체 글수 카운트
	public int guestCount(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		int row=0;	
		String query="select count(*) as counter from tbl_guest";
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt("counter");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 전체 글수 카운트(검색조검 포함)
	public int guestCount(String s_query){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		int row=0;	//name + " like '%" + 안녕 + "%'"
		String query="select count(*) as counter from tbl_guest where " + s_query;
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt("counter");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 전체 글수 카운트(검색조검 포함, 매개변수 2개)
	public int guestCount(String query, String key){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		int row=0;	//name + " like '%" + 안녕 + "%'"
		String query1="select count(*) as counter from tbl_guest "
				+ "where " + query + " like ?";
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, "%"+key+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt("counter");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public List<GuestVO> guestList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		List<GuestVO> list = new ArrayList<GuestVO>();
		String query="select * from tbl_guest order by idx";
			
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	// 페이지 처리(검색조건 없음)
	public List<GuestVO> guestList(int startpage, int endpage){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		List<GuestVO> list = new ArrayList<GuestVO>();
		String query="select X.* from (select rownum as rnum, A.* from " + 
			     " (select * from tbl_guest order by regdate desc) A " + 
			     "	where rownum <= ?) X where X.rnum >= ?";
		//String query="select * from tbl_board order by regdate desc limit ?,?";	
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//전체목록(검색기능 포함)
	public List<GuestVO> guestList(String s_query){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		List<GuestVO> list = new ArrayList<GuestVO>();
		String query="select * from tbl_guest where " + s_query + " order by idx";
			
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//전체목록(검색기능 포함+페이지 처리
	public List<GuestVO> guestList(String s_query, int startpage, int endpage){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		List<GuestVO> list = new ArrayList<GuestVO>();
		String query="select X.* from (select rownum as rnum, A.* from " + 
			     " (select * from tbl_guest order by regdate desc) A where " + s_query + 
			     "	and rownum <= ?) X where " + s_query + " and  X.rnum > ?";
			
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//등록
	public int guestWrite(GuestVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		int row=0;
		String query="insert into tbl_guest(idx,name,subject,contents) "
				+ "values(tbl_guest_seq_idx.nextval,?,?,?)";
			
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3,vo.getContents());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

}
