package kr.co.mlec.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.community.vo.WorkInfoVO;
import kr.co.mlec.util.ConnectionPool;

public class WorkInfoDAO {

	public void insertWorkInfo(WorkInfoVO info) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_workInfo_board(no, id, url, active, posting_timestamp, "
					+ "												  opening_timestamp, expiration_timestamp, company, title, job_type, "
					+ "												  job_category, open_quantity, experience_level)"
					+ " values(seq_t_workInfo_board_no.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, info.getId());
			pstmt.setString(index++, info.getUrl());
			pstmt.setString(index++, info.getActive());
			pstmt.setString(index++, info.getPostingTimeStamp());
			pstmt.setString(index++, info.getOpeningTimeStamp());
			pstmt.setString(index++, info.getExpirationTimeStamp());
			pstmt.setString(index++, info.getCompany());
			pstmt.setString(index++, info.getTitle());
			pstmt.setString(index++, info.getJobType());
			pstmt.setString(index++, info.getJobCategory());
			pstmt.setString(index++, info.getOpenQuantity());
			pstmt.setString(index++, info.getExperienceLevel());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
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
create table t_workInfo_board (
	    no Number primary key, 
	    id varchar2(1000),
	    url varchar2(1000),
	    active varchar2(1000),
	    posting_timeStamp varchar2(1000),
	    opening_timeStamp varchar2(1000),
	    expiration_timeStamp varchar2(1000),
		company varchar2(1000),
	    title varchar2(1000),
	    job_type varchar2(1000),
	    job_category varchar2(1000),
	    open_quantity varchar2(1000),
	    experience_level varchar2(1000),
	    check_cnt Number
	);
	
	create sequence seq_t_workInfo_board_no
*/