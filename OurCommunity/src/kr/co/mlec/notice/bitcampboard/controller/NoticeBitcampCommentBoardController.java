package kr.co.mlec.notice.bitcampboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampCommentDAO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampCommentVO;

@WebServlet("/bitcampboard/NoticeBitcampCommentBoardController")
public class NoticeBitcampCommentBoardController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String comment = req.getParameter("comment");
		String no = req.getParameter("no");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		
		NoticeBitcampCommentVO commentVO = new NoticeBitcampCommentVO();
		commentVO.setId(id);
		commentVO.setNo(no);
		commentVO.setContent(comment);
		try {
			NoticeBitcampCommentDAO.insertNoticeBitcampComment(commentVO);
			resp.sendRedirect("/OurCommunity/bitcampboard/NoticeBitcampDetailBoardController?no="+no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
