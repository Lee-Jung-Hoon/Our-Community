package kr.co.mlec.notice.ourclassboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import kr.co.mlec.community.vo.AnonymityVO;
import kr.co.mlec.mypage.dao.MemberHistoryDAO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;
import kr.co.mlec.notice.ourclassboard.vo.BoardVO;
import kr.co.mlec.util.ConnectionPool;

public class BoardDAO {
	public void insertBoard(BoardVO board) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = " insert into t_notice_class_board(no, id, title, boardhead, content, scope) "
					   + " values(seq_t_notice_class_board_no.nextVal, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			
			int index = 1;
			pstmt.setString(index++, board.getId());
			pstmt.setString(index++, board.getTitle());
			pstmt.setString(index++, board.getBoardhead());
			pstmt.setString(index++, board.getContent());
			pstmt.setString(index++, board.getScope());
			pstmt.executeUpdate();

			String num = null;
			sql = " select seq_t_notice_class_board_no.currVal "
					+ " from dual";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				num = rs.getString("currVal");
			}
			
			MemberHistoryDAO dao = new MemberHistoryDAO();
			dao.insertMemberHistory(board.getId(),  board.getTitle(), "우리반 게시판", num);
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if ( pstmt != null) {
				pstmt.close();
			}
		} ConnectionPool.close(con);
	}
	
	public List<BoardVO> selectBoard() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = " select no, title, id, boardhead, check_Cnt, to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate "
					+ "	  from t_notice_class_board "
					+ "   order by no desc";
			pstmt = con.prepareStatement(sql);
			
			ResultSet rs= pstmt.executeQuery();
			
			List<BoardVO> list= new ArrayList<>();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getString("no"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("id"));
				board.setBoardhead(rs.getString("boardhead"));
				board.setCheckCnt(rs.getString("check_Cnt"));
				board.setRegDate(rs.getString("regDate"));
				list.add(board);
			}
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public BoardVO selectBoardDt(String no) throws Exception {
			BoardVO board = new BoardVO();
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ConnectionPool.getConnection();
				String sql = " select no, title, id, boardhead, scope, content, to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate "
						  + "  from t_notice_class_board "
						  + "  where no = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					board.setNo(rs.getString("no"));
					board.setTitle(rs.getString("title"));
					board.setId(rs.getString("id"));
					board.setBoardhead(rs.getString("boardhead"));
					board.setScope(rs.getString("scope"));
					board.setContent(rs.getString("content"));
					board.setRegDate(rs.getString("regDate"));
				}
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
				
			}finally {
				if(pstmt != null) {
					pstmt.close();
				}
				ConnectionPool.close(con);
			}
			return board;
	}
	
	public void deleteBoard(String no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = " delete from t_notice_class_board where no=? ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, no);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if( pstmt != null){
				pstmt.close();
			}
			ConnectionPool.close(con);
		} 
	}
	
	public void modifyBoard(BoardVO board) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
				con = ConnectionPool.getConnection();
				String sql = " update t_notice_class_board "
							+ " set id=?, title=?, content=? "
							+ " where no =? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getId());
				pstmt.setString(2, board.getTitle());
				pstmt.setString(3, board.getContent());
				pstmt.setString(4, board.getNo());
				pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if( pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public int selectBoardCnt() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date  "
					+ " from t_notice_class_board ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			
			List<BoardVO> list= new ArrayList<>();
			while(rs.next()) {
				cnt++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return cnt;
	}
	
	
	public List<BoardVO> searchBoard(int start, int end) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ " from (select no, title, id, boardhead , CHECK_CNT, rownum rnum, reg_date "
					+ " from( select no, title , id, boardhead, CHECK_CNT, reg_date "
					+ " from t_notice_class_board "
					+ " order by reg_date desc)) "
					+ "  where rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs= pstmt.executeQuery();
			
			List<BoardVO> list= new ArrayList<>();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getString("no"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("id"));
				board.setBoardhead(rs.getString("boardhead"));
				board.setRegDate(rs.getString("reg_date"));
				board.setCheckCnt(rs.getString("check_Cnt"));
				list.add(board);
			}
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public int selectBoardCnt(String type, String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ " from t_notice_class_board "
					+ "   where "+ type +" like ? "
					+ " order by reg_date desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+ search + "%");
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				cnt++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return cnt;
	}
	
	
	public List<BoardVO> searchBoard(int start, int end, String type, String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<BoardVO> list= new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ " from (select no, title, id, boardhead , CHECK_CNT, rownum rnum, reg_date "
					+ " from( select no, title , id, boardhead, CHECK_CNT, reg_date "
					+ " from t_notice_class_board "
					+ "   where "+ type +" like ? "
					+ " order by reg_date desc)) "
					+ "  where rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+ search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getString("no"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("id"));
				board.setBoardhead(rs.getString("boardhead"));
				board.setRegDate(rs.getString("reg_date"));
				board.setCheckCnt(rs.getString("check_Cnt"));
				list.add(board);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return list;
	}

	
	
	
	

	public void updateCheckCnt(String no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " update t_notice_class_board set check_Cnt = check_Cnt+1 "
					+ 	 " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
}


/*
 create table t_notice_class_board(
id varchar2(20),
no number  primary key,
boardhead varchar2(20),
title varchar2(50),
content varchar2(300),
reg_date DATE default sysdate,
check_cnt number default 0,
scope varchar2(10)
)
 */

// create table seq_t_notice_class_board_no

