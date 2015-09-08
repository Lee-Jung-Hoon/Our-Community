package kr.co.mlec.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.member.vo.memberVO;
import kr.co.mlec.util.ConnectionPool;

public class personalInfoDAO {

	public memberVO selectAll(memberVO vo) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		memberVO member= new memberVO();
		try {
			con = ConnectionPool.getConnection();
			String sql = "select *  from t_member  where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				
		
				
				
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setTel(rs.getString("tel"));
				member.setGender(rs.getString("gender"));
				member.setEmailId(rs.getString("email_Id"));
				member.setEmailDomain(rs.getString("email_Domain"));
				member.setAddress(rs.getString("address"));
				member.setHint(rs.getString("hint"));
				member.setHintAnswer(rs.getString("hint_Answer"));
				
				
				
			
			}
			
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return member;
		
		
		
		
	}

	public void updatePersonalInfo(memberVO member) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update t_member "
					+ " set  "
					+ " name	=	? , "
					+ " password	= 	? , "
					+ " email_id	= 	?	, "
					+ " email_domain 	= 	? , "
					+ " tel 	= 	? , "
					+ " gender = ? , "
					+ " address = ? ,"
					+ " hint = ? ,"
					+ "  hint_answer = ? , "
					+ " secession = ? "
					+ " where id = ? ";
					
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, member.getName());
			pstmt.setString(index++, member.getPassword());
			pstmt.setString(index++, member.getEmailId());
			pstmt.setString(index++, member.getEmailDomain());
			pstmt.setString(index++, member.getTel());
			pstmt.setString(index++, member.getGender());
			pstmt.setString(index++, member.getAddress());
			pstmt.setString(index++, member.getHint());
			pstmt.setString(index++, member.getHintAnswer());
			pstmt.setString(index++, "회원");
			pstmt.setString(index++, member.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		
		
	}

	public void deletePersonal(memberVO vo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update t_member "
					+ " set  "
					+ " secession = ? "
					+ " where id = ? ";
					
			pstmt = con.prepareStatement(sql);
			int index = 1;

			pstmt.setString(index++, vo.getId());
			pstmt.setString(index++, "탈퇴");
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
