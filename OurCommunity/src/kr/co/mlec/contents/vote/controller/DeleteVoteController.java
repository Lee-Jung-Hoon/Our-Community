package kr.co.mlec.contents.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.mlec.contents.dao.VoteBoardDAO;
import kr.co.mlec.contents.vo.VoteBoardVO;

@WebServlet("/vote/deleteVote")
public class DeleteVoteController extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");

		VoteBoardDAO dao = new VoteBoardDAO();
		try {
			String v_no = req.getParameter("v_no");
			
			dao.deleteVote(v_no);
			res.sendRedirect("/OurCommunity/vote/listVote");
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	

}
