package com.jslhrd.sample.model.pds;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.sample.util.DBManager;

public class PdsDAO {
	private PdsDAO() {
	}

	private static PdsDAO instance = new PdsDAO();

	public static PdsDAO getInstance() {
		return instance;
	}

	//게시물 총수 계산
	public int countPds() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select count(*) from tbl_pds";
				
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
	public int countPds(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select count(*) from tbl_pds where " + s_query;
//		String sql = "select * from portfolio where ptitle like ?  order by pcode desc";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "%" + search + "%");
				
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
	
	// c Read u d
	public List<PdsVO> listPds() {
		// 최근 등록한 상품 먼저 출력하기
		String sql = "select * from tbl_pds order by idx desc";
		List<PdsVO> list = new ArrayList<PdsVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // 이동은 행(로우) 단위로
				PdsVO pVo = new PdsVO();
				pVo.setIdx(rs.getInt("idx"));
				pVo.setName(rs.getString("name"));
				pVo.setEmail(rs.getString("email"));
				pVo.setSubject(rs.getString("subject"));
				pVo.setRegdate(rs.getString("regdate"));
				pVo.setReadcnt(rs.getInt("readcnt"));
				pVo.setFilename(rs.getString("filename"));
				list.add(pVo);
			}// while문 끝
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}// listPds() {

	public List<PdsVO> listPds(int pagestart, int endpage)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select X.* from (select rownum as rnum, A.* from (" + 
				"select * from tbl_pds order by idx desc) A " + 
				"where rownum <= ?) X where X.rnum >= ? ";

		List<PdsVO> list = new ArrayList<PdsVO>();

		try{
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,endpage);
			pstmt.setInt(2,pagestart);

			rs=pstmt.executeQuery();

			while(rs.next()){
				PdsVO pds = new PdsVO();
				pds.setIdx(rs.getInt("idx"));
				pds.setName(rs.getString("name"));
				pds.setEmail(rs.getString("email"));
				pds.setPass(rs.getString("pass"));
				pds.setSubject(rs.getString("subject"));
				pds.setRegdate(rs.getString("regdate"));
				pds.setReadcnt(rs.getInt("readcnt"));
				pds.setFilename(rs.getString("filename"));
				list.add(pds);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//자료실 검색 + 페이지별 데이터 검색
	public List<PdsVO> listPds(String s_query, int pagestart, int endpage)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select X.* from (select rownum as rnum, A.* from (" + 
				"select * from tbl_pds order by idx desc) A " + 
				"where " + s_query + "and rownum <= ?) X where "+ s_query + " and  X.rnum >= ? ";
//		String sql = "select * from portfolio where ptitle like ?  order by pcode desc";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "%" + search + "%");

		List<PdsVO> list = new ArrayList<PdsVO>();

		try{
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,endpage);
			pstmt.setInt(2,pagestart);

			rs=pstmt.executeQuery();

			while(rs.next()){
				PdsVO pds = new PdsVO();
				pds.setIdx(rs.getInt("idx"));
				pds.setName(rs.getString("name"));
				pds.setEmail(rs.getString("email"));
				pds.setPass(rs.getString("pass"));
				pds.setSubject(rs.getString("subject"));
				pds.setRegdate(rs.getString("regdate"));
				pds.setReadcnt(rs.getInt("readcnt"));
				pds.setFilename(rs.getString("filename"));
				list.add(pds);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int insertPds(PdsVO pVo) {
		String sql = "insert into tbl_pds(idx,name,email,subject,contents,pass,filename) " +
				" values(tbl_pds_seq_idx.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setString(2, pVo.getEmail());
			pstmt.setString(3, pVo.getPass());
			pstmt.setString(4, pVo.getSubject());
			pstmt.setString(5, pVo.getContents());
			pstmt.setString(6, pVo.getFilename());
			row=pstmt.executeUpdate(); // 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	public PdsVO selectPdsNum(int idx) {
		String sql = "select * from tbl_pds where idx=?";
		PdsVO pVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					pVo = new PdsVO();
					pVo.setIdx(rs.getInt("idx"));
					pVo.setName(rs.getString("name"));
					pVo.setEmail(rs.getString("email"));
					pVo.setSubject(rs.getString("subject"));
					pVo.setContents(rs.getString("contents"));
					pVo.setRegdate(rs.getString("regdate"));
					pVo.setReadcnt(rs.getInt("readcnt"));
					pVo.setFilename(rs.getString("filename"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pVo;
	}

	//조회수 카운트 증가
	public void hitsPds(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="update tbl_pds set readcnt = readcnt +1  where idx = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public int updatePds(PdsVO pVo) {
		String sql = "update tbl_pds set subject=?, email=?, contents=?, filename=? where idx = ? and pass = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getSubject());
			pstmt.setString(2, pVo.getEmail());
			pstmt.setString(3, pVo.getContents());
			pstmt.setString(4, pVo.getFilename());
			pstmt.setInt(5, pVo.getIdx());
			pstmt.setString(6, pVo.getPass());
			row = pstmt.executeUpdate();// 쿼리문 실행한다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
			return row;
		}
	}

	public int deletePds(int idx, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int row=0;
		String saveDir="Pds/upload/";
		try {
			conn = DBManager.getConnection();	
			sql = "select filename from tbl_pds where idx = ? and pass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String filename = rs.getString("filename");
				File a = new File(saveDir+filename);
				System.out.println(saveDir+filename);
				if(a.isFile()) {
					System.out.println(saveDir+filename);
					a.delete();
				}
			}
			sql = "delete tbl_pds where idx=? and pass =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			row=pstmt.executeUpdate();// 쿼리문 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
			return row;
		}
	}
	// 파일이름 검색
	public String searchFile(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select filename from tbl_pds where idx=?";
		String filename = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				filename = rs.getString("filename");
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e) {}
		}
		return filename;
	}

}
