package kr.co.mlec.notice.adminboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.adminboard.dao.NoticeAdminBoardDAO;
import kr.co.mlec.notice.adminboard.vo.NoticeAdminBoardVO;

@WebServlet("/adminboard/NoticeAdminModifyUpdateBoardController")
public class NoticeAdminModifyUpdateBoardController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeAdminBoardVO board = new NoticeAdminBoardVO();
		board.setContent(content);
		board.setTitle(title);
		board.setNo(no);
		
		NoticeAdminBoardDAO dao = new NoticeAdminBoardDAO();
		try {
			dao.upadateAdminBoard(board);
			res.sendRedirect("/OurCommunity/adminboard/NoticeAdminDetailBoardController?no="+no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
