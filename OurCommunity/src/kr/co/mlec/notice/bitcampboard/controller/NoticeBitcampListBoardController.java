package kr.co.mlec.notice.bitcampboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampBoardDAO;
import kr.co.mlec.notice.bitcampboard.vo.NoticeBitcampBoardVO;

@WebServlet("/bitcampboard/NoticeBitcampListBoardController")
public class NoticeBitcampListBoardController extends HttpServlet {
	final int page = 20;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String pageNum = req.getParameter("pageNum");
		String search = req.getParameter("search");
		String searchCategory = req.getParameter("searchCategory");
		
		if(pageNum==null)
			pageNum="1";
		
		if(search==null)
			search="";
		
		int pagingNum = 0;
		
		if(searchCategory==null)
			searchCategory="1";

		List<NoticeBitcampBoardVO> list = new ArrayList<>();
		NoticeBitcampBoardDAO dao = new NoticeBitcampBoardDAO();

		int pageStart = 1 + ((Integer.parseInt(pageNum)-1)*page);	//1	21
		int pageEnd = Integer.parseInt(pageNum)*page;	//20	40

		try {
			if (search!="") {
				if (searchCategory.equals("1")) {
					list = dao.selectBitcampBoardTitle(pageStart, pageEnd, search);
					pagingNum = dao.selectBitcampBoardTitle(search);
				} else if (searchCategory.equals("2")) {
					list = dao.selectBitcampBoardContent(pageStart, pageEnd, search);
					pagingNum = dao.selectBitcampBoardContent(search);
				} else if (searchCategory.equals("3")) {
					list = dao.selectBitcampBoardId(pageStart, pageEnd, search);
					pagingNum = dao.selectBitcampBoardId(search);
				}
			} 
			
			else if(search=="") {
				list = dao.selectBitcampBoard(pageStart, pageEnd);
				pagingNum = dao.selectBitcampBoard();
			}
			
			
			req.setAttribute("list", list);
			
			HttpSession session = req.getSession();
			String grade = (String) session.getAttribute("grade");
			String userId = (String) session.getAttribute("userId");
			req.setAttribute("grade", grade);
			req.setAttribute("userId", userId);

			int leng = (int) Math.ceil(pagingNum / (double) page);
			req.setAttribute("paging", leng);
			req.setAttribute("search", search);
			req.setAttribute("searchCategory", searchCategory);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/bitcampboard/listnoticebitcampboard.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
