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


@WebServlet("/vote/listVote")
public class VoteListController extends HttpServlet{
	final int page = 20;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		String pageNum = req.getParameter("pageNum");
		int pagingNum = 0;
		if(pageNum==null){
			pageNum="1";
		}
		VoteBoardDAO dao = new VoteBoardDAO();
		
		int start = 1 + ((Integer.parseInt(pageNum)-1)*page);
		int end = Integer.parseInt(pageNum)*page;
		
		try {
			
			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("userId");
			req.setAttribute("userId", id);
			
			pagingNum = dao.selectPageNum();
			List<VoteBoardVO> list = dao.selectList(start,end);
			req.setAttribute("list", list);
			
			
			int leng = (int) Math.ceil(pagingNum / (double) page);
			System.err.println(pagingNum);
			req.setAttribute("paging", leng);
			System.err.println(leng);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/contents/vote/listVote.jsp");
			rd.forward(req, res);			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	

}
 