package kr.co.mlec.notice.bitcampboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampCommentDAO;

@WebServlet("/bitcampboard/NoticeBitcampDeleteCommentBoardController")
public class NoticeBitcampDeleteCommentBoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		
		String no = req.getParameter("no");
		String writeNo = req.getParameter("writeNo");
		NoticeBitcampCommentDAO dao = new NoticeBitcampCommentDAO();
		System.err.println(writeNo);
		System.err.println(no);
		try {
			dao.deleteBitcampComment(no);
			res.sendRedirect("/OurCommunity/bitcampboard/NoticeBitcampDetailBoardController?no="+writeNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
