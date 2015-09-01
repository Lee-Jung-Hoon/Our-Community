package kr.co.mlec.contents.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.VoteBoardDAO;
import kr.co.mlec.contents.vo.VoteBoardVO;
import kr.co.mlec.contents.vo.VoteItemsVO;


@WebServlet("/vote/registVote")
public class VoteRegistController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8"); 
		
		VoteBoardDAO dao = new VoteBoardDAO();
				
		String v_title = req.getParameter("v_title");
		String end_date = req.getParameter("end_date");
		String[] subsections = req.getParameterValues("addText[]");
		
		System.out.println(v_title);
		System.out.println(end_date);
		
		VoteBoardVO vote = new VoteBoardVO();
		vote.setV_title(v_title);
		vote.setEnd_date(end_date);
		try {
			dao.insertVote(vote);
			if (subsections != null) {
				for (String subsection : subsections) {
					VoteItemsVO items = new VoteItemsVO();
					System.out.println(subsection);
					items.setSubsection(subsection);
				}
			}
		} catch (Exception e) {
			throw new ServletException(e);			
		}
		
		
		res.sendRedirect("/OurCommunity/vote/");
		
	}
	

}
