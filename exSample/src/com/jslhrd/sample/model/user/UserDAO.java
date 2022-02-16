package com.jslhrd.sample.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.sample.util.DBManager;


public class UserDAO {
	// 싱글톤
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();// 객체생성
	public static UserDAO getInstance() {
		return instance;
	}
	
	// ID 중복 검사 메소드
	public int idCheck(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		int row =0;
		//query 정의
		String query="select count(*) from tbl_users where userid=?";
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return row;
	}

	// 등록 메소드 
	public int userInsert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		int row =0;
		//query 정의
		String query="insert into tbl_users(name,userid,passwd,tel,email) "
				+ "values(?,?,?,?,?)";
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			
			row=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return row;
	}

	// 로그인 처리 메소드 
	public int userLogin(String userid, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		UserVO user = null;
		int row=0;
		//query 정의
		String query="select passwd from tbl_users where userid = ?";
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userid);		
			rs = pstmt.executeQuery();
			if(rs.next()){
				String dbpass = rs.getString("passwd");
				if(dbpass.equals(passwd)){  //로그인에 성공하면 최근접속일자 지정
					query = "update tbl_users set last_time = sysdate where userid = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1,userid);		
					pstmt.executeUpdate();
					row = 1;
				}else{ //비밀번호가 다른 경우
					row = 0;
				}
			}else{  //아이디가 없는 경우
				row = -1;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return row;
	}

	// 특정 ID를 이용한 사용자 정보 검색
	public UserVO userSelect(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		UserVO user = new UserVO();
		int row=0;
		//query 정의
		String query="select * from tbl_users where userid = ?";

		UserVO vo = new UserVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userid);		
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setUserid(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));	
				vo.setTel(rs.getString("tel"));	
				vo.setEmail(rs.getString("email"));	
				vo.setFirst_time(rs.getString("first_time"));	
				vo.setLast_time(rs.getString("last_time"));	
			}
		} catch(Exception e)	{
			e.printStackTrace();
		} finally	{
			DBManager.close(conn, pstmt,rs);
		}
		return vo;
	}
	
	// 회원정보수정 
	public int userModify(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		int row =0;
		//query 정의
		String query="";
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return row;
	}
	
	// 회원정보 목록 메소드(관리자가 사용) 
	public List<UserVO> userList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		List<UserVO> list = new ArrayList<>();
		//query 정의
		String query="select * from tbl_users order by first_time desc";
		
		try {
			//conn = getConnection();
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
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return list;
	}

	// 회원정보 검색(관리자)
	public UserVO userSearch(String search, String key) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		UserVO user = null;
		//query 정의
		String query="";
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return user;
	}

	// 회원정보 삭제 또는 회원탈퇴
	public int userDelete(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		int row =0;
		//query 정의
		String query="";
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return row;
	}
	
}
