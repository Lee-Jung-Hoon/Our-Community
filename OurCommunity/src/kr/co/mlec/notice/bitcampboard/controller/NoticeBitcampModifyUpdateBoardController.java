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

@WebServlet("/bitcampboard/NoticeBitcampModifyUpdateBoardController")
public class NoticeBitcampModifyUpdateBoardController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String scope = req.getParameter("scope");
		String boardHead = req.getParameter("boardHead");
		
		NoticeBitcampBoardVO board = new NoticeBitcampBoardVO();
		board.setContent(content);
		board.setScope(scope);
		board.setBoardHead(boardHead);
		board.setTitle(title);
		board.setNo(no);
		
		NoticeBitcampBoardDAO dao = new NoticeBitcampBoardDAO();
		try {
			dao.upadateBitcampBoard(board);
			res.sendRedirect("/OurCommunity/bitcampboard/NoticeBitcampDetailBoardController?no="+no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
