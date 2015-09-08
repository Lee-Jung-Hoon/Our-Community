package kr.co.mlec.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.member.vo.memberVO;
import kr.co.mlec.mypage.vo.MemberHistoryVO;
import kr.co.mlec.util.ConnectionPool;

public class MemberHistoryDAO {

	public List<MemberHistoryVO> selectMemberInfo(String id) throws Exception{
		List<MemberHistoryVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, title, board, REG_DATE "
					    + " from t_member_history_board "
					    + " where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberHistoryVO member= new MemberHistoryVO();
				member.setId(rs.getString("id"));
				member.setBoard(rs.getString("board"));
				member.setTitle(rs.getString("title"));
				member.setRegDate(rs.getString("reg_date"));
				list.add(member);
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
	
	public List<memberVO> selectMemberInfo() throws Exception{
		List<memberVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, SECESSION, GRADE, JOIN_DATE, name "
					+ " from t_member "
					+ "where secession = '회원' "
					+ "  and grade is null ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				memberVO member= new memberVO();
				member.setId(rs.getString("id"));
				member.setSecession(rs.getString("secession"));
				member.setJoinDate(rs.getString("JOIN_DATE"));
				member.setName(rs.getString("name"));
				member.setGrade(rs.getString("grade"));
				list.add(member);
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

	public void insertMemberHistory(String id, String title, String board) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_member_history_board(no, id, title, board) "
					+ " values(seq_t_member_history_board_no.nextVal, ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, board);
			pstmt.executeQuery();
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
 
create table t_member_history_board (
no number not null,
id varchar2(30) not null,
title varchar2(200) not null,
board varchar2(30) not null,
reg_date date default sysdate
);

create sequence seq_t_member_history_board_no
 */