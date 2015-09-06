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

@WebServlet("/studyFile/list")
public class StudyFileListController extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		StudyFileDAO dao = new StudyFileDAO();
		
		try {
			List<StudyFileVO> list = dao.selectStudyFileList();
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/studyFile/list.jsp");
			rd.forward(req, res);
					
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
