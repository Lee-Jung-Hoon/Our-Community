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


@WebServlet("/ourclassboard/modify")
public class ModifyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");

		String no = req.getParameter("no");
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
		try {
			board = dao.selectBoardDt(no);
			req.setAttribute("board", board);
			req.setAttribute("no", no);
			
			RequestDispatcher rd = req.getRequestDispatcher("/board/modify.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
