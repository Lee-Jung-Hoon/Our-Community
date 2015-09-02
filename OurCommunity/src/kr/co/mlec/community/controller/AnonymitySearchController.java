package kr.co.mlec.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;
import kr.co.mlec.community.vo.AnonymityVO;

@WebServlet("/Anonymity/search")
public class AnonymitySearchController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String type = req.getParameter("searchType");
		String text = req.getParameter("text");
		
		AnonymityDAO dao = new AnonymityDAO();
		List<AnonymityVO> list;
		try {
		  list = dao.searchAnonymityBoard(type, text);
		  req.setAttribute("board", list);
		  RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/anonymity/list.jsp");
		  rd.forward(req, res);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
