package kr.co.mlec.community.studyFile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.studyFile.dao.StudyFileDAO;
import kr.co.mlec.community.studyFile.vo.StudyFileVO;

@WebServlet("/studyFile/updateWrite")
public class StudyFileUpdateWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int no = Integer.parseInt(req.getParameter("no"));
		
		StudyFileDAO dao = new StudyFileDAO();
		
		try{
			StudyFileVO update = dao.selectStudyFileDetail(no);
			req.setAttribute("update", update);
			req.setAttribute("no", no);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/studyFile/modify.jsp");
			rd.forward(req, res);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
