package kr.co.mlec.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;
import kr.co.mlec.community.vo.AnonymityVO;

@WebServlet("/Anonymity/list")
public class AnonymityListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		AnonymityDAO dao = new AnonymityDAO();
		
		try {
			
			List<AnonymityVO>list= dao.selectAnonymity();
			req.setAttribute("list", list);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/anonymity/list.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
