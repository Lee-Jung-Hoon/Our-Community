package kr.co.mlec.notice.bitcampboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampCommentVO;
import kr.co.mlec.util.ConnectionPool;

public class NoticeBitcampCommentDAO {

	public static void insertNoticeBitcampComment(NoticeBitcampCommentVO comment) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_notice_bitcamp_comment(comment_no, id, no, content) "
					+ " values(seq_t_notice_bit_comment_no.nextVal, ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			int index=1;
			pstmt.setString(index++, comment.getId());
			pstmt.setString(index++, comment.getNo());
			pstmt.setString(index++, comment.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}		
	}

	public List<NoticeBitcampCommentVO> selectNoticeBitcampComment(String boardNo) throws Exception{
		List<NoticeBitcampCommentVO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, content, comment_no, no, "
					+ " to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate "
					+ " from T_NOTICE_BITCAMP_COMMENT "
					+ " where no = ? "
					+ " order by regDate asc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeBitcampCommentVO commentVO = new NoticeBitcampCommentVO();
				commentVO.setId(rs.getString("id"));
				commentVO.setContent(rs.getString("content"));
				commentVO.setRegDate(rs.getString("regDate"));
				commentVO.setCommentNo(rs.getString("comment_no"));
				commentVO.setNo(rs.getString("no"));
				list.add(commentVO);
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

	public void deleteBitcampComment(String no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "delete from t_notice_bitcamp_comment "
					+ " where comment_no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
	}

	
/*
create table t_notice_bitcamp_comment(
id varchar2(20) not null,
no number not null,
comment_no number primary key not null,
content varchar2(300) not null,
reg_date date default sysdate);



create sequence seq_t_notice_bit_comment_no;
 */
}
