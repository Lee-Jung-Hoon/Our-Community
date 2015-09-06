package kr.co.mlec.community.studyFile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.community.studyFile.vo.StudyFileCommentVO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampCommentVO;
import kr.co.mlec.util.ConnectionPool;

public class StudyFileCommentDAO {

	public void insertComment(StudyFileCommentVO commentVo) throws Exception{
		System.out.println(commentVo.getId());
		System.out.println(commentVo.getNo());
		System.out.println(commentVo.getCommentNo());
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_community_studyFile_comment(comment_no, id, no, content) "
					+ " values(seq_studyFile_comment_no.nextVal, ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			int index=1;
			pstmt.setString(index++, commentVo.getId());
			pstmt.setInt(index++, commentVo.getNo());
			pstmt.setString(index++, commentVo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}		
	}
	
	public List<StudyFileCommentVO>selectStudyFileComment(int no) throws Exception{
		List<StudyFileCommentVO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, content, comment_no, no, "
					+ " to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate "
					+ " from t_community_studyFile_comment"
					+ " where no = ? "
					+ " order by regDate asc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyFileCommentVO commentVo = new StudyFileCommentVO();
				commentVo.setId(rs.getString("id"));
				commentVo.setContent(rs.getString("content"));
				commentVo.setRegDate(rs.getString("regDate"));
				commentVo.setCommentNo(rs.getInt("comment_no"));
				commentVo.setNo(rs.getInt("no"));
				list.add(commentVo);
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

	public void deleteComment(int commentNo) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "delete from t_community_studyFile_comment "
					+ " where comment_no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
	}
}

/*
create table t_community_studyFile_comment(
	id varchar2(20) not null,
	no number not null,
	comment_no number primary key not null,
	content varchar2(300) not null,
	reg_date date default sysdate
);

create sequence seq_studyFile_comment_no;
*/