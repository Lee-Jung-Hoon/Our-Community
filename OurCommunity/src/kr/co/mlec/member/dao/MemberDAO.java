package kr.co.mlec.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.member.vo.memberVO;
import kr.co.mlec.util.ConnectionPool;

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

	public memberVO selectMember(String id, String password) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		memberVO member= new memberVO();
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, password "
					+ " from t_member "
					+ " where id = ? "
					+ "   and password = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
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
}


/* t_member 테이블 구성
 * T_MEMBER	ID	Varchar2	20	-	-	1	-	-	-
 	NAME	Varchar2	30	-	-	-	-	-	-
 	PASSWORD	Varchar2	20	-	-	-	-	-	-
 	EMAIL_ID	Varchar2	10	-	-	-	-	-	-
 	EMAIL_DOMAIN	Varchar2	20	-	-	-	-	-	-
 	TEL	Varchar2	30	-	-	-	-	-	-
 	ADDRESS	Varchar2	200	-	-	-	-	-	-
 	GENDER	Varchar2	8	-	-	-	-	-	-
 	GRADE	Varchar2	10	-	-	-	널 가능	-	-
 	JOIN_DATE	Date	7	-	-	-	널 가능	sysdate	-
 	HINT	Varchar2	20	-	-	-	-	-	-
 	HINT_ANSWER	Varchar2	200	-	-	-	-	-	-
 */

/* 회원가입 SQL
 * "insert into t_member(id, name, password, email_id, "
					  + " email_domain, tel, gender, address, hint, hint_answer ) "
					  + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
 */

/* 로그인 SQL
 * select id, password "
					+ " from t_member "
					+ " where id = ? "
					+ "   and password = ? "
 * 
 */