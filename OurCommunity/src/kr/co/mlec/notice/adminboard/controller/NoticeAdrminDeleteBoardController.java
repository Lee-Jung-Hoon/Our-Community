package kr.co.mlec.notice.adminboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.adminboard.dao.NoticeAdminBoardDAO;

@WebServlet("/adminboard/NoticeAdrminDeleteBoardController")
public class NoticeAdrminDeleteBoardController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		String no = req.getParameter("no");
		
		NoticeAdminBoardDAO dao = new NoticeAdminBoardDAO();
		try {
			dao.deleteAdminBoard(no);
			res.sendRedirect("/OurCommunity/adminboard/NoticeAdminListBoardController");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
