package kr.co.mlec.notice.adminboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.notice.adminboard.dao.NoticeAdminBoardDAO;
import kr.co.mlec.notice.adminboard.vo.NoticeAdminBoardVO;

@WebServlet("/adminboard/NoticeAdminDetailBoardController")
public class NoticeAdminDetailBoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		String boardNo = req.getParameter("no");
		
		NoticeAdminBoardDAO dao = new NoticeAdminBoardDAO();
		NoticeAdminBoardVO board = new NoticeAdminBoardVO();
		
		try {
			dao.checkUpAdminBoard(boardNo);
			board = dao.selectAdminBoard(boardNo);
			req.setAttribute("board", board);
			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("userId");
			String grade = (String) session.getAttribute("grade");
			System.err.println(grade);
			req.setAttribute("grade", grade);
			req.setAttribute("id", id);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/adminboard/detailnoticeadminboard.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
