package kr.co.mlec.contents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
						+ " values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, vote.getId());
			pstmt.setString(index++, num);
			pstmt.setString(index++, vote.getEnd_date());
			pstmt.setString(index++, vote.getV_title());
			pstmt.setString(index++, vote.getV_progress());
			pstmt.setString(index++, vote.getV_clicks());
			
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
						+ " values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			int index = 1;
			pstmt.setString(index++, num);
			pstmt.setString(index++, items.getSubsection());
			pstmt.setString(index++, items.getCount());
			
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
}

/*
 * 
 * // 투표 테이블 
 * create table t_vote_board( 
 * id varchar2(20) not null primary key,
 * v_no number not null, 
 * start_date date default sysdate, 
 * end_date date, 
 * v_title varchar2(50) not null, 
 * v_progress char(1) not null, 
 * v_clicks number not null
 * );
 * 
 * // 투표 상세 항목 테이블 
 * create table t_vote_items( 
 * v_no number not null, 
 * subsection varchar2(50) not null, 
 * count number not null 
 * );
 * 
 * //v_no 생성 시퀀스
 * create sequence seq_t_vote_no
 */
