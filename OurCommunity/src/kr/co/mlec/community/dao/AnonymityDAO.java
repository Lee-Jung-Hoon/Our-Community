package kr.co.mlec.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.community.vo.AnonymityVO;
import kr.co.mlec.util.ConnectionPool;

public class AnonymityDAO {
	public void insertAnonymity(AnonymityVO anonymity) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " insert into t_anonymity_board(no, title, id, content, scope) "
					+ " values(seq_t_anonymity_board_no.nextVal, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			int index = 1;
			pstmt.setString(index++, anonymity.getTitle());
			pstmt.setString(index++, anonymity.getId());
			pstmt.setString(index++, anonymity.getContent());
			pstmt.setString(index++, anonymity.getScope());
			pstmt.executeQuery();

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
	
	public List<AnonymityVO> selectAnonymity() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = " select no, title, id, to_char(reg_date, 'yyyy-mm-dd') as regDate, scope"
					+ "   from t_anonymity_board" 
					+ "  order by no desc";

			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			List<AnonymityVO> list = new ArrayList<>();
			while (rs.next()) {
				AnonymityVO anonymity = new AnonymityVO();
				anonymity.setNo(rs.getInt("no"));
				anonymity.setTitle(rs.getString("title"));
				anonymity.setId(rs.getString("id"));
				anonymity.setRegDate(rs.getString("regDate"));
				anonymity.setScope(rs.getString("scope"));
				list.add(anonymity);
			}
			return list;
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
