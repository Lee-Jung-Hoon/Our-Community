package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.BoardDAO;
import kr.co.mlec.notice.ourclassboard.vo.BoardVO;


@WebServlet("/ourclassboard/write")
public class WriteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String boardhead = req.getParameter("boardhead");
		String content = req.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setId(id);
		board.setTitle(title);
		board.setBoardhead(boardhead);
		board.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		try {
			dao.insertBoard(board);
			res.sendRedirect("/Community/ourclassboard/list?type=C");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}