package kr.co.mlec.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.contents.dao.VoteBoardDAO;
import kr.co.mlec.contents.vo.VoteBoardVO;
import kr.co.mlec.contents.vo.VoteItemsVO;
import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampBoardDAO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;

@WebServlet("/main")
public class Main extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		NoticeBitcampBoardDAO noticeDAO = new NoticeBitcampBoardDAO();
		VoteBoardDAO voteDAO = new VoteBoardDAO();
		HttpSession session = req.getSession();
		try {
			List<NoticeBitcampBoardVO> noticeList = noticeDAO.selectMainList();
			int no = voteDAO.selectLastVNo();
			List<VoteItemsVO> ilist = voteDAO.selectItems(no+"");
			VoteBoardVO voteList = voteDAO.selectDetail(no+"");
			String id = (String) session.getAttribute("userId"); //로그인여부 전달
			req.setAttribute("voteList", voteList);
			req.setAttribute("noticeList", noticeList ); //공지사항리스트 전달
			req.setAttribute("ilist", ilist);  //최신 투표데이터 전달
			req.setAttribute("id", id);
			RequestDispatcher r = req.getRequestDispatcher("/jsp/main/main.jsp");
			r.forward(req, res);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
