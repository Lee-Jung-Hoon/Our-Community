package kr.co.mlec.contents.menu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.contents.dao.RecommendMenuDAO;
import kr.co.mlec.contents.vo.RecommendMenuVO;

@WebServlet("/menu/regist")
public class RegistMenuController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		RecommendMenuVO menu = new RecommendMenuVO();
		menu.setTitle(req.getParameter("title"));
		menu.setRestaurantName(req.getParameter("restaurantName"));
		menu.setContent(req.getParameter("content"));
		menu.setLongitude(req.getParameter("longitude"));
		menu.setLatitude(req.getParameter("latitude"));

		HttpSession session = req.getSession();
		RecommendMenuDAO dao = new RecommendMenuDAO();
		try {
			//id받아오기
			String id = (String) session.getAttribute("userId");
			menu.setId(id);
			dao.insertRecommendMenu(menu);
			res.sendRedirect("/OurCommunity/menu/list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
