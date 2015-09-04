package kr.co.mlec.contents.menu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.RecommendMenuDAO;

@WebServlet("/menu/delete")
public class DeleteMenuController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		RecommendMenuDAO dao = new RecommendMenuDAO();
		try {
			dao.deleteMenu(num);
			dao.deleteCommentAll(num);
			res.sendRedirect("/OurCommunity/menu/list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
