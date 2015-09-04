package kr.co.mlec.community.controller;

import java.io.IOException;
import java.util.ArrayList;
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		WorkInfoDAO dao = new WorkInfoDAO();
		String search = req.getParameter("searchlist");
		String content = req.getParameter("content");
		
	try {
		int listSize = dao.selectList().size();
		int paging = (int) Math.ceil(listSize/5);
		req.setAttribute("pagingSize", paging);
		
		if(content == null) {
			List<WorkInfoVO> list = dao.selectList();
			req.setAttribute("workInfoList", list);
			} else {
			List<WorkInfoVO> sList = dao.selectSearch(search, content);
			req.setAttribute("workInfoList", sList);
				}
		
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/workInfo/list.jsp");
			rd.forward(req, res);
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
