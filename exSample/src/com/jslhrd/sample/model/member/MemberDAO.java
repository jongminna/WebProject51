package com.jslhrd.sample.model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.sample.util.DBManager;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
    
	public static MemberDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//회원정보 등록 메소드
	public int memberWrite(MemberVO vo) {
		
		String query="insert into tbl_member(idx,name,userid,passwd,"
				+ "zipcode,addr1,addr2,tel,email,job,intro,"
				+ "favorite) values (member_seq_idx.nextval,?,?,?"
				+ ",?,?,?,?,?,?,?,?)";
		int row=0;//리턴타입
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getZipcode());
			pstmt.setString(5, vo.getAddr1());
			pstmt.setString(6, vo.getAddr2());
			pstmt.setString(7, vo.getTel());
			pstmt.setString(8, vo.getEmail());
			pstmt.setString(9, vo.getJob());
			pstmt.setString(10, vo.getIntro());
			pstmt.setString(11, vo.getFavorite());
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}

	//ID 중복 검사 메소드
	public int memberIDcheck(String userid) {

		String query="select count(*) as counter  from tbl_member where userid=?";
		int row=0;//리턴타입
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1); //row = rs.getInt("counter");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
	// 우편번호 검색 메소드
	public List<ZipVO> zipList(String addr) {

		String query="select *  from zipcode where dong like '%" +addr +"%'";
		List<ZipVO> list = new ArrayList<ZipVO>();//리턴타입
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			ZipVO vo=null;
			while(rs.next()) {
				vo = new ZipVO();
				vo.setNo(rs.getString("no"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setSido(rs.getString("sido"));
				vo.setGugun(rs.getString("gugun"));
				vo.setDong(rs.getString("dong"));
				vo.setBunji(rs.getString("bunji"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
	
	// 회원 전체 리스트 메소드
	public List<MemberVO> memberList(){

		String query="select *  from tbl_member order by first_time desc";
		List<MemberVO> list = new ArrayList<MemberVO>();//리턴타입
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			MemberVO vo=null;
			while(rs.next()) {
				vo = new MemberVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setTel(rs.getString("tel"));
				vo.setFirst_time(rs.getString("first_time"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
	// 로그인 체크
	public int memberLogin(String userid, String passwd) {

		String query = "select passwd from tbl_member where userid = ?";
		int row=0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userid);		
			rs = pstmt.executeQuery();
			if(rs.next()){
				String dbpass = rs.getString("passwd");
				if(dbpass.equals(passwd)){  //로그인에 성공하면 최근접속일자 지정
					query = "update tbl_member set last_time = sysdate where userid = ?";
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
		
		} catch(SQLException e)	{
			e.printStackTrace();
		} finally	{
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
	// 특정 ID 검색
	public MemberVO memberSelect(String userid) {

		String query = "";
		MemberVO vo = new MemberVO();
		try {
			conn = DBManager.getConnection();
			query = "select * from tbl_member where userid = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,userid);		
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setUserid(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));	
				vo.setZipcode(rs.getString("zipcode"));	
				vo.setAddr1(rs.getString("addr1"));	
				vo.setAddr2(rs.getString("addr2"));	
				vo.setTel(rs.getString("tel"));	
				vo.setEmail(rs.getString("email"));	
				vo.setJob(rs.getString("job"));	
				vo.setIntro(rs.getString("intro"));	
				vo.setFavorite(rs.getString("favorite"));	
				vo.setFirst_time(rs.getString("first_time"));	
				vo.setLast_time(rs.getString("last_time"));	
			}
		} catch(SQLException e)	{
			e.printStackTrace();
		} finally	{
			DBManager.close(conn, pstmt,rs);
		}
		return vo;
	}

	// 회원정보 수정
	public int memberUpdate(MemberVO vo) {

		String query = "";
		int row=0;
		try {
			conn = DBManager.getConnection();
			query = "update tbl_member set zipcode = ?, addr1 = ?, addr2 = ?";
			query = query + ", tel = ?, email = ?, job = ?, intro = ?";
			query = query + ",favorite = ?";
			query = query + " where userid = ? and passwd = ?"; 			
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,vo.getZipcode());		
			pstmt.setString(2,vo.getAddr1());		
			pstmt.setString(3,vo.getAddr2());		
			pstmt.setString(4,vo.getTel());		
			pstmt.setString(5,vo.getEmail());		
			pstmt.setString(6,vo.getJob());		
			pstmt.setString(7,vo.getIntro());		
			pstmt.setString(8,vo.getFavorite());		
			pstmt.setString(9,vo.getUserid());		
			pstmt.setString(10,vo.getPasswd());		
			
			row=pstmt.executeUpdate();
			
		} catch(Exception e)	{
			e.printStackTrace();
		} finally	{
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}

}
