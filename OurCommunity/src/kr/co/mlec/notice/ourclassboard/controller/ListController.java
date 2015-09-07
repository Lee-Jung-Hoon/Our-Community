package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.BoardDAO;
import kr.co.mlec.notice.ourclassboard.vo.BoardVO;

@WebServlet("/ourclassboard/list")
public class ListController extends HttpServlet {
	final int page = 5;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		BoardDAO dao = new BoardDAO();

		String pageNum = req.getParameter("pageNum");
		String search = req.getParameter("search");
		String searchCategory = req.getParameter("searchCategory");

		if (pageNum == null)
			pageNum = "1";

		if (search == null)
			search = "";

		int pagingNum = 0;

		if (searchCategory == null)
			searchCategory = "1";

		List<BoardVO> list = new ArrayList<>();

		int pageStart = 1 + ((Integer.parseInt(pageNum) - 1) * page); // 1 21
		int pageEnd = Integer.parseInt(pageNum) * page; // 20 40

		try {

			if (search == "") {
				list = dao.searchBoard(pageStart, pageEnd);
				pagingNum = dao.selectBoardCnt();
			} else if (search != "") {
				list = dao.searchBoard(pageStart, pageEnd, searchCategory ,search);
				pagingNum = dao.selectBoardCnt(searchCategory, search);
			}

			String type = req.getParameter("type");
			if (type != null) {
				// 등록 후 호출
				if (type.equals("C")) {
					req.setAttribute("msg", "게시물이 등록되었습니다.");
				}
				// 삭제후 호출
				else if (type.equals("D")) {
					req.setAttribute("msg", "게시물이 삭제되었습니다.");
				}
			}

			req.setAttribute("list", list);

			int leng = (int) Math.ceil(pagingNum / (double) page);
			req.setAttribute("paging", leng);
			req.setAttribute("search", search);
			req.setAttribute("searchCategory", searchCategory);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/ourclassboard/list.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}