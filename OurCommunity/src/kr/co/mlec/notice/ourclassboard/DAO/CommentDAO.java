package kr.co.mlec.notice.ourclassboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.notice.ourclassboard.vo.CommentVO;
import kr.co.mlec.util.ConnectionPool;

public class CommentDAO {
	public void insertComment(CommentVO comment) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ConnectionPool.getConnection();
			String sql = " insert into t_notice_class_comment(comment_no, no, id, content) "
						+ " values(seq_t_notice_class_comment_no.nextVal, ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, comment.getNo());
			pstmt.setString(index++, comment.getId());
			pstmt.setString(index++, comment.getContent());
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
	public List<CommentVO> selectComment(String no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ConnectionPool.getConnection();
			String sql =" select comment_no ,no, id, content, to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate "
					+ " from t_notice_class_comment "
					+ " where no = ? "
					+ "	order by comment_no desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<CommentVO> list = new ArrayList<>();
			while(rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setCommentNo(rs.getString("comment_no"));
				comment.setId(rs.getString("id"));
				comment.setContent(rs.getString("content"));
				comment.setRegDate(rs.getString("regDate"));
				list.add(comment);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		} 
	}
	
	public void deleteComment(CommentVO comment) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ConnectionPool.getConnection();
			String sql = " delete t_notice_class_comment "
					   + " where comment_no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comment.getCommentNo());
			pstmt.executeUpdate();
			
					
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
}
/*
create table t_notice_class_comment(
id varchar2(20),
no number,
comment_no number,
content varchar(300),
reg_date DATE default sysdate
)
 */



//create sequence seq_t_notice_class_comment_no