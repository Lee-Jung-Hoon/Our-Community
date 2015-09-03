package kr.co.mlec.notice.bitcampboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampBoardDAO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;

@WebServlet("/bitcampboard/NoticeBitcampModifyBoardController")
public class NoticeBitcampModifyBoardController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		String no = req.getParameter("no");
		
		NoticeBitcampBoardDAO dao = new NoticeBitcampBoardDAO();
		try {
			NoticeBitcampBoardVO board = dao.selectBitcampBoard(no);
			req.setAttribute("board", board);
			req.setAttribute("no", no);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/bitcampboard/modifybitcampboard.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
