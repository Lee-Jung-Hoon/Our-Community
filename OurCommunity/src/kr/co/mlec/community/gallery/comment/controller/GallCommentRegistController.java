package kr.co.mlec.community.gallery.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.gallery.comment.dao.GallCommentDAO;
import kr.co.mlec.community.gallery.comment.vo.GallCommentVO;


@WebServlet("/gallery/comment/regist")
public class GallCommentRegistController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setCharacterEncoding("UTF-8");		

		GallCommentDAO dao = new GallCommentDAO();
		GallCommentVO vo = new GallCommentVO();
	
		String no = req.getParameter("no");
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		
		vo.setBoardNo(Integer.parseInt(no));
		vo.setId(id);
		vo.setCommentContent(content);
		
		try {
			dao.insertComment(vo);
			
			
			resp.sendRedirect("/OurCommunity/gallery/detail?no="+vo.getBoardNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
}
