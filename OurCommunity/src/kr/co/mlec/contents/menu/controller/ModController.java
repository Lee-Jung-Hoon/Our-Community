package kr.co.mlec.contents.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.contents.dao.RecommendMenuDAO;
import kr.co.mlec.contents.vo.RecommendMenuVO;

@WebServlet("/mod")
public class ModController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RecommendMenuDAO dao = new RecommendMenuDAO();
		try {
			RecommendMenuVO menu = dao.selectDetailMenu(Integer.parseInt(req.getParameter("num")));
			req.setAttribute("menu", menu);
			RequestDispatcher r = req.getRequestDispatcher("/jsp/contents/menu/modForm.jsp");
			r.forward(req, res);
		} catch (Exception e) {
		}
	}
	

}
