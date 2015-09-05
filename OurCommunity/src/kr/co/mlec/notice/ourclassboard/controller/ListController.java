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
import kr.co.mlec.notice.ourclassboard.vo.BoardVO;


@WebServlet("/ourclassboard/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html; charset=utf-8");
			BoardDAO dao = new BoardDAO();
			
			
			try {
				String type = req.getParameter("type");
				if (type != null) {

					//등록 후 호출
					if (type.equals("C")) {
						req.setAttribute("msg","게시물이 등록되었습니다.");
					}
					
					// 삭제후 호출
					else if (type.equals("D")) {
					req.setAttribute("msg","게시물이 삭제되었습니다.");
					}
					
				}
				List<BoardVO> list = dao.selectBoard();
				req.setAttribute("list", list);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/notice/ourclassboard/list.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
	}
}