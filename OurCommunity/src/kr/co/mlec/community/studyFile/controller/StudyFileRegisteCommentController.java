package kr.co.mlec.community.studyFile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.community.studyFile.dao.StudyFileCommentDAO;
import kr.co.mlec.community.studyFile.vo.StudyFileCommentVO;

@WebServlet("/studyFile/comment")
public class StudyFileRegisteCommentController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(req.getParameter("no"));
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		String content = req.getParameter("comment");
		
		StudyFileCommentVO commentVo = new StudyFileCommentVO();
		commentVo.setId(id);
		commentVo.setNo(no);
		commentVo.setContent(content);
		
		try {
			StudyFileCommentDAO dao = new StudyFileCommentDAO();
			dao.insertComment(commentVo);
			
			res.sendRedirect("/OurCommunity/studyFile/detail?no="+no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
