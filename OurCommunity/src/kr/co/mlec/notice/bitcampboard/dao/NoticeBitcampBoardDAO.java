package kr.co.mlec.notice.bitcampboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;
import kr.co.mlec.util.ConnectionPool;

public class NoticeBitcampBoardDAO {

	public List<NoticeBitcampBoardVO> selectBitcampBoard(int start, int end) throws Exception{
		List<NoticeBitcampBoardVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ " from (select no, title, id, boardhead , CHECK_CNT, rownum rnum, reg_date "
					+ " from( select no, title , id, boardhead, CHECK_CNT, reg_date "
					+ " from t_notice_bitcamp_board "
					+ " order by reg_date desc)) "
					+ "  where rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
				board.setId(rs.getString("id"));
				board.setNo(rs.getString("no"));
				board.setBoardHead(rs.getString("boardhead"));
				board.setTitle(rs.getString("title"));
				board.setRegDate(rs.getString("reg_date"));
				board.setCheckCnt(rs.getString("CHECK_CNT"));
				list.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return list;
	}

	public void insertBitcampBoard(NoticeBitcampBoardVO board) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_notice_bitcamp_board (no, id, boardhead, title, content, check_cnt, scope) "
					+ " values(seq_t_notice_bitcamp_board_no.nextVal, ?, ?, ?, ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			int index=1;
			pstmt.setString(index++, board.getId());
			pstmt.setString(index++, board.getBoardHead());
			pstmt.setString(index++, board.getTitle());
			pstmt.setString(index++, board.getContent());
			pstmt.setString(index++, "1");
			pstmt.setString(index++, board.getScope());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
	}

	public NoticeBitcampBoardVO selectBitcampBoard(String boardNo) throws Exception {
		NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, title, no, boardhead, content, scope, check_cnt, "
					+ " to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate "
					+ " from t_notice_bitcamp_board "
					+ " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setId(rs.getString("id"));
				board.setTitle(rs.getString("title"));
				board.setNo(rs.getString("no"));
				board.setBoardHead(rs.getString("boardhead"));
				board.setContent(rs.getString("content"));
				board.setScope(rs.getString("scope"));
				board.setCheckCnt(rs.getString("check_cnt"));
				board.setRegDate(rs.getString("regDate"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		
		return board;
	}
	
	public void deleteBitcampBoard(String boardNo) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "delete from t_notice_bitcamp_board "
					+ " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
	}

	public void checkUpBitcampBoard(String boardNo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update t_notice_bitcamp_board "
					+ " set CHECK_CNT = (CHECK_CNT+1) "
					+ " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
	}


	public List<NoticeBitcampBoardVO> selectBitcampBoardTitle(int start, int end, String title) throws Exception{
		List<NoticeBitcampBoardVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ " from (select no, title, id, boardhead , CHECK_CNT, rownum rnum, reg_date "
					+ " from( select no, title , id, boardhead, CHECK_CNT, reg_date "
					+ " from t_notice_bitcamp_board "
					+ " order by reg_date desc)) "
					+ " where title like ? "
					+ "   and rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
				board.setId(rs.getString("id"));
				board.setNo(rs.getString("no"));
				board.setBoardHead(rs.getString("boardhead"));
				board.setTitle(rs.getString("title"));
				board.setRegDate(rs.getString("reg_date"));
				board.setCheckCnt(rs.getString("CHECK_CNT"));
				list.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return list;
	}
	
	public List<NoticeBitcampBoardVO> selectBitcampBoardContent(int start, int end, String content) throws Exception{
		List<NoticeBitcampBoardVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date, CONTENT "
					+ " from (select no, title, id, boardhead , CHECK_CNT, rownum rnum, reg_date, CONTENT "
					+ " from( select no, title , id, boardhead, CHECK_CNT, reg_date, CONTENT "
					+ " from t_notice_bitcamp_board "
					+ " order by reg_date desc)) "
					+ " where content like ? "
					+ "   and rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
				board.setId(rs.getString("id"));
				board.setNo(rs.getString("no"));
				board.setBoardHead(rs.getString("boardhead"));
				board.setTitle(rs.getString("title"));
				board.setRegDate(rs.getString("reg_date"));
				board.setCheckCnt(rs.getString("CHECK_CNT"));
				list.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return list;
	}
	
	public List<NoticeBitcampBoardVO> selectBitcampBoardId(int start, int end, String id) throws Exception{
		List<NoticeBitcampBoardVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ " from (select no, title, id, boardhead , CHECK_CNT, rownum rnum, reg_date "
					+ " from( select no, title , id, boardhead, CHECK_CNT, reg_date "
					+ " from t_notice_bitcamp_board "
					+ " order by reg_date desc)) "
					+ " where id like ? "
					+ "   and rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+id+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
				board.setId(rs.getString("id"));
				board.setNo(rs.getString("no"));
				board.setBoardHead(rs.getString("boardhead"));
				board.setTitle(rs.getString("title"));
				board.setRegDate(rs.getString("reg_date"));
				board.setCheckCnt(rs.getString("CHECK_CNT"));
				list.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return list;
	}
	
	public int selectBitcampBoardTitle(String title) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ "from t_notice_bitcamp_board "
					+ " where title like ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return cnt;
	}
	
	public int selectBitcampBoardContent(String content) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ "from t_notice_bitcamp_board "
					+ " where content like ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return cnt;
	}
	
	public int selectBitcampBoardId(String id) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ "from t_notice_bitcamp_board "
					+ " where id like ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+id+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return cnt;
	}
	

	public int selectBitcampBoard() throws Exception {
		Connection con = null;
		int cnt = 0;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, boardhead, CHECK_CNT, reg_date "
					+ "from t_notice_bitcamp_board ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return cnt;
	}

	public void upadateBitcampBoard(NoticeBitcampBoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update t_notice_bitcamp_board " 
						+ " set title = ?, content = ?, boardhead = ?, scope = ? "
						+ " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getBoardHead());
			pstmt.setString(4, board.getScope());
			pstmt.setString(5, board.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ConnectionPool.close(con);
		}
		
	}
	
	public ArrayList<NoticeBitcampBoardVO> selectMainList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<NoticeBitcampBoardVO> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			String sql = " select * " 
			+ " from ( select no, title, rownum rnum "
			+ " from ( select no, title "
			+ " from t_notice_bitcamp_board " 
			+ " order by no desc )) " 
			+ " where rnum between 1 and 5";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
				board.setNo(rs.getString("no"));
				board.setTitle(rs.getString("title"));
				list.add(board);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return list;
	}
}


/* 비트캠프 공지사항 테이블
	create table t_notice_bitcamp_board(
	id varchar2(20) not null,
	no number primary key not null,
	boardhead varchar2(30) not null,
	title varchar2(50) not null,
	content varchar2(300) not null,
	reg_date date default sysdate,
	scope varchar2(20) not null,
	check_cnt number not null);
	
	
	create sequence t_notice_bitcamp_board_no;
*/