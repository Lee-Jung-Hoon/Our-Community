package kr.co.mlec.notice.bitcampboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampBoardDAO;
import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampCommentDAO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampCommentVO;

@WebServlet("/bitcampboard/NoticeBitcampDetailBoardController")
public class NoticeBitcampDetailBoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		String boardNo = req.getParameter("no");
		
		NoticeBitcampBoardDAO dao = new NoticeBitcampBoardDAO();
		NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
		List<NoticeBitcampCommentVO> list = new ArrayList<>();
		NoticeBitcampCommentDAO cdao = new NoticeBitcampCommentDAO();
		
		try {
			dao.checkUpBitcampBoard(boardNo);
			list = cdao.selectNoticeBitcampComment(boardNo);
			board = dao.selectBitcampBoard(boardNo);
			req.setAttribute("board", board);
			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("userId");
			String grade = (String) session.getAttribute("grade");
			System.err.println(grade);
			req.setAttribute("grade", grade);
			req.setAttribute("id", id);
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/bitcampboard/detailnoticebitcampboard.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
