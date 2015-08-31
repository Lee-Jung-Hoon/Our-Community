package kr.co.mlec.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;
import kr.co.mlec.community.vo.AnonymityVO;

@WebServlet("/Anonymity/write")
public class AnonymityWriteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String scope = req.getParameter("scope");
		
		AnonymityVO anonymity = new AnonymityVO();
		anonymity.setId(id);
		anonymity.setTitle(title);
		anonymity.setContent(content);
		anonymity.setScope(scope);
		
		AnonymityDAO dao = new AnonymityDAO();
		
		try {
			dao.insertAnonymity(anonymity);
			
			res.sendRedirect("/OurCommunity/jsp/community/anonymity/list.jsp");
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
}
