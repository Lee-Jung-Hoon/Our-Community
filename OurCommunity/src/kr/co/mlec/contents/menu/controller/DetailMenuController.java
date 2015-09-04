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
import kr.co.mlec.contents.vo.MenuCommentVO;
import kr.co.mlec.contents.vo.RecommendMenuVO;

@WebServlet("/menu/detail")
public class DetailMenuController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		RecommendMenuDAO dao = new RecommendMenuDAO();
		try {
			RecommendMenuVO menu = dao.selectDetailMenu(num);
			dao.updateCount(num);
			req.setAttribute("menu", menu);
			List<MenuCommentVO> list = dao.selectComment(num);
			req.setAttribute("list", list);
			RequestDispatcher r = req.getRequestDispatcher("/jsp/contents/menu/detailForm.jsp");
			r.forward(req, res);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
