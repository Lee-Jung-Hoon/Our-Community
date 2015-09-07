package kr.co.mlec.notice.adminboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.notice.adminboard.dao.NoticeAdminBoardDAO;
import kr.co.mlec.notice.adminboard.vo.NoticeAdminBoardVO;

@WebServlet("/adminboard/NoticeAdminRegistBoardController")
public class NoticeAdminRegistBoardController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		
		NoticeAdminBoardVO board = new NoticeAdminBoardVO();
		board.setContent(content);
		board.setTitle(title);
		board.setId(id);
		
		NoticeAdminBoardDAO dao = new NoticeAdminBoardDAO();
		try {
			dao.insertAdminBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.sendRedirect("/OurCommunity/adminboard/NoticeAdminListBoardController");
	}
}
