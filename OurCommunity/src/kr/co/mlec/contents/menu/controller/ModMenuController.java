package kr.co.mlec.contents.menu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.RecommendMenuDAO;
import kr.co.mlec.contents.vo.RecommendMenuVO;

@WebServlet("/menu/mod")
public class ModMenuController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(req.getParameter("num"));

		RecommendMenuVO menu = new RecommendMenuVO();
		menu.setTitle(req.getParameter("title"));
		menu.setContent(req.getParameter("content"));
		menu.setNum(num);
		
		RecommendMenuDAO dao = new RecommendMenuDAO();
		try {
			dao.updateMenu(menu);
			res.sendRedirect("/OurCommunity/menu/detail?num="+num);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
}
