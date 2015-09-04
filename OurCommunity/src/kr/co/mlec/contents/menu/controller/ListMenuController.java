package kr.co.mlec.contents.menu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.RecommendMenuDAO;
import kr.co.mlec.contents.vo.RecommendMenuVO;

@WebServlet("/menu/list")
public class ListMenuController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageCount = 4;
		RecommendMenuDAO dao = new RecommendMenuDAO();
		String pageNum = req.getParameter("pageNum");
		String type = req.getParameter("type");
		String search = req.getParameter("search");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int endNum = pageCount * Integer.parseInt(pageNum);
		int startNum = endNum - pageCount + 1;
		
		try {
			int page = 0;
			if(type == null || type == ""){
				page = dao.selectListCount();
				List<RecommendMenuVO> list = dao.selectListMenu(startNum, endNum);
				req.setAttribute("list", list);
			} else {
				page = dao.selectSearchListCount(type, search);
				List<RecommendMenuVO> list = dao.selectListSearchMenu(startNum, endNum, search, type);
				req.setAttribute("list", list);
				req.setAttribute("type", type);
				req.setAttribute("search", search);
			}
			int pageLeng = (int)Math.ceil(page / (double)pageCount);
			req.setAttribute("pageLeng", pageLeng);
			
			RequestDispatcher r = req.getRequestDispatcher("/jsp/contents/menu/listForm.jsp");
			r.forward(req, res);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
