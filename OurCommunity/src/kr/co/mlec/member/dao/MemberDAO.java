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
					  + " email_domain, tel, gender, address, hint, hint_answer, secession ) "
					  + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;
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
			pstmt.setString(index++, "회원");
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
			String sql = "select id, password, grade "
					+ " from t_member "
					+ " where id = ? "
					+ "   and password = ? "
					+ "   and secession = '회원' ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setGrade(rs.getString("grade"));
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

	public boolean checkId(memberVO vo) throws Exception {
		
		
		boolean bl = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " select *  from t_member where id = ?        ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				bl = false;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			ConnectionPool.close(con);
		}
		return bl;
		
		
	}
}


/* t_member 테이블 구성 	
 	create table t_member (
 	id varchar2(20) primary key not null,
 	name varchar2(20) not null,
 	password varchar2(30) not null,
 	secession varchar2(20) not null,
 	email_id varchar2(10) not null,
 	email_domain varchar2(20) not null,
 	tel varchar2(30) not null,
 	address varchar2(30) not null,
 	gender varchar2(8) not null,
 	grade varchar2(10),
 	join_date date default sysdate,
 	hint varchar2(20) not null,
 	hint_answer varchar2(200) not null);
 */

/* 회원가입 SQL
 * "insert into t_member(id, name, password, email_id, "
					  + " email_domain, tel, gender, address, hint, hint_answer, secession ) "
					  + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
 */

/* 로그인 SQL
 * select id, password "
					+ " from t_member "
					+ " where id = ? "
					+ "   and password = ? "
					+ "   and secession = '회원' "
 * 
 */