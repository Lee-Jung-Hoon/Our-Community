package kr.co.mlec.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
					+ "												  job_category, open_quantity, experience_level, salary, check_cnt )"
					+ " values(seq_t_workInfo_board_no.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";

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
			pstmt.setString(index++, info.getSalary());
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
	
	public void insertTemp(WorkInfoVO info) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into t_temp(id) "
					+ "values(?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getId());
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
	public List<String> selectCompanyId() throws Exception{
		
		List<String> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id from t_temp "
							+ "minus "
							+ "select id from t_workInfo_board";

			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				list.add(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			ConnectionPool.close(con);
		}
		return list;
	}

	public void deleteTemp() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "delete from t_temp";

			pstmt = con.prepareStatement(sql);
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

	public List<WorkInfoVO> selectList(int startNum, int endNum) throws Exception{
		
		List<WorkInfoVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select * "
						   + "from (select no, id, url, active, posting_timestamp, "
						   + "							opening_timestamp, expiration_timestamp, company, title, job_type, "
						   + "							job_category, open_quantity, experience_level, salary, check_cnt, rownum rnum "
						   + "from (select no, id, url, active, posting_timestamp, "
						   + "							opening_timestamp, expiration_timestamp, company, title, job_type, "
						   + "							job_category, open_quantity, experience_level, salary, check_cnt "
						   + "from t_workInfo_board "
						   + "order by no desc)) "
						   + "where rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				WorkInfoVO vo = new WorkInfoVO();
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				vo.setUrl(rs.getString("url"));
				vo.setActive(rs.getString("active"));
				vo.setPostingTimeStamp(rs.getString("posting_timestamp"));
				vo.setOpeningTimeStamp(rs.getString("opening_timestamp"));
				vo.setExpirationTimeStamp(rs.getString("expiration_timestamp"));
				vo.setCompany(rs.getString("company"));
				vo.setTitle(rs.getString("title"));
				vo.setJobType(rs.getString("job_type"));
				vo.setJobCategory(rs.getString("job_category"));
				vo.setOpenQuantity(rs.getString("open_quantity"));
				vo.setExperienceLevel(rs.getString("experience_level"));
				vo.setSalary(rs.getString("salary"));
				vo.setCheckCnt(rs.getInt("check_cnt"));
				list.add(vo);
			}
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
		return list;
	}
	
	public int selectCount() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select count(no) as count "
						   + "from t_workInfo_board "
					       + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
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
		return count;
	}
	
	public WorkInfoVO selectWorkInfoDetail(int no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select no, id, url, active, posting_timestamp, "
						   + "							opening_timestamp, expiration_timestamp, company, title, job_type, "
						   + "							job_category, open_quantity, experience_level, salary, check_cnt "
						   + "from t_workInfo_board "
						   + "where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				WorkInfoVO info = new WorkInfoVO();
				info.setNo(rs.getInt("no"));
				info.setId(rs.getString("id"));
				info.setUrl(rs.getString("url"));
				info.setActive(rs.getString("active"));
				info.setPostingTimeStamp(rs.getString("posting_timestamp"));
				info.setOpeningTimeStamp(rs.getString("opening_timestamp"));
				info.setExpirationTimeStamp(rs.getString("expiration_timestamp"));
				info.setCompany(rs.getString("company"));
				info.setTitle(rs.getString("title"));
				info.setJobType(rs.getString("job_type"));
				info.setJobCategory(rs.getString("job_category"));
				info.setOpenQuantity(rs.getString("open_quantity"));
				info.setExperienceLevel(rs.getString("experience_level"));
				info.setSalary(rs.getString("salary"));
				info.setCheckCnt(rs.getInt("check_cnt"));
				return info;
			}
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
		return null;
	}
	
	public void deleteWorkInfo() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "delete from t_workInfo_board "
						   + "where expiration_timestamp = to_char(sysdate, 'yyyy-MM-dd')";
			pstmt = con.prepareStatement(sql);
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

	public List<WorkInfoVO> selectSearch(String search, String content, int startNum, int endNum) throws Exception{
		List<WorkInfoVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select * "
						   + "from (select no, id, url, active, posting_timestamp, "
						   + "							opening_timestamp, expiration_timestamp, company, title, job_type, "
						   + "							job_category, open_quantity, experience_level, salary, check_cnt, rownum rnum "
						   + "from (select no, id, url, active, posting_timestamp, "
						   + "							opening_timestamp, expiration_timestamp, company, title, job_type, "
						   + "							job_category, open_quantity, experience_level, salary, check_cnt "
						   + "from t_workInfo_board "
					       + "where "+search+" like ? "
					       + " order by no desc )) "
					       + "where rnum between ? and ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				WorkInfoVO vo = new WorkInfoVO();
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				vo.setUrl(rs.getString("url"));
				vo.setActive(rs.getString("active"));
				vo.setPostingTimeStamp(rs.getString("posting_timestamp"));
				vo.setOpeningTimeStamp(rs.getString("opening_timestamp"));
				vo.setExpirationTimeStamp(rs.getString("expiration_timestamp"));
				vo.setCompany(rs.getString("company"));
				vo.setTitle(rs.getString("title"));
				vo.setJobType(rs.getString("job_type"));
				vo.setJobCategory(rs.getString("job_category"));
				vo.setOpenQuantity(rs.getString("open_quantity"));
				vo.setExperienceLevel(rs.getString("experience_level"));
				vo.setSalary(rs.getString("salary"));
				vo.setCheckCnt(rs.getInt("check_cnt"));
				list.add(vo);
			}
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
		return list;
	}

	public void updateCheckCnt(int no) throws Exception {
		
		System.out.println("디테일 no값은 : "+no);
		System.out.println("너 여기까지 안오는거지 맞지");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "update  t_workInfo_board "
						   + "set check_cnt = (check_cnt + 1) "
						   + "where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
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

	public int selectSearchCount(String search, String content) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select count(no) as count "
						   + "from t_workInfo_board "
					       + "where "+search+" like ? "
					       + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
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
		return count;
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
	    salary varchar2(50),
	    check_cnt Number 
	);
	
create table t_temp (
		id varchar2(1000)
	);
	
	create sequence seq_t_workInfo_board_no
*/