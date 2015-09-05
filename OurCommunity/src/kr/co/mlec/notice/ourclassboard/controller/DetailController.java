package kr.co.mlec.notice.ourclassboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.notice.ourclassboard.DAO.BoardDAO;
import kr.co.mlec.notice.ourclassboard.DAO.CommentDAO;
import kr.co.mlec.notice.ourclassboard.vo.BoardVO;
import kr.co.mlec.notice.ourclassboard.vo.CommentVO;


@WebServlet("/ourclassboard/detail")
public class DetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html; charset=utf-8");
		
			String no = req.getParameter("no");
			
			BoardDAO dao = new BoardDAO();
			
			CommentDAO cdao = new CommentDAO(); 

			try {
				BoardVO board =  dao.selectBoardDt(no);
				req.setAttribute("board", board);
				
				dao.updateCheckCnt(no);
				
				List<CommentVO> list = cdao.selectComment(no);
				req.setAttribute("list", list);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/ourclassboard/detail.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
	}
}