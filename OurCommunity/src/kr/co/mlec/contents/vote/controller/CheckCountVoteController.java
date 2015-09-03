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

@WebServlet("/web/checkVote")
public class CheckCountVoteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8"); 
		
		VoteBoardDAO dao = new VoteBoardDAO();
		
		String v_no = req.getParameter("v_no");
		String voteSubmit = req.getParameter("voteSubmit");
		
		System.out.println("v_no : " + v_no);
		System.out.println("voteSubmit : " + voteSubmit);
		
		VoteItemsVO item = new VoteItemsVO();
		item.setV_no(v_no);
		item.setSubsection(voteSubmit);
		try {
			dao.updateVote(item);		
			
		} catch (Exception e) {
			throw new ServletException(e);			
		}
		
		res.sendRedirect("/OurCommunity/vote/detailVote?v_no=" + v_no);
	}
}
