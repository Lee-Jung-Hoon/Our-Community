package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.BoardDAO;
import kr.co.mlec.notice.ourclassboard.vo.BoardVO;
@WebServlet("/ourclassboard/search")
public class SearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		BoardDAO dao = new BoardDAO();
		
		String type = req.getParameter("searchType");
		String search = req.getParameter("search");
	
		
		try {
			List<BoardVO> list = dao.searchBoard(type, search);
			req.setAttribute("list", list);
			
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/ourclassboard/list.jsp");
			rd.forward(req, res);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}