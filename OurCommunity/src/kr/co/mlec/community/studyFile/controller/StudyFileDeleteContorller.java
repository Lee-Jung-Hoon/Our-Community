package kr.co.mlec.community.studyFile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.studyFile.dao.StudyFileDAO;
import kr.co.mlec.community.studyFile.vo.StudyFileVO;

@WebServlet("/studyFile/delete")
public class StudyFileDeleteContorller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		StudyFileDAO dao = new StudyFileDAO();
		int no = Integer.parseInt(req.getParameter("no"));
		
		try {
			dao.deleteStudyFile(no);
			res.sendRedirect("/OurCommunity/studyFile/list");
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
