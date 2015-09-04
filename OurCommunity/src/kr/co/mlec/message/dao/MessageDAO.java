package kr.co.mlec.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.message.vo.MessageVO;
import kr.co.mlec.util.ConnectionPool;

public class MessageDAO {

	public void sendMessage(MessageVO message) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_message(no, id, sendid, title, content, bin, read) "
					+ " values(seq_t_message_no.nextVal, ?, ?, ?, ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, message.getId());
			pstmt.setString(index++, message.getSendId());
			pstmt.setString(index++, message.getTitle());
			pstmt.setString(index++, message.getContent());
			pstmt.setString(index++, "n");
			pstmt.setString(index++, "n");
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		
	}

	public List<MessageVO> selectReceiveMessage(String id) throws Exception {
		List<MessageVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select no, id, title, sendid, send_date, read, bin "
					+ " from t_message "
					+ " where bin = 'n' "
					+ " and sendid = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MessageVO message = new MessageVO();
				message.setNo(rs.getString("no"));
				message.setId(rs.getString("id"));
				message.setTitle(rs.getString("title"));
				message.setSendDate(rs.getString("send_date"));
				message.setBin(rs.getString("bin"));
				message.setRead(rs.getString("read"));
				list.add(message);
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

	public MessageVO selectReceiveMessage(int no) throws Exception{
		MessageVO message = new MessageVO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, sendid, title, no, bin, read, send_date, content "
					+ " from t_message "
					+ " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				message.setId(rs.getString("id"));
				message.setContent(rs.getString("content"));
				message.setTitle(rs.getString("title"));
				message.setNo(rs.getString("no"));
				message.setSendDate(rs.getString("send_date"));
				message.setBin(rs.getString("bin"));
				message.setRead(rs.getString("read"));
				message.setSendId(rs.getString("sendid"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return message;
	}

	public void updateReadMessage(String no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update t_message " 
						+ " set read = 'y' "
						+ " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ConnectionPool.close(con);
		}
	}

	public List<MessageVO> selectSendMessage(String id) throws Exception{
		List<MessageVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select no, id, title, sendid, send_date, read, bin "
					+ " from t_message "
					+ " where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MessageVO message = new MessageVO();
				message.setNo(rs.getString("no"));
				message.setId(rs.getString("id"));
				message.setSendId(rs.getString("sendid"));
				message.setTitle(rs.getString("title"));
				message.setSendDate(rs.getString("send_date"));
				message.setBin(rs.getString("bin"));
				message.setRead(rs.getString("read"));
				list.add(message);
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
}


/*
create sequence seq_t_message_no


create table t_message (
no varchar2(4),
id varchar2(20),
title varchar2(100),
sendid varchar2(20),
content varchar2(600),
bin char(3),
send_date date default sysdate
);
*/
