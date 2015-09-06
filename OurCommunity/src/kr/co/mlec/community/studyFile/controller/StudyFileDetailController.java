package kr.co.mlec.community.studyFile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.studyFile.dao.StudyFileCommentDAO;
import kr.co.mlec.community.studyFile.dao.StudyFileDAO;
import kr.co.mlec.community.studyFile.vo.StudyFileCommentVO;
import kr.co.mlec.community.studyFile.vo.StudyFileVO;

@WebServlet("/studyFile/detail")
public class StudyFileDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		StudyFileDAO dao = new StudyFileDAO();
		StudyFileCommentDAO cDao = new StudyFileCommentDAO();
		int no = Integer.parseInt(req.getParameter("no"));
		

		try {
			StudyFileVO file = dao.selectStudyFileDetail(no);
			req.setAttribute("file", file);
			
			List<StudyFileCommentVO> list = cDao.selectStudyFileComment(no);
			req.setAttribute("cList", list);
			
			dao.updateCheckCnt(no);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/studyFile/detail.jsp");
			rd.forward(req, res);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}

