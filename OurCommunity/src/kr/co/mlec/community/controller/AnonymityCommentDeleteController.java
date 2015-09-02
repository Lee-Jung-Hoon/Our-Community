package kr.co.mlec.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;

@WebServlet("/Anonymity/Cdelete")
public class AnonymityCommentDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		int comment_no = Integer.parseInt(req.getParameter("comment_no"));
		
		AnonymityDAO dao = new AnonymityDAO();
		
		try {
			dao.deleteComment(comment_no);
			
			res.sendRedirect("/OurCommunity/Anonymity/detail?no="+no);
		} catch (Exception e) {
			throw new ServletException(e);
		}
			
	}
	
}
