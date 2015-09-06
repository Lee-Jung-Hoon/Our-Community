package kr.co.mlec.community.studyFile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.studyFile.dao.StudyFileCommentDAO;

@WebServlet("/studyFile/deleteComment")
public class StudyFileDeleteCommentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(req.getParameter("commentNo"));
		int no = Integer.parseInt(req.getParameter("no"));
		
		StudyFileCommentDAO dao = new StudyFileCommentDAO();
		try {
			dao.deleteComment(commentNo);
			res.sendRedirect("/OurCommunity/studyFile/detail?no="+no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
