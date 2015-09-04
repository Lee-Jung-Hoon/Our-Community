package kr.co.mlec.contents.menu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.RecommendMenuDAO;
import kr.co.mlec.contents.vo.MenuCommentVO;

@WebServlet("/comment/regist")
public class RegistCommentController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(req.getParameter("num"));
		RecommendMenuDAO dao = new RecommendMenuDAO();
		MenuCommentVO comment = new MenuCommentVO();
		comment.setId(req.getParameter("id"));
		comment.setMenuComment(req.getParameter("content"));
		comment.setNum(num);
		System.out.println(num);
		try {
			dao.insertComment(comment);
			res.sendRedirect("/OurCommunity/menu/detail?num="+num);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
