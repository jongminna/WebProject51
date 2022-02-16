package com.jslhrd.sample.model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.sample.util.DBManager;

public class BoardDAO {
/*  싱글톤	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
    
	public static BoardDAO getInstance() {
		return instance;
	}
*/
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//게시물 총수 계산
	public int boardCount() {
/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
*/		
		String query="select count(*) from tbl_board";
				
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
	public int boardCount(String s_query)  {
		String query = "";
		int row = 0;
//		String sql = "select * from portfolio where ptitle like ?  order by pcode desc";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "%" + search + "%");

		try{
			conn = DBManager.getConnection();
			if(s_query.equals("")) {
				query = "select count(*) as counter from tbl_board ";
			}else {
				query = "select count(*) as counter from tbl_board where " + s_query;
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
	public List<BoardVO> boardList() {
		String query="select * from tbl_board order by regdate desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			BoardVO board=null;
			while(rs.next()) {
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
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
	public List<BoardVO> boardList(int pagestart, int endpage) {
		String query="select X.* from (select rownum as rnum, A.* from " + 
				     " (select * from tbl_board order by regdate desc) A " + 
				     "	where rownum <= ?) X where X.rnum >= ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			BoardVO board=null;
			while(rs.next()) {
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
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
	public List<BoardVO> boardList(String s_query, int pagestart, int endpage) {
		String query="select X.* from (select rownum as rnum, A.* from " + 
				     " (select * from tbl_board order by regdate desc) A where " + s_query + 
				     "	and rownum <= ?) X where " + s_query + " and  X.rnum >= ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
//		String sql = "select * from portfolio where ptitle like ?  order by pcode desc";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "%" + search + "%");

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			BoardVO board=null;
			while(rs.next()) {
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
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
	public int boardWrite(BoardVO board){
		String query="insert into tbl_board(idx, name,email,subject,contents,pass)";
		query += " values (tbl_board_seq_idx.nextval, ?, ?, ?, ?, ?)";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContents());
			pstmt.setString(5, board.getPass());
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
		String query="update tbl_board set readcnt = readcnt + 1 where idx = ?";
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
	public BoardVO boardSelect(int idx) {
		String query="select * from tbl_board where idx = ?";
		BoardVO board = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setPass(rs.getString("pass"));
				board.setRegdate(rs.getString("Regdate"));
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
	public int  boardUpdate(BoardVO board)  {
		String query="update tbl_board set subject=?, contents=? where idx = ? and pass = ?";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContents());
			pstmt.setInt(3, board.getIdx());
			pstmt.setString(4, board.getPass());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	// 특정 글 삭제 처리
	public int boardDelete(int idx, String pass) {
		String query="delete from tbl_board where idx = ? and pass = ?";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

}
