package kr.co.mlec.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.mypage.vo.MemberInfoVO;
import kr.co.mlec.util.ConnectionPool;

public class MemberInfoDAO {

	public List<MemberInfoVO> selectMember() throws Exception{
		List<MemberInfoVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, name, tel, secession, join_date "
					+ " from t_member ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberInfoVO member = new MemberInfoVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setTel(rs.getString("tel"));
				member.setSecession(rs.getString("secession"));
				member.setJoinDate(rs.getString("join_date"));
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

	public MemberInfoVO selectDetailMember(String id, String name) throws Exception{
		
		MemberInfoVO memberInfo = new MemberInfoVO();
		Connection con = null;
		PreparedStatement pstmt = null;
			try {
				con = ConnectionPool.getConnection();
				String sql = "select id, name, password, secession, email_id, email_domain, tel, address, gender, join_date, "
							   + "hint, hint_answer "
							   + " from t_member "
							   + " where id = ? "
							   + " and name = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					memberInfo.setId(rs.getString("id"));
					memberInfo.setName(rs.getString("name"));
					memberInfo.setPassword(rs.getString("password"));
					memberInfo.setSecession(rs.getString("secession"));
					memberInfo.setEmailId(rs.getString("email_id"));
					memberInfo.setEmailDomain(rs.getString("email_domain"));
					memberInfo.setTel(rs.getString("tel"));
					memberInfo.setAddress(rs.getString("address"));
					memberInfo.setGender(rs.getString("gender"));
					memberInfo.setJoinDate(rs.getString("join_date"));
					memberInfo.setHint(rs.getString("hint"));
					memberInfo.setHintAnswer(rs.getString("hint_answer"));
				}
			} catch (Exception e) {
				throw e;
			} finally {
				if (pstmt != null)
					pstmt.close();
				ConnectionPool.close(con);
			}
			return memberInfo;
	}
}


