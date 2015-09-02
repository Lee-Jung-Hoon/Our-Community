package kr.co.mlec.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;

@WebServlet("/Anonymity/delete")
public class AnonymityDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		
		AnonymityDAO dao = new AnonymityDAO();
		
		try {
			dao.DeleteAnonymity(no);
			
			res.sendRedirect("/OurCommunity/Anonymity/list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
