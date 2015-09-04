package kr.co.mlec.notice.ourclassboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import kr.co.mlec.notice.ourclassboard.vo.BoardVO;
import kr.co.mlec.util.ConnectionPool;

public class BoardDAO {
	public void insertBoard(BoardVO board) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = " insert into t_notice_bitcamp_board(no, id, title, boardhead, content) "
					   + " values(seq_t_notice_bitcamp_board_no.nextVal, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			
			int index = 1;
			pstmt.setString(index++, board.getId());
			pstmt.setString(index++, board.getTitle());
			pstmt.setString(index++, board.getBoardhead());
			pstmt.setString(index++, board.getContent());
			pstmt.executeUpdate();
			
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
			String sql = " select no, title, id, boardhead, to_char(reg_date, 'yyyy-mm-dd') as regDate "
					+ "	  from t_notice_bitcamp_board "
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
				String sql = " select no, title, id, boardhead, content, to_char(reg_date, 'yyyy-mm-dd') as regDate "
						  + "  from t_notice_bitcamp_board "
						  + "  where no = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, no);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					board.setNo(rs.getString("no"));
					board.setTitle(rs.getString("title"));
					board.setId(rs.getString("id"));
					board.setBoardhead(rs.getString("boardhead"));
					board.setContent(rs.getString("content"));
					board.setRegDate(rs.getString("regDate"));
//					board.setCheckCnt(rs.getString("checkCnt"));
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
			String sql = " delete from t_notice_bitcamp_board where no=? ";
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
				String sql = " update t_notice_bitcamp_board "
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

	public List<BoardVO> searchBoard(String type, String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = " select no, title, id, boardhead, to_char(reg_date, 'yyyy-mm-dd') as regDate "
					+ "	  from t_notice_bitcamp_board "
					+ "   where "+ type +" like ? "
					+ "   order by no desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+ search + "%");
			
			
			
			ResultSet rs= pstmt.executeQuery();
			
			List<BoardVO> list= new ArrayList<>();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getString("no"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("id"));
				board.setBoardhead(rs.getString("boardhead"));
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
	
	public void updateCheckCnt(int seq_t_notice_bitcamp_board_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update t_notice_bitcamp_board set checkCnt = nvl(checkCnt,0) + 1 where seq = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
//	public BoardVO pageBoard() throws Exception {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			con = ConnectionPool.getConnection();
//			String sql = " select * from(select rownum as rnum, a.* from board a order by seq) "
//					+ " where rnum between ? and ?";
//			pstmt = con.prepareStatement(sql);
//			
//			ResultSet rs= pstmt.executeQuery();
//			
//			List<BoardVO> list= new ArrayList<>();
//			while(rs.next()) {
//				BoardVO board = new BoardVO();
//				board.setNo(rs.getString("no"));
//				board.setTitle(rs.getString("title"));
//				board.setId(rs.getString("id"));
//				board.setBoardhead(rs.getString("boardhead"));
//				board.setRegDate(rs.getString("regDate"));
//				list.add(board);
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally{
//			if(pstmt != null) {
//				pstmt.close();
//			}
//			ConnectionPool.close(con);
//		}
//		return null;
//		
//	}
	
}