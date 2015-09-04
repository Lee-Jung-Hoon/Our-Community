package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.CommentDAO;
import kr.co.mlec.notice.ourclassboard.vo.CommentVO;


@WebServlet("/ourclassboard/commentDelete")
public class CommentDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String no = req.getParameter("no");
			String commentNo = req.getParameter("commentNo");
			
			CommentVO comment = new CommentVO();
			comment.setCommentNo(commentNo);
			
			CommentDAO cdao = new CommentDAO();
			
			try {
				cdao.deleteComment(comment);
				
				RequestDispatcher rd = req.getRequestDispatcher("/ourclassboard/detail?no=" + no);
				rd.forward(req, res);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
	}
}