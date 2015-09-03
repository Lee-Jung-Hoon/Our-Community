package kr.co.mlec.notice.bitcampboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.bitcampboard.dao.NoticeBitcampBoardDAO;

@WebServlet("/bitcampboard/NoticeBitcampDeleteBoardController")
public class NoticeBitcampDeleteBoardController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		String no = req.getParameter("no");
		
		NoticeBitcampBoardDAO dao = new NoticeBitcampBoardDAO();
		try {
			dao.deleteBitcampBoard(no);
			res.sendRedirect("/OurCommunity/bitcampboard/NoticeBitcampListBoardController");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
