package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.BoardDAO;
import kr.co.mlec.notice.ourclassboard.vo.BoardVO;


@WebServlet("/ourclassboard/modifyUpdate")
public class ModifyUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		String no = req.getParameter("no");

		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(req.getParameter("title"));
		board.setId(req.getParameter("id"));
		board.setContent(req.getParameter("content"));
		board.setBoardhead(req.getParameter("boardhead"));
		
		BoardDAO dao = new BoardDAO();
		
		try {
			dao.modifyBoard(board);
			req.setAttribute("no", no);
			
			RequestDispatcher rd = req.getRequestDispatcher("/ourclassboard/detail");
			rd.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
