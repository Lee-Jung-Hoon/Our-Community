package kr.co.mlec.notice.bitcampboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampBoardDAO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;

@WebServlet("/bitcampboard/NoticeBitcampRegistBoardController")
public class NoticeBitcampRegistBoardController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String scope = req.getParameter("scope");
		String boardHead = req.getParameter("boardHead");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		
		NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
		board.setContent(content);
		board.setScope(scope);
		board.setBoardHead(boardHead);
		board.setTitle(title);
		board.setId(id);
		
		NoticeBitcampBoardDAO dao = new NoticeBitcampBoardDAO();
		try {
			dao.insertBitcampBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.sendRedirect("/OurCommunity/bitcampboard/NoticeBitcampListBoardController");
	}
}
