package kr.co.mlec.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;
import kr.co.mlec.community.vo.AnonymityVO;

@WebServlet("/Anonymity/modifyForm")
public class AnonymityModifyFormController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int no = Integer.parseInt(req.getParameter("no"));
		AnonymityDAO dao = new AnonymityDAO();
		
		try {
			
			AnonymityVO modify = dao.selectDetail(no);
			req.setAttribute("modify", modify);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/anonymity/modify.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
