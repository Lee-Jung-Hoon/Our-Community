package kr.co.mlec.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.WorkInfoDAO;
import kr.co.mlec.community.vo.WorkInfoVO;

@WebServlet("/workInfo/detail")
public class WorkInfoDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int no = Integer.parseInt(req.getParameter("no"));
		
		WorkInfoDAO dao = new WorkInfoDAO();
		
		
		try {
			dao.updateCheckCnt(no);
			
			WorkInfoVO info = dao.selectWorkInfoDetail(no);
			req.setAttribute("info", info);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/workInfo/detail.jsp");
			rd.forward(req, res);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
