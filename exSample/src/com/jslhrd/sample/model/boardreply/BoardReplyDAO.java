package com.jslhrd.sample.model.boardreply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.sample.util.DBManager;

public class BoardReplyDAO {
	private BoardReplyDAO() {}
	private static BoardReplyDAO instance = new BoardReplyDAO();
    
	public static BoardReplyDAO getInstance() {
		return instance;
	}

	//게시물 총수 계산
	public int boardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select count(*) from tbl_boardreply";
				
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int row = 0;

		try{
			conn = DBManager.getConnection();
			if(s_query.equals("")) {
				query = "select count(*) as counter from tbl_boardreply ";
			}else {
				query = "select count(*) as counter from tbl_boardreply where " + s_query;
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
	public List<BoardReplyVO> boardList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select * from tbl_boardreply order by parent desc, depth asc";
		List<BoardReplyVO> list = new ArrayList<BoardReplyVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			BoardReplyVO board=null;
			while(rs.next()) {
				board = new BoardReplyVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setIndent(rs.getInt("indent"));
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
	public List<BoardReplyVO> boardList(int pagestart, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select X.* from (select rownum as rnum, A.* from " + 
				     " (select * from tbl_boardreply order by parent desc, depth asc) A " + 
				     "	where rownum <= ?) X where X.rnum >= ?";
		List<BoardReplyVO> list = new ArrayList<BoardReplyVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			BoardReplyVO board=null;
			while(rs.next()) {
				board = new BoardReplyVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setIndent(rs.getInt("indent"));

				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}

	// 게시글 검색 + 페이지별 데이터 검색
	public List<BoardReplyVO> boardList(String s_query, int pagestart, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select X.* from (select rownum as rnum, A.* from " + 
				     " (select * from tbl_boardreply order by parent desc, depth asc) A where " + s_query + 
				     "	and rownum <= ?) X where " + s_query + " and  X.rnum >= ?";
		List<BoardReplyVO> list = new ArrayList<BoardReplyVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			BoardReplyVO board=null;
			while(rs.next()) {
				board = new BoardReplyVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setIndent(rs.getInt("indent"));

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
	public int boardWrite(BoardReplyVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		int parent = board.getParent();
		int indent = board.getIndent();
		int depth = board.getDepth();
		int idx = 0;

		String query="";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select tbl_boardreply_seq_idx.nextval from dual");
			rs = pstmt.executeQuery();
			if(rs.next())
				idx = rs.getInt(1);
			
			if(parent != 0){ //답변글일 경우
				query = "update tbl_boardreply set depth=depth+1 where parent = ? and depth > ?";

				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,parent);
				pstmt.setInt(2,depth);
				pstmt.executeUpdate();

				board.setDepth(depth + 1);
				board.setIndent(indent + 1);
			}else{ //부모글번호가 0이면 처음 작성된글
				board.setParent(idx);
				depth = 0;
				indent = 0;
			}
			
			board.setIdx(idx);
			
			query = " insert into tbl_boardreply(idx,name,email,subject,contents,pass,";
			query += " parent,realparent,depth,indent) values (";
			query += " ?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getIdx());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getContents());
			pstmt.setString(6, board.getPass());
			pstmt.setInt(7, board.getParent());
			pstmt.setInt(8, board.getRealparent());
			pstmt.setInt(9, board.getDepth());
			pstmt.setInt(10, board.getIndent());
			row = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	// 조회수 증가
	public void boardHits(int idx)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="update tbl_boardreply set readcnt = readcnt + 1 where idx = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
	}
	
	//특정(기본키) 게시글 구하기--뷰페이지, 수정 페이지 에서 사용
	public BoardReplyVO boardSelect(int idx)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select * from tbl_boardreply where idx = ?";
		BoardReplyVO board = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardReplyVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("Regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setParent(rs.getInt("parent"));
				board.setRealparent(rs.getInt("realparent"));
				board.setDepth(rs.getInt("depth"));
				board.setIndent(rs.getInt("indent"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return board;
	}
	
	// 특정글 수정 처리(update)-- 기본키와 비번이 같을 경우
	public int  boardUpdate(BoardReplyVO board){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="update tbl_boardreply set subject=?, contents=? where idx = ? and pass = ?";
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
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}

	// 삭제 전 답글 유무 검사
	public int replySearch(int idx)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select count(*) from tbl_boardreply where realparent = ?";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
	
	// 특정 글 삭제 처리
	public int boardDelete(int idx, String pass)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="delete from tbl_boardreply where idx = ? and pass = ?";
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
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
}
