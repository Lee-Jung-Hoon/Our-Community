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
	private int PAGE = 2;
	private int count = 0;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		StudyFileDAO dao = new StudyFileDAO();
		String search = req.getParameter("searchlist");
		String content = req.getParameter("content");
		String pageNum = req.getParameter("pagenum"); 
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int endNum = Integer.parseInt(pageNum) * PAGE;
		int startNum = endNum - PAGE + 1;
		
		try {
			
			if(content == null || content == "") {
				List<StudyFileVO> list = dao.selectStudyFileList(startNum, endNum);
				count = dao.selectCount();
				req.setAttribute("list", list);
			} else {
				List<StudyFileVO> sList = dao.slectSearchStudyFileList(search, content, startNum,endNum);
				count = dao.selectSearchCount(search, content);
				req.setAttribute("search", search);
				req.setAttribute("content", content);
				req.setAttribute("list", sList);
			}
			
			int pageSize = (int)Math.ceil((double)count/PAGE);
			req.setAttribute("pagingSize", pageSize);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/studyFile/list.jsp");
			rd.forward(req, res);
					
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
