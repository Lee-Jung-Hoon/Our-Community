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
import kr.co.mlec.community.vo.AnonymityCommentVO;

@WebServlet("/Anonymity/comment")
public class AnonymityCommentController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(req.getParameter("no"));
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		AnonymityDAO dao = new AnonymityDAO();
		
		AnonymityCommentVO comment = new AnonymityCommentVO();
		comment.setNo(no);
		comment.setId(id);
		comment.setContent(content);
		
		try {
			dao.insertComment(comment);
			
			res.sendRedirect("/OurCommunity/Anonymity/detail?no="+no);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}
	
}
