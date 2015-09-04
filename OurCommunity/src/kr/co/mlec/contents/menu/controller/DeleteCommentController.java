package kr.co.mlec.contents.menu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.RecommendMenuDAO;

@WebServlet("/comment/delete")
public class DeleteCommentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		int num = Integer.parseInt(req.getParameter("num"));
		RecommendMenuDAO dao = new RecommendMenuDAO();
		try {
			dao.deleteComment(no);
			res.sendRedirect("/OurCommunity/menu/detail?num="+num);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
