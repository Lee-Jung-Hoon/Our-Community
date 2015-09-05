package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.CommentDAO;
import kr.co.mlec.notice.ourclassboard.vo.CommentVO;


@WebServlet("/ourclassboard/commentWrite")
public class CommentWriteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("no");
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		
		CommentVO comment = new CommentVO();
		comment.setNo(no);
		comment.setId(id);
		comment.setContent(content);
		
		CommentDAO cdao = new CommentDAO();
		
		try {
			cdao.insertComment(comment);
			res.sendRedirect("/OurCommunity/ourclassboard/detail?no=" + no);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
