package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.BoardDAO;


@WebServlet("/ourclassboard/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String no = req.getParameter("no");
			BoardDAO dao = new BoardDAO();
			try{
					dao.deleteBoard(no);
					res.sendRedirect("/Community/ourclassboard/list?type=D");
			}catch(Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
	}
}