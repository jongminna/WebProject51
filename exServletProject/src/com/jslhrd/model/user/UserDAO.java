package com.jslhrd.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.util.DBManager;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	//아이디중복 검사 메소드
	public int idCheck(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row=0;
		String query="select count(*) from tbl_user where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
	
	// 등록메소드
	public int userInsert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row=0;
		String query="insert into tbl_user(name,userid,passwd,tel,email) "
				+ "values(?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
	// 로그인 메소드
	public int userLogin(String userid,String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row=0;
		String query="select passwd from tbl_user where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpass=rs.getString(1);
				if(dbpass.equals(passwd)) {
					query="update tbl_user set last_time=sysdate where userid=?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, userid);
					pstmt.executeUpdate();
					row=1;
				}else {
					row=-1;//비번오류
				}
			}else {
				row=0;//아이디가 없을 경우
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}

	//아이디에 해당하는 사용자 검색(수정)
	public UserVO userSelect(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserVO vo = new UserVO();
		String query="select * from tbl_user where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return vo;
	}

	// 회원전체 목록 검색 메소드- 관리자
	public List<UserVO> userList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<UserVO> list = new ArrayList();
		String query="select * from tbl_user order by userid";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO();
				
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));				
				vo.setFirst_time(rs.getString("first_time"));				
				vo.setLast_time(rs.getString("last_time"));		
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
	
	//수정메소드
	
	
}
