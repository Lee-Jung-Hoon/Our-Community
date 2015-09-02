package kr.co.mlec.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;
import kr.co.mlec.community.vo.AnonymityVO;

@WebServlet("/Anonymity/modify")
public class AnonymityModifyController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		AnonymityVO anonymity = new AnonymityVO();
		anonymity.setNo(no);
		anonymity.setTitle(title);
		anonymity.setContent(content);
		
		AnonymityDAO dao = new AnonymityDAO();
		
		try {
			dao.updateAnonymity(anonymity);
			
			res.sendRedirect("/OurCommunity/Anonymity/detail?no="+no);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
