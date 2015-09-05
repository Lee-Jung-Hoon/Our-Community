package kr.co.mlec.community.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.mlec.community.gallery.vo.GalleryVO;
import kr.co.mlec.util.ConnectionPool;

public class GallerySearchDAO {

	
	public ArrayList<GalleryVO> selectSearchAll(int pageNum, String search) throws Exception {
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
					+ "              from t_community_gallery_board where title like ? or content like ? ) " + "   order by day desc)) "
					+ " where rnum  between ? and ? ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++,  "%"+search+"%");
			pstmt.setString(index++,  "%"+search+"%");
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

	public ArrayList<GalleryVO> selectSearchTitle(int pageNum, String search) throws Exception{
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
					+ "              from t_community_gallery_board where title like ? ) " + "   order by day desc)) "
					+ " where rnum between ? and ? "
					+ "  ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, (pageNum-9));
			pstmt.setInt(index++,  pageNum);
			pstmt.setString(index++,  "%"+search+"%");

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

	public ArrayList<GalleryVO> selectSearchContent(int pageNum, String search) throws Exception {
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
					+ "              from t_community_gallery_board where content like ? ) " + "   order by day desc)) "
					+ " where rnum between ? and ? "
					+ "  ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, (pageNum-9));
			pstmt.setInt(index++,  pageNum);
			pstmt.setString(index++,  "%"+search+"%");

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

	public ArrayList<GalleryVO> selectSearchId(int pageNum, String search) throws Exception {
		ArrayList<GalleryVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		
		pageNum *= 10;
		
		
		try {

			con = ConnectionPool.getConnection();

			String sql = "select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path, rownum rnum "
					+" from(select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path, rownum rnum "
					+" from(select id, no, title, content, day, check_cnt, scope, file_name, origin_file_name, file_path "
				    +" from ( select id, no, title, content, to_char( reg_date, 'yymmdd HH24:mi:ss')as day, check_cnt, scope, file_name, origin_file_name, file_path "
					 +"            from t_community_gallery_board  where id like ? )   order by day desc)) "
					 +" where rnum  between ? and ? "
					 +"  ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++,  "%"+search+"%");
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

	

	public int selectPageSearchId(String search) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where id like ? ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			
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

	public int selectPageSearchAll(String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where title like ? or content like ? ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			pstmt.setString(index++, "%"+search+"%");
			
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

	public int selectPageSearchTitle(String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where title like ? ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			
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

	public int selectPageSearchContent(String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where content like ? ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			
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

	public ArrayList<GalleryVO> selectNUSearchAll(int pageNum, String search)throws Exception {
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
					+ "              from t_community_gallery_board where (content like ? or title like ?) and scope = 0 ) " + "   order by day desc)) "
					+ " where rnum between ? and ? "
					+ "  ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++,  "%"+search+"%");
			pstmt.setString(index++,  "%"+search+"%");
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

	public int selectNUPageSearchAll(String search)throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where ( title like ? or content like ? ) "
               + " and scope = 0 ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			pstmt.setString(index++, "%"+search+"%");
			
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

	
	
	
	
	
	
	public ArrayList<GalleryVO> selectNUSearchTitle(int pageNum, String search)throws Exception {
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
					+ "              from t_community_gallery_board where title like ? and scope = 0 ) " + "   order by day desc)) "
					+ " where rnum between ? and ? "
					+ "  ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++,  "%"+search+"%");
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

	public int selectUNPageSearchTitle(String search)throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where title like ?"
               + "	and scope = 0 ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			
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

	public ArrayList<GalleryVO> selectNUSearchContent(int pageNum, String search)throws Exception {
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
					+ "              from t_community_gallery_board where content like ? and scope = 0 ) " + "   order by day desc)) "
					+ " where rnum between ? and ? "
					+ "  ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++,  "%"+search+"%");
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

	public int selectNUPageSearchContent(String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where content like ? "
               + " and scope = 0 ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			
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

	public ArrayList<GalleryVO> selectNUSearchId(int pageNum, String search) throws Exception{
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
					+ "              from t_community_gallery_board where id like ? and scope = 0 ) " + "   order by day desc)) "
					+ " where rnum between ? and ? "
					+ "  ";
			// String sql = " select id, no, title, content,
			// to_char(reg_date,'yyyy-mm-dd') as day, "
			// + " check_cnt, scope, file_name, origin_file_name, file_path "
			// + " from t_community_gallery_board "
			// + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++,  "%"+search+"%");
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

	public int selectNUPageSearchId(String search) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int size =0;
		try {

			con = ConnectionPool.getConnection();

			String sql = " select count(*) as cnt "
               +" from t_community_gallery_board"
               + " where id like ? "
               + " and scope = 0 ";
	
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			
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
