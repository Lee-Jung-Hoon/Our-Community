package kr.co.mlec.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.community.dao.AnonymityDAO;
import kr.co.mlec.community.vo.AnonymityCommentVO;
import kr.co.mlec.community.vo.AnonymityVO;

@WebServlet("/Anonymity/detail")
public class AnonymityDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		
		AnonymityDAO dao = new AnonymityDAO();
		
		try {
			AnonymityVO anonymity = dao.selectDetail(no);
			dao.updateCheckCnt(no);
			req.setAttribute("anonymity", anonymity);
			
			
			List<AnonymityCommentVO> comment = dao.selectComment(no);
			req.setAttribute("comment", comment);
			req.setAttribute("id", id);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/anonymity/detail.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
