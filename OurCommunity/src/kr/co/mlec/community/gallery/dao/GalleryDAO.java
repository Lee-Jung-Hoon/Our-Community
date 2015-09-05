package kr.co.mlec.community.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.mlec.community.gallery.vo.GalleryVO;
import kr.co.mlec.util.ConnectionPool;

public class GalleryDAO {

	public void insertVO(GalleryVO vo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " insert into t_community_gallery_board ( " + "		no, id, title, content,  "
					+ "		scope, file_name, origin_file_name, file_path ) "
					+ "		values( s_community_Gallery_board.nextVal , ? , ? , ? , ? , "
					+ "				? , ? , ?  ) ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, vo.getId());
			pstmt.setString(index++, vo.getTitle());
			pstmt.setString(index++, vo.getContent());
			pstmt.setInt(index++, vo.getScope());
			pstmt.setString(index++, vo.getFileName());
			pstmt.setString(index++, vo.getOriginFileName());
			pstmt.setString(index++, vo.getFilePath());

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

	public ArrayList<GalleryVO> selectVO(int pageNum) throws Exception {
		ArrayList<GalleryVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		
		pageNum *= 10;
		
		
		
		try {

			con = ConnectionPool.getConnection();

			String sql = " select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path , rownum rnum "
					+ " from(select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path, rownum rnum "
					+ " from(select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path"
					+ "      from ( select id, no, title, content, to_char( reg_date, 'yymmdd HH24:mi:ss')as day, check_cnt, scope, file_name, origin_file_name, file_path "
					+ "              from t_community_gallery_board ) " + "   order by day desc)) "
					+ " where rnum between ? and ? ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, (pageNum-9));
			pstmt.setInt(index++,  pageNum);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				GalleryVO vo = new GalleryVO();

				vo.setId(rs.getString("id"));
				vo.setCheckCnt(rs.getInt("check_cnt"));
				vo.setContent(rs.getString("content"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFilePath(rs.getString("file_path"));

				vo.setNo(rs.getInt("no"));
				vo.setOriginFileName(rs.getString("origin_file_name"));
				vo.setRegDate(rs.getString("day"));
				vo.setScope(rs.getInt("scope"));
				vo.setTitle(rs.getString("title"));

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

	public GalleryVO selectNO(GalleryVO vo) throws Exception {

		int no = vo.getNo();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " select id, no, title, content, to_char(reg_date,'yyyy-mm-dd HH24:mi:ss') as day, "
					+ "				check_cnt, scope, file_name, origin_file_name, file_path  "
					+ "		from t_community_gallery_board " + "		where no = ? 	 ";
			pstmt = con.prepareStatement(sql);

			int index = 1;
			pstmt.setInt(index++, no);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setId(rs.getString("id"));
				vo.setCheckCnt(rs.getInt("check_cnt"));
				vo.setContent(rs.getString("content"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFilePath(rs.getString("file_path"));

				vo.setNo(rs.getInt("no"));
				vo.setOriginFileName(rs.getString("origin_file_name"));
				vo.setRegDate(rs.getString("day"));
				vo.setScope(rs.getInt("scope"));
				vo.setTitle(rs.getString("title"));

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

		return vo;
	}

	public GalleryVO insertChkCnt(GalleryVO vo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " update t_community_gallery_board  set check_cnt = nvl(check_cnt, 0) + 1 "
					+ "		where  no = ?  ";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, vo.getNo());

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

		return vo;
	}

	public void updateVO(GalleryVO vo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " update t_community_gallery_board " + "		set title 				= ? , "
					+ "			content				= ? , " + "			scope				= ? , "
					+ "			file_name			= ? , " + "			origin_file_name	= ? , "
					+ "			file_path 			= ? , " + "			reg_date			= sysdate "
					+ "		where  no = ?  ";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, vo.getTitle());
			pstmt.setString(index++, vo.getContent());
			pstmt.setInt(index++, vo.getScope());
			pstmt.setString(index++, vo.getFileName());
			pstmt.setString(index++, vo.getOriginFileName());
			pstmt.setString(index++, vo.getFilePath());
			pstmt.setInt(index++, vo.getNo());

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

	public void deleteVO(GalleryVO vo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionPool.getConnection();

			String sql = " delete t_community_gallery_board " + "		where  no = ?  ";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, vo.getNo());

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

	public int selectPage() throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board ";
	
			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

			 size = rs.getInt("cnt");

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
		
		int total = size/10;
		
		if( (size %10) != 0){
		
			total+=1;
		
		}
		
		return total;
	}

	public ArrayList<GalleryVO> selectNotUserVO(int pageNum) throws Exception{
		
		ArrayList<GalleryVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		
		pageNum *= 10;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path "
					+ " from(select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path, rownum rnum "
					+ " from(select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path"
					+ "      from ( select id, no, title, content, to_char( reg_date, 'yymmdd HH24:mi:ss')as day, check_cnt, scope, file_name, origin_file_name, file_path "
					+ "              from t_community_gallery_board ) " + "   order by day desc)) "
					+ "where rownum between ? and ? "
					+ " and scope = 0 ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, (pageNum-9));
			pstmt.setInt(index++,  pageNum);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				GalleryVO vo = new GalleryVO();

				vo.setId(rs.getString("id"));
				vo.setCheckCnt(rs.getInt("check_cnt"));
				vo.setContent(rs.getString("content"));
				vo.setFileName(rs.getString("file_name"));
				vo.setFilePath(rs.getString("file_path"));

				vo.setNo(rs.getInt("no"));
				vo.setOriginFileName(rs.getString("origin_file_name"));
				vo.setRegDate(rs.getString("day"));
				vo.setScope(rs.getInt("scope"));
				vo.setTitle(rs.getString("title"));

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

	public int selectPageNotUser() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board "
               + "	where scope = 0 ";
	
			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

			 size = rs.getInt("cnt");

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
		
		int total = size/10;
		
		if( (size %10) != 0){
		
			total+=1;
		
		}
		
		return total;
	}

	

}
