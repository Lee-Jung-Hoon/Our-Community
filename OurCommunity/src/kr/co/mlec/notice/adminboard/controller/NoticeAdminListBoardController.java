package kr.co.mlec.notice.adminboard.controller;

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

import kr.co.mlec.notice.adminboard.dao.NoticeAdminBoardDAO;
import kr.co.mlec.notice.adminboard.vo.NoticeAdminBoardVO;

@WebServlet("/adminboard/NoticeAdminListBoardController")
public class NoticeAdminListBoardController extends HttpServlet {
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

		List<NoticeAdminBoardVO> list = new ArrayList<>();
		NoticeAdminBoardDAO dao = new NoticeAdminBoardDAO();

		int pageStart = 1 + ((Integer.parseInt(pageNum)-1)*page);	//1	21
		int pageEnd = Integer.parseInt(pageNum)*page;	//20	40

		try {
			if (search!="") {
				if (searchCategory.equals("1")) {
					list = dao.selectAdminBoardTitle(pageStart, pageEnd, search);
					pagingNum = dao.selectAdminBoardTitle(search);
				} else if (searchCategory.equals("2")) {
					list = dao.selectAdminBoardContent(pageStart, pageEnd, search);
					pagingNum = dao.selectAdminBoardContent(search);
				} else if (searchCategory.equals("3")) {
					list = dao.selectAdminBoardId(pageStart, pageEnd, search);
					pagingNum = dao.selectAdminBoardId(search);
				}
			} 
			
			else if(search=="") {
				list = dao.selectAdminBoard(pageStart, pageEnd);
				pagingNum = dao.selectAdminBoard();
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
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/adminboard/listnoticeadminboard.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
