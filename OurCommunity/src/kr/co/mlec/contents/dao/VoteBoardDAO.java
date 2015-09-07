package kr.co.mlec.contents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.contents.vo.VoteBoardVO;
import kr.co.mlec.contents.vo.VoteItemsVO;
import kr.co.mlec.util.ConnectionPool;

public class VoteBoardDAO {
	String num = "";
	public void insertVote(VoteBoardVO vote) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select seq_t_board.nextval as num from dual";
			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getString("num");
			}

			sql = "insert into t_vote_board(id, v_no, end_date, v_title, v_progress, v_clicks)"
						+ " values(?, ?, ?, ?, 0, 0)";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, vote.getId());
			pstmt.setString(index++, num);
			pstmt.setString(index++, vote.getEnd_date());
			pstmt.setString(index++, vote.getV_title());
			
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
	
	public void insertVoteItem(VoteItemsVO items) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();

			String sql = "insert into t_vote_items(v_no, subsection, count)"
						+ " values(?, ?, 0)";
			pstmt = con.prepareStatement(sql);
			
			int index = 1;
			pstmt.setString(index++, num);
			pstmt.setString(index++, items.getSubsection());
			
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

	public void updateVoteBoard(String v_no, String end_date, String v_title) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();

			String sql = "update t_vote_board set end_date = ?, v_title = ? where v_no = ? ";
			pstmt = con.prepareStatement(sql);
			
			int index = 1;
			pstmt.setString(index++, end_date);
			pstmt.setString(index++, v_title);
			pstmt.setString(index++, v_no);
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

	public List<VoteBoardVO> selectList(int start , int end) throws Exception {
		List<VoteBoardVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
						+ " to_char(start_date,'yyyy-mm-dd') as startdate,"
						+ " to_char(end_date,'yyyy-mm-dd')as enddate"
						+ " from(select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
						+ " to_char(start_date,'yyyy-mm-dd') as startdate,"
						+ " to_char(end_date,'yyyy-mm-dd')as enddate, rownum as rnum "
					+ "from(select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
						+ " to_char(start_date,'yyyy-mm-dd') as startdate,"
						+ " to_char(end_date,'yyyy-mm-dd')as enddate "
					+ " from t_vote_board order by enddate desc)) where rnum between ? and ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.executeQuery();
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				VoteBoardVO vote = new VoteBoardVO();
				vote.setId(rs.getString("id"));
				vote.setV_no(rs.getString("v_no"));
				vote.setStart_date(rs.getString("startdate"));
				vote.setEnd_date(rs.getString("enddate"));
				vote.setV_title(rs.getString("v_title"));
				vote.setV_progress(rs.getString("v_progress"));
				vote.setV_clicks(rs.getString("v_clicks"));				
				list.add(vote);
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

	public List<VoteItemsVO> selectItems(String v_no) throws Exception {
		List<VoteItemsVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "select v_no, subsection, count " + " from t_vote_items " + " where v_no = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v_no);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				VoteItemsVO item = new VoteItemsVO();

				item.setV_no(rs.getString("v_no"));
				item.setSubsection(rs.getString("subsection"));
				item.setCount(rs.getString("count"));

				list.add(item);
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

	public VoteBoardVO selectDetail(String v_no) throws Exception {
		VoteBoardVO vote = new VoteBoardVO();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "select v_no, id, start_date, end_date, v_title, v_progress, v_clicks,  "
					+ "to_char(start_date,'yyyy-mm-dd') as startdate, to_char(end_date,'yyyy-mm-dd') as enddate "
					+ " from t_vote_board " + " where v_no = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, v_no);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vote.setV_no(rs.getString("v_no"));
				vote.setId(rs.getString("id"));
				vote.setStart_date(rs.getString("startdate"));
				vote.setEnd_date(rs.getString("enddate"));
				vote.setV_title(rs.getString("v_title"));
				vote.setV_progress(rs.getString("v_progress"));
				vote.setV_clicks(rs.getString("v_clicks"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return vote;
	
	}

	public void updateVote(VoteItemsVO item) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sum = "";

		try {
			con = ConnectionPool.getConnection();

			String sql = "update t_vote_items set count = (count+1) where v_no = ? and subsection = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, item.getV_no());
			pstmt.setString(2, item.getSubsection());
			pstmt.executeUpdate();
			
			sql = "select SUM(count) as sum_count from t_vote_items where v_no = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, item.getV_no());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				sum = rs.getString("sum_count");
				System.out.println("sum : " + sum);
			}
			
			sql = "update t_vote_board set v_progress = ? where v_no = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, sum);
			pstmt.setString(2, item.getV_no());
			pstmt.executeUpdate();			

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			ConnectionPool.close(con);
		}
		
	}

	public void insertClicks(String v_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();

			String sql = "update t_vote_board set v_clicks = (v_clicks+1) where v_no = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, v_no);
			pstmt.executeUpdate();

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			ConnectionPool.close(con);
		}
	}
	
	public void deleteVote(String v_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "delete t_vote_board where v_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v_no);
			pstmt.executeUpdate();

			sql = "delete t_vote_items where v_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v_no);
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

	public int selectPageNum() throws Exception{
		int cnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "select * " 
			+ " from t_vote_items ";

			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		
		return cnt;
	}
	
	public int selectLastVNo() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int no = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = " select max(v_no) as max "
						+ " from t_vote_board ";
			pstmt = con.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();
			if(r.next()) {
				no = r.getInt("max");
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return no;
	}

	public List<VoteBoardVO> selectClosingList(int start , int end) throws Exception {
		List<VoteBoardVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		

		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
					+ " to_char(start_date, 'yyyy-mm-dd') as startDate, to_char(end_date, 'yyyy-mm-dd') as endDate"
					+ " from ( select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
					+ " to_char(start_date, 'yyyy-mm-dd') as startDate, to_char(end_date, 'yyyy-mm-dd') as endDate, "
					+ " rownum rnum from ( select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
					+ " to_char(start_date, 'yyyy-mm-dd') as startDate, to_char(end_date, 'yyyy-mm-dd') as endDate "
					+ " from t_vote_board where sysdate > end_date order by end_date desc)) where rnum between ? and ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.executeQuery();
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				VoteBoardVO vote = new VoteBoardVO();
				vote.setId(rs.getString("id"));
				vote.setV_no(rs.getString("v_no"));
				vote.setStart_date(rs.getString("startdate"));
				vote.setEnd_date(rs.getString("enddate"));
				vote.setV_title(rs.getString("v_title"));
				vote.setV_progress(rs.getString("v_progress"));
				vote.setV_clicks(rs.getString("v_clicks"));				
				list.add(vote);
			}
			
			
			sql = "select if(id, v_no, start_date, end_date, v_title, v_progress, v_clicks,  to_char(start_date,'yyyy-mm-dd') as startdate, to_char(end_date,'yyyy-mm-dd')as enddate, sysdate > enddate)"
			+ "from(select if(id, v_no, start_date, end_date, v_title, v_progress, v_clicks,  to_char(start_date,'yyyy-mm-dd') as startdate, to_char(end_date,'yyyy-mm-dd')as enddate, sysdate>enddate, rownum as rnum"
			+ " )from(select if(id, v_no, start_date, end_date, v_title, v_progress, v_clicks, to_char(start_date,'yyyy-mm-dd') as startdate, to_char(end_date,'yyyy-mm-dd')as enddate, "
			+ " sysdate>enddate)from t_vote_board order by enddate desc)) where rnum between 1 and 20 ";
			
			
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

	public List<VoteBoardVO> selectOngoingList(int start , int end) throws Exception {
		List<VoteBoardVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		

		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
					+ " to_char(start_date, 'yyyy-mm-dd') as startDate, to_char(end_date, 'yyyy-mm-dd') as endDate"
					+ " from ( select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
					+ " to_char(start_date, 'yyyy-mm-dd') as startDate, to_char(end_date, 'yyyy-mm-dd') as endDate, "
					+ " rownum rnum from ( select id, v_no, start_date, end_date, v_title, v_progress, v_clicks, "
					+ " to_char(start_date, 'yyyy-mm-dd') as startDate, to_char(end_date, 'yyyy-mm-dd') as endDate "
					+ " from t_vote_board where sysdate < end_date order by end_date desc)) where rnum between ? and ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.executeQuery();
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				VoteBoardVO vote = new VoteBoardVO();
				vote.setId(rs.getString("id"));
				vote.setV_no(rs.getString("v_no"));
				vote.setStart_date(rs.getString("startdate"));
				vote.setEnd_date(rs.getString("enddate"));
				vote.setV_title(rs.getString("v_title"));
				vote.setV_progress(rs.getString("v_progress"));
				vote.setV_clicks(rs.getString("v_clicks"));				
				list.add(vote);
			}
			
			
			sql = "select if(id, v_no, start_date, end_date, v_title, v_progress, v_clicks,  to_char(start_date,'yyyy-mm-dd') as startdate, to_char(end_date,'yyyy-mm-dd')as enddate, sysdate > enddate)"
			+ "from(select if(id, v_no, start_date, end_date, v_title, v_progress, v_clicks,  to_char(start_date,'yyyy-mm-dd') as startdate, to_char(end_date,'yyyy-mm-dd')as enddate, sysdate>enddate, rownum as rnum"
			+ " )from(select if(id, v_no, start_date, end_date, v_title, v_progress, v_clicks, to_char(start_date,'yyyy-mm-dd') as startdate, to_char(end_date,'yyyy-mm-dd')as enddate, "
			+ " sysdate>enddate)from t_vote_board order by enddate desc)) where rnum between 1 and 20 ";
			
			
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

/*
 * 
 * // 투표 테이블 
  create table t_vote_board( 
 id varchar2(20) not null ,
 v_no number not null primary key, 
 start_date date default sysdate, 
  end_date date, 
  v_title varchar2(50) not null, 
  v_progress char(1) not null, 
  v_clicks number not null
  );
 * 
 * // 투표 상세 항목 테이블 
  create table t_vote_items( 
  v_no number not null, 
  subsection varchar2(50) not null, 
  count number not null 
  );
 * 
 * //v_no 생성 시퀀스
  create sequence seq_t_vote_no
 */
