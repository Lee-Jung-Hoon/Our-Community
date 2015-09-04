package kr.co.mlec.community.gallery.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import kr.co.mlec.community.gallery.comment.vo.GallCommentCntVO;
import kr.co.mlec.community.gallery.comment.vo.GallCommentVO;
import kr.co.mlec.util.ConnectionPool;

public class GallCommentDAO {

	public void insertComment(GallCommentVO vo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " insert into t_community_gallery_comment( "
					+ "				id, comment_no, comment_content, board_no )  "
					+ "		values( ? , s_community_Gallery_comment.nextVal , ? , ? ) ";

			System.out.println(vo.getId());
			System.out.println(vo.getCommentContent());
			System.out.println(vo.getBoardNo());

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, vo.getId());
			pstmt.setString(index++, vo.getCommentContent());
			pstmt.setInt(index++, vo.getBoardNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}

	}

	public ArrayList<GallCommentVO> selectComment(GallCommentVO vo) throws Exception {
		ArrayList<GallCommentVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " select id, comment_no, comment_content, board_no , "
					+ " to_char(comment_reg_date, 'yyyy-mm-dd HH24:mi:ss' )as day  "
					+ "		from t_community_gallery_comment " + "		where board_no = ? "
					+ "		order by comment_no desc ";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, vo.getBoardNo());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				GallCommentVO gVO = new GallCommentVO();
				gVO.setBoardNo(rs.getInt("board_no"));
				gVO.setCommentContent(rs.getString("comment_content"));
				gVO.setCommentRegDate(rs.getString("day"));
				gVO.setCommentNo(rs.getInt("comment_no"));
				gVO.setId(rs.getString("id"));

				list.add(gVO);
			}

		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}

		return list;
	}

	public ArrayList<GallCommentCntVO> selectCommentCnt() throws Exception {
		ArrayList<GallCommentCntVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " SELECT board_no, COUNT(board_no) "
						+" FROM t_community_gallery_comment "
						+" GROUP BY board_no ";

			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				GallCommentCntVO vo = new GallCommentCntVO();

					
					vo.setBoardNO(rs.getInt("board_no"));
					vo.setCommentCnt(rs.getInt("COUNT(board_no)"));

					list.add(vo);
			}

		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
		
		
		
		

		return list;
	}

	public GallCommentCntVO selectCommentNoCnt(GallCommentVO cVO) throws Exception {
		
		GallCommentCntVO cntVO = new GallCommentCntVO();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " SELECT COUNT(board_no) "
						+" FROM t_community_gallery_comment "
						+" where board_no = ? "
						+" GROUP BY board_no ";

			pstmt = con.prepareStatement(sql);

			int index = 1; 
			
			pstmt.setInt(index++, cVO.getBoardNo());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				
				cntVO.setCommentCnt(rs.getInt("COUNT(board_no)"));
			}

		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
		return cntVO;
	}

	public void deleteVO(GallCommentVO vo) throws Exception{

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " delete t_community_gallery_comment " + "		where board_no = ?  and comment_no = ? ";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, vo.getBoardNo());
			pstmt.setInt(index++, vo.getCommentNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
		
		
	}

}
