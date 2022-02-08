package com.jslhrd.exmodel.model.boardreply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Set;

import com.jslhrd.exmodel.model.guest.GuestVO;
import com.jslhrd.exmodel.util.DBManager;

public class BoardReplyDao {
	private BoardReplyDao() {}
	private static BoardReplyDao instance = new BoardReplyDao();
	public static BoardReplyDao getInstance() {
		return instance;
	}

	//등록 메소드 정의
	public int boardWrite(BoardReplyVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int parent = vo.getParent();
		int indent = vo.getIndent();
		int depth = vo.getDepth();
		int idx=0;
		//리턴타입
		int row=0;
		String query="";
			
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select tbl_boardreply_seq_idx.nextval from dual");
			rs = pstmt.executeQuery();
			if(rs.next())
				idx=rs.getInt(1);
			
			if(parent == 0) { //부모글 처음 작성된 글
				vo.setParent(idx);
				depth=0;
				indent=0;	
			}else { //답변글 일 경우
				query="update tbl_boardreply set depth=depth+1 where parent =? and depth > ?";
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, parent);
				pstmt.setInt(2, depth);
				pstmt.executeUpdate();
				
				vo.setDepth(depth+1);
				vo.setIndent(indent+1);
			}
			
			vo.setIdx(idx);
			query="insert into tbl_boardreply(idx,name,email,subject,contents,"
					+ "pass,parent,realparent,depth,indent) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getIdx());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getPass());
			pstmt.setInt(7, vo.getParent());
			pstmt.setInt(8, vo.getRealparent());
			pstmt.setInt(9, vo.getDepth());
			pstmt.setInt(10, vo.getIndent());
		
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//전체목록(검색 X, 페이지 X)
	public List<BoardReplyVO> boardList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		List<BoardReplyVO> list = new ArrayList();
		String query="select * from tbl_boardreply order by parent, depth asc";
			
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardReplyVO vo = new BoardReplyVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setIndent(rs.getInt("indent"));//들여쓰기
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//idx에 해당하는 글 검색(상세보기, 수정에서 사용)
	public BoardReplyVO boardSelect(int idx){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		BoardReplyVO vo = new BoardReplyVO();
		String query="select * from tbl_boardreply where idx=?";
			
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setParent(rs.getInt("parent"));
				vo.setRealparent(rs.getInt("realparent"));
				vo.setDepth(rs.getInt("depth"));
				vo.setIndent(rs.getInt("indent"));//들여쓰기
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// 답변글 카운트
	public int countReply(int idx){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		int row=0;
		String query="select count(*) from tbl_boardreply where realparent=?";
			
		try {
			//conn = getConnection();
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
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	
	//삭제 메소드
	public int boardDelete(int idx, String pass){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입
		int row = 0;
		String query="delete from tbl_boardreply where idx=? and pass=?";
			
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

}
