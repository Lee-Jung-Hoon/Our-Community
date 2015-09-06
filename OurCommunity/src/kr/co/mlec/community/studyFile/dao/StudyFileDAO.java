package kr.co.mlec.community.studyFile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.community.gallery.vo.GalleryVO;
import kr.co.mlec.community.studyFile.vo.StudyFileVO;
import kr.co.mlec.util.ConnectionPool;

public class StudyFileDAO {

	public void insertStudyFile(StudyFileVO file) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " insert into t_community_studyFile_board ( " 
					+ "		no, id, title, type, content,  "
					+ "		scope, file_name, origin_file_name, file_path )"
					+ "		values(s_community_studyFile_board_no.nextVal, ?, ?, ?, ?, ?, ?, ?, ? ) ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, file.getId());
			pstmt.setString(index++, file.getTitle());
			pstmt.setString(index++, file.getType());
			pstmt.setString(index++, file.getContent());
			pstmt.setString(index++, file.getScope());
			pstmt.setString(index++, file.getRealFileName());
			pstmt.setString(index++, file.getOriginFileName());
			pstmt.setString(index++, file.getFilePath());
			pstmt.executeUpdate();
		} 
		catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
	}

	public List<StudyFileVO> selectStudyFileList() throws Exception{
		List<StudyFileVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, type, to_char(reg_date, 'yy-mm-dd')as regDate, check_cnt "
						   + " from t_community_studyFile_board" 
						   + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				StudyFileVO file = new StudyFileVO();
				file.setId(rs.getString("id"));
				file.setNo(rs.getInt("no"));
				file.setTitle(rs.getString("title"));
				file.setType(rs.getString("type"));
				file.setCheckCnt(rs.getInt("check_cnt"));
				file.setRegDate(rs.getString("regDate"));
				list.add(file);
			}
		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
		return list;
	}

	public StudyFileVO selectStudyFileDetail(int no) throws Exception{

		StudyFileVO file = new StudyFileVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select id, no, title, type, content, file_path, file_name, origin_file_name, "
						   + " to_char(reg_date, 'yy-mm-dd hh24:mi:ss')as regDate, check_cnt, scope "
						   + " from t_community_studyFile_board"
						   + " where no = ? " 
						   + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				file.setId(rs.getString("id"));
				file.setNo(rs.getInt("no"));
				file.setTitle(rs.getString("title"));
				file.setType(rs.getString("type"));
				file.setContent(rs.getString("content"));
				file.setFilePath(rs.getString("file_path"));
				file.setRealFileName(rs.getString("file_name"));
				file.setOriginFileName(rs.getString("origin_file_name"));
				file.setRegDate(rs.getString("regDate"));
				file.setCheckCnt(rs.getInt("check_cnt"));
				file.setScope(rs.getString("scope"));
			}
		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
		return file;
	}

	public void updateStudyFile(StudyFileVO vo) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql ="update  t_community_studyFile_board "
							+ "set title = ?, "
							+ "type = ?, "
							+ "content	= ?, "
							+ "scope = ?, "
							+ "file_name = ?, "
							+ "origin_file_name = ?, "
							+ "file_path = ?, "
							+ "reg_date = sysdate "
							+ "where  no = ? ";
			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, vo.getTitle());
			pstmt.setString(index++, vo.getType());
			pstmt.setString(index++, vo.getContent());
			pstmt.setString(index++, vo.getScope());
			pstmt.setString(index++, vo.getRealFileName());
			pstmt.setString(index++, vo.getOriginFileName());
			pstmt.setString(index++, vo.getFilePath());
			pstmt.setInt(index++, vo.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
	}
	public void deleteStudyFile(int no) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " delete t_community_studyFile_board " 
						   + " where  no = ?  ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				ConnectionPool.close(con);
			}
		}
	}
}



/* 
create table t_community_studyFile_board (
 id varchar2(30) not null,
 no number not null,
 title varchar2(150),
 type varchar2(50),
 content varchar2(1500),
 reg_date date default sysdate,
 check_cnt number,
 scope varchar(5),
 file_name varchar(1000),
 origin_file_name varchar2(1000),
 file_path varchar(1000)
 )
 
create sequence s_community_studyFile_board_no
 
 */