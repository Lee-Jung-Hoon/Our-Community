package kr.co.mlec.notice.adminboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.adminboard.dao.NoticeAdminBoardDAO;
import kr.co.mlec.notice.adminboard.vo.NoticeAdminBoardVO;


@WebServlet("/adminboard/NoticeAdminModifyBoardController")
public class NoticeAdminModifyBoardController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		String no = req.getParameter("no");
		
		NoticeAdminBoardDAO dao = new NoticeAdminBoardDAO();
		try {
			NoticeAdminBoardVO board = dao.selectAdminBoard(no);
			req.setAttribute("board", board);
			req.setAttribute("no", no);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/adminboard/modifyadminboard.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
