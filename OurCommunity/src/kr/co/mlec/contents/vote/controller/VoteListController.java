package kr.co.mlec.contents.vote.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.VoteBoardDAO;
import kr.co.mlec.contents.vo.VoteBoardVO;


@WebServlet("/vote/listVote")
public class VoteListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		VoteBoardDAO dao = new VoteBoardDAO();
		try {
			List<VoteBoardVO> list = dao.selectList();
			req.setAttribute("list", list);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/contents/vote/listVote.jsp");
			rd.forward(req, res);			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	

}
 