package com.jslhrd.sample.model.gallery;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.sample.util.DBManager;

public class GalleryDAO {
	//  싱글톤	
	private GalleryDAO() {}
	private static GalleryDAO instance = new GalleryDAO();
	    
	public static GalleryDAO getInstance() {
		return instance;
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//게시물 총수 계산
	public int galleryCount() {
	/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	 */		
		String query="select count(*) from tbl_gallery2";
					
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			if(rs.next()){
				row=rs.getInt(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
			return row;
		}
	}

	// 게시물의 총수를 구하는 메소드(검색조건 포함)
	public int galleryCount(String s_query)  {
		String query = "";
		int row = 0;
//		String sql = "select * from portfolio where ptitle like ?  order by pcode desc";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "%" + search + "%");
		try{
			conn = DBManager.getConnection();
			if(s_query.equals("")) {
				query = "select count(*) as counter from tbl_gallery2 ";
			}else {
				query = "select count(*) as counter from tbl_gallery2 where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
				row = rs.getInt("counter");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
			return row;
		}
	}
		
	//게시글 전체 목록 구하기
	public List<GalleryVO> galleryList() {
		String query="select * from tbl_gallery2 order by regdate desc";
		List<GalleryVO> list = new ArrayList<GalleryVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			GalleryVO board=null;
			while(rs.next()) {
				board = new GalleryVO();
				board.setIdx(rs.getInt("idx"));
				board.setSubject(rs.getString("subject"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}

	// 게시글 페이지별 데이터 검색
	public List<GalleryVO> galleryList(int pagestart, int endpage) {
		String query="select X.* from (select rownum as rnum, A.* from " + 
				     " (select * from tbl_gallery2 order by regdate desc) A " + 
				     "	where rownum <= ?) X where X.rnum >= ?";
		List<GalleryVO> list = new ArrayList<GalleryVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			GalleryVO board=null;
			while(rs.next()) {
				board = new GalleryVO();
				board.setIdx(rs.getInt("idx"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	// 게시글 검색 + 페이지별 데이터 검색
	public List<GalleryVO> galleryList(String s_query, int pagestart, int endpage) {
		String query="select X.* from (select rownum as rnum, A.* from " + 
				     " (select * from tbl_gallery2 order by regdate desc) A where " + s_query + 
				     "	and rownum <= ?) X where " + s_query + " and  X.rnum >= ?";
		List<GalleryVO> list = new ArrayList<GalleryVO>();
//			String sql = "select * from portfolio where ptitle like ?  order by pcode desc";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%" + search + "%");

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			GalleryVO board=null;
			while(rs.next()) {
				board = new GalleryVO();
				board.setIdx(rs.getInt("idx"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
		
	//게시글 등록 메소드
	public int galleryWrite(GalleryVO board){
		String query="insert into tbl_gallery2(idx, subject,contents)";
		query += " values (tbl_gallery2_seq_idx.nextval, ?, ?)";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getSubject());
			StringReader sr = new StringReader(board.getContents());
			pstmt.setCharacterStream(2, sr, board.getContents().length());
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	// 조회수 증가
	public void boardHits(int idx) {
		String query="update tbl_gallery2 set readcnt = readcnt + 1 where idx = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
		
	//특정(기본키) 게시글 구하기--뷰페이지, 수정 페이지 에서 사용
	public GalleryVO gallerySelect(int idx) {
		String query="select * from tbl_gallery2 where idx = ?";
		GalleryVO board = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new GalleryVO();
				board.setIdx(rs.getInt("idx"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return board;
	}
		
	// 특정글 수정 처리(update)-- 기본키와 비번이 같을 경우
	public int  galleryUpdate(GalleryVO board)  {
		String query="update tbl_gallery2 set subject=?, contents=? where idx = ? ";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getSubject());
			
			StringReader sr = new StringReader(board.getContents());
			pstmt.setCharacterStream(2, sr, board.getContents().length());
			pstmt.setInt(3, board.getIdx());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	// 특정 글 삭제 처리
	public int galleryDelete(int idx, String pass) {
		String query="delete from tbl_gallery2 where idx = ?";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
}