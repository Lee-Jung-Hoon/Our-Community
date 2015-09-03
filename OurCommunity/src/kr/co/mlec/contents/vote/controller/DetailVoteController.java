package kr.co.mlec.contents.vote.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.contents.dao.VoteBoardDAO;
import kr.co.mlec.contents.vo.VoteBoardVO;
import kr.co.mlec.contents.vo.VoteItemsVO;

@WebServlet("/vote/detailVote")
public class DetailVoteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8"); 
		
		VoteBoardDAO dao = new VoteBoardDAO();
		try {
			
			String v_no = req.getParameter("v_no");
			dao.insertClicks(v_no);
			
			//System.out.println("디테일 넘버 : " + v_no );
			VoteBoardVO list = dao.selectDetail(v_no);
			List<VoteItemsVO> ilist = dao.selectItems(v_no);

			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("userId");
			req.setAttribute("id", id);
			req.setAttribute("list", list);
			req.setAttribute("ilist", ilist);
			
			// 공유 영역 데이터를 사용하기 위해서 forward 방식으로 이동
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/contents/vote/detailVote.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}
	

}
