package kr.co.mlec.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.community.vo.AnonymityCommentVO;
import kr.co.mlec.community.vo.AnonymityVO;
import kr.co.mlec.util.ConnectionPool;

public class AnonymityDAO {
	public void insertAnonymityBoard(AnonymityVO anonymity) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " insert into t_anonymity_board(no, title, id, content, scope) "
					+ " values(seq_t_anonymity_board_no.nextVal, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, anonymity.getTitle());
			pstmt.setString(index++, anonymity.getId());
			pstmt.setString(index++, anonymity.getContent());
			pstmt.setString(index++, anonymity.getScope());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public void updateAnonymity(AnonymityVO anonymity) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " update t_anonymity_board set "
					   + " title = ?,  content = ? "
					   + " where no = ?";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, anonymity.getTitle());
			pstmt.setString(index++, anonymity.getContent());
			pstmt.setInt(index++, anonymity.getNo());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public void insertComment(AnonymityCommentVO comment) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " insert into t_anonymity_comment(comment_no, no, id, content) "
					   + " values(seq_t_anonymity_comment_no.nextVal, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, comment.getNo());
			pstmt.setString(index++, comment.getId());
			pstmt.setString(index++, comment.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public void deleteAnonymity(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " delete from t_anonymity_board "
					+ " where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public void deleteComment(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " delete from t_anonymity_Comment "
					+ " where comment_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public int selectListCount() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select count(no)as count from t_anonymity_board";
			pstmt = con.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			if(result.next()){
				count = result.getInt("count");
			}
			return count;
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public int selectSearchListCount(String type, String text) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select count(no)as count from t_anonymity_board"
					   + " where "+type+" like ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+text+"%");
			ResultSet result = pstmt.executeQuery();
			if(result.next()){
				count = result.getInt("count");
			}
			return count;
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public List<AnonymityVO> selectAnonymityBoard(int startNum, int endNum) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select * "
					   + " from(select no, title, id, regDate, scope, check_cnt, rownum rnum "
					   + " from (select no, title, id, to_char(reg_date, 'yyyy-mm-dd') as regDate, scope, check_cnt "
					   + "   from t_anonymity_board"
					   + "  order by no desc))"
					   + " where rnum between ? and ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			ResultSet rs = pstmt.executeQuery();

			List<AnonymityVO> list = new ArrayList<>();
			while (rs.next()) {
				AnonymityVO anonymity = new AnonymityVO();
				anonymity.setNo(rs.getInt("no"));
				anonymity.setTitle(rs.getString("title"));
				anonymity.setId(rs.getString("id"));
				anonymity.setRegDate(rs.getString("regDate"));
				anonymity.setScope(rs.getString("scope"));
				anonymity.setCheckCnt(rs.getString("check_cnt"));
				list.add(anonymity);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public List<AnonymityCommentVO> selectComment(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " select no, comment_no, id, content,to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate "
					+ "   from t_anonymity_comment"
					+ "  where no = ? "
					+ "  order by comment_no";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			List<AnonymityCommentVO> list = new ArrayList<>();
			while (rs.next()) {
				AnonymityCommentVO comment = new AnonymityCommentVO();
				comment.setNo(rs.getInt("no"));
				comment.setCommentNo(rs.getInt("comment_no"));
				comment.setId(rs.getString("id"));
				comment.setContent(rs.getString("content"));
				comment.setRegDate(rs.getString("regDate"));
				list.add(comment);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public AnonymityVO selectDetail(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " select no, title, id, content, to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate, check_cnt "
					+ "   from t_anonymity_board "
					+ "  where no = ? " ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				AnonymityVO anonymity = new AnonymityVO();
				anonymity.setNo(rs.getInt("no"));
				anonymity.setTitle(rs.getString("title"));
				anonymity.setId(rs.getString("id"));
				anonymity.setContent(rs.getString("content"));
				anonymity.setRegDate(rs.getString("regDate"));
				anonymity.setCheckCnt(rs.getString("check_cnt"));
				return anonymity;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public void updateCheckCnt(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " update t_anonymity_board set "
					   + " check_cnt= check_cnt+1"
					   + " where no = ?";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	public List<AnonymityVO> searchAnonymityBoard(String type, String text, int startNum, int endNum) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " select * "
					   + " from(select no, title, id, regDate, scope, check_cnt, rownum rnum "
					   + "  from(select no, title, id, to_char(reg_date, 'yyyy-mm-dd') as regDate, scope, check_cnt "
					   + "   from t_anonymity_board"
					   + "  where "+type+" like ? " 
					   + "  order by no desc))"
					   + " where rnum between ? and ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+text+"%");
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			ResultSet rs = pstmt.executeQuery();
			
			List<AnonymityVO> list = new ArrayList<>();
			while (rs.next()) {
				AnonymityVO anonymity = new AnonymityVO();
				anonymity.setNo(rs.getInt("no"));
				anonymity.setId(rs.getString("id"));
				anonymity.setTitle(rs.getString("title"));
				anonymity.setRegDate(rs.getString("regDate"));
				anonymity.setScope(rs.getString("scope"));
				anonymity.setCheckCnt(rs.getString("check_cnt"));
				list.add(anonymity);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
}
