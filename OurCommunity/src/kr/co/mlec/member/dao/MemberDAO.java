package kr.co.mlec.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.ca.util.ConnectionPool;
import kr.co.mlec.member.vo.memberVO;

public class MemberDAO {

	public void insertMember(memberVO member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_member(id, name, password, email_id, "
					  + " email_domain, tel, gender, address, hint, hint_answer ) "
					  + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, member.getId());
			pstmt.setString(index++, member.getName());
			pstmt.setString(index++, member.getPassword());
			pstmt.setString(index++, member.getEmailId());
			pstmt.setString(index++, member.getEmailDomain());
			pstmt.setString(index++, member.getTel());
			pstmt.setString(index++, member.getGender());
			pstmt.setString(index++, member.getAddress());
			pstmt.setString(index++, member.getHint());
			pstmt.setString(index++, member.getHintAnswer());
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
