package kr.co.mlec.contents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.mlec.contents.vo.MenuCommentVO;
import kr.co.mlec.contents.vo.RecommendMenuVO;
import kr.co.mlec.mypage.dao.MemberHistoryDAO;
import kr.co.mlec.util.ConnectionPool;

public class RecommendMenuDAO {
	public void insertRecommendMenu(RecommendMenuVO menu) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into recommend_menu (num, id, restaurant_name, title, content, latitude, longitude )"
					+ " values(seq_recommend_menu_num.nextVal, ?, ?, ?, ?, ?, ? )   ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, menu.getId());
			pstmt.setString(index++, menu.getRestaurantName());
			pstmt.setString(index++, menu.getTitle());
			pstmt.setString(index++, menu.getContent());
			pstmt.setString(index++, menu.getLatitude());
			pstmt.setString(index++, menu.getLongitude());
			pstmt.executeUpdate();
			
			String num = null;
			sql = " select seq_recommend_menu_num.currVal "
					+ " from dual";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				num = rs.getString("currVal");
			}

			MemberHistoryDAO dao = new MemberHistoryDAO();
			dao.insertMemberHistory(menu.getId(),  menu.getTitle(), "맛집추천", num);
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}

	public ArrayList<RecommendMenuVO> selectListMenu(int startNum, int endNum) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<RecommendMenuVO> list = new ArrayList<>();
		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select * "
					+ " from ( select num, title, id, reg_date, count, rownum rnum "
					+ " from ( select num, title, id, reg_date, count "
					+ " from recommend_menu "
					+ " order by num desc ) ) "
					+ " where rnum between ? and ?";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, startNum);
			pstmt.setInt(index++, endNum);
			ResultSet r = pstmt.executeQuery();
			while (r.next()) {
				RecommendMenuVO menu = new RecommendMenuVO();
				menu.setNum(r.getInt("num"));
				menu.setTitle(r.getString("title"));
				menu.setId(r.getString("id"));
				menu.setRegDate(r.getString("reg_date"));
				menu.setCount(r.getInt("count"));
				list.add(menu);
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
	
	public ArrayList<RecommendMenuVO> selectListSearchMenu(int startNum, int endNum, String search, String type) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<RecommendMenuVO> list = new ArrayList<>();
		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select * "
					+ " from ( select num, title, id, reg_date, count, rownum rnum "
					+ " from ( select num, title, id, reg_date, count "
					+ " from recommend_menu "
					+ " where " + type + " like ?"
					+ " order by num desc) ) "
					+ " where rnum between ? and ?";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, "%"+search+"%");
			pstmt.setInt(index++, startNum);
			pstmt.setInt(index++, endNum);
			ResultSet r = pstmt.executeQuery();
			while (r.next()) {
				RecommendMenuVO menu = new RecommendMenuVO();
				menu.setNum(r.getInt("num"));
				menu.setTitle(r.getString("title"));
				menu.setId(r.getString("id"));
				menu.setRegDate(r.getString("reg_date"));
				menu.setCount(r.getInt("count"));
				list.add(menu);
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

	
	public RecommendMenuVO selectDetailMenu(int num) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		RecommendMenuVO menu = new RecommendMenuVO();
		try {
			con = ConnectionPool.getConnection();
			String sql = "select restaurant_name, title, to_char(reg_date, 'yyyy.mm.dd hh24:mi') as regDate, id, content, latitude, longitude "
					+ " from recommend_menu "
					+ " where num = ? " ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet r = pstmt.executeQuery();
			if(r.next()){
				menu.setNum(num);
				menu.setRestaurantName(r.getString("restaurant_name"));
				menu.setTitle(r.getString("title"));
				menu.setRegDate(r.getString("regDate"));
				menu.setId(r.getString("id"));
				menu.setContent(r.getString("content"));
				menu.setLatitude(r.getString("latitude"));
				menu.setLongitude(r.getString("longitude"));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return menu;
	}

	public void updateCount(int num) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update recommend_menu"
					+ " set count = count + 1 "
					+ " where num = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}

	public void insertComment(MenuCommentVO comment) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into recommend_menu_comment ( no, num, id, menu_comment )"
					+ " values (  seq_recommend_menu_comment_no.nextVal, ?, ?, ? )";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setInt(index++, comment.getNum());
			pstmt.setString(index++, comment.getId());
			pstmt.setString(index++, comment.getMenuComment());
			pstmt.executeUpdate();
		} catch (Exception e) {
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
			String sql = "delete recommend_menu_comment "
					+ " where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public ArrayList<MenuCommentVO> selectComment(int num) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<MenuCommentVO> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			String sql = "select no, num, id, menu_comment, to_char(comment_date, 'yyyy/mm/dd') as commentDate "
					+ " from recommend_menu_comment "
					+ " where num = ? "
					+ " order by no";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet r = pstmt.executeQuery();
			while(r.next()){
				MenuCommentVO comment = new MenuCommentVO();
				comment.setNo(r.getInt("no"));
				comment.setNum(r.getInt("num"));
				comment.setId(r.getString("id"));
				comment.setMenuComment(r.getString("menu_comment"));
				comment.setCommentDate(r.getString("commentDate"));
				list.add(comment);
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

	public void deleteMenu(int num) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "delete recommend_menu "
					+ " where num = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public void deleteCommentAll(int num) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "delete recommend_menu_comment "
					+ " where num = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}
	
	public void updateMenu(RecommendMenuVO menu) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update recommend_menu "
					+ " set title = ? , content = ? "
					+ " where num = ? ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, menu.getTitle());
			pstmt.setString(index++, menu.getContent());
			pstmt.setInt(index++, menu.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
	}

	public int selectListCount() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select count(num)as count "
					+ "from recommend_menu ";
			pstmt = con.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();
			if(r.next()){
				count =  r.getInt("count");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return count;
	}
	
	public int selectSearchListCount(String type, String search) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select count(num)as count "
					+ "from recommend_menu "
					+ " where " + type + " like ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			ResultSet r = pstmt.executeQuery();
			if(r.next()){
				count =  r.getInt("count");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return count;
	}
}
