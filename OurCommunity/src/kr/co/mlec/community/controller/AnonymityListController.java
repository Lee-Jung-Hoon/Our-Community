package kr.co.mlec.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.dao.AnonymityDAO;
import kr.co.mlec.community.vo.AnonymityCommentVO;
import kr.co.mlec.community.vo.AnonymityVO;

@WebServlet("/Anonymity/list")
public class AnonymityListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageCount = 3;
		req.setCharacterEncoding("UTF-8");
		
		String page = req.getParameter("page");
		
		if(page == null){
			page = "1";
		}
		
		int endNum = pageCount * Integer.parseInt(page);
		int startNum = endNum - pageCount + 1;
		
		String type = req.getParameter("searchType");
		String text = req.getParameter("text");
		
		AnonymityDAO dao = new AnonymityDAO();
		int count = 0;
		
		try {
			if (type == null || type == "") {
				System.out.println("listAll");
				count = dao.selectListCount();
				List<AnonymityVO> list = dao.selectAnonymityBoard(startNum, endNum);
				req.setAttribute("board", list);
				count = dao.selectListCount();
			} else {
				System.out.println("listSearch");
				List<AnonymityVO> list = dao.searchAnonymityBoard(type, text, startNum, endNum);
				count = dao.selectSearchListCount(type, text);
				req.setAttribute("board", list);
				req.setAttribute("type", type);
				req.setAttribute("text", text);
			}
			int pageLeng = (int)Math.ceil(count/(double)pageCount);
			System.out.println("pageLeng : " + pageLeng);
			req.setAttribute("page", pageLeng);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/anonymity/list.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
/* "select id, no, title, boardhead, CHECK_CNT, reg_date "
               + " from (select no, title, id, boardhead , CHECK_CNT, rownum rnum, reg_date "
               + " from( select no, title , id, boardhead, CHECK_CNT, reg_date "
               + " from t_notice_bitcamp_board "
               + " order by reg_date desc)) "
               + "   where rnum between ? and ? ";
 */
