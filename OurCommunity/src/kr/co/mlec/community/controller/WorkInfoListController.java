package kr.co.mlec.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.WorkInfoDAO;
import kr.co.mlec.community.vo.WorkInfoVO;

@WebServlet("/workInfo/list")
public class WorkInfoListController extends HttpServlet{
	private int PAGE = 10 	;
	private int count = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		WorkInfoDAO dao = new WorkInfoDAO();
		String search = req.getParameter("searchlist");
		String content = req.getParameter("content");
		String pageNum =req.getParameter("pagenum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int endNum = PAGE * Integer.parseInt(pageNum);
		int startNum = endNum - PAGE + 1; 
		
	try {
		
		if(content == null || content == "") {
			count = dao.selectCount();
			List<WorkInfoVO> list = dao.selectList(startNum, endNum);
			req.setAttribute("workInfoList", list);
		} else {
			
			List<WorkInfoVO> sList = dao.selectSearch(search, content, startNum, endNum);
			count = dao.selectSearchCount(search, content);
			System.out.println(count);
			req.setAttribute("workInfoList", sList);
			req.setAttribute("search", search);
			req.setAttribute("content", content);
			}
		
			int paging = (int) Math.ceil((double)count/PAGE);
			req.setAttribute("pagingSize", paging);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/workInfo/list.jsp");
			rd.forward(req, res);
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
