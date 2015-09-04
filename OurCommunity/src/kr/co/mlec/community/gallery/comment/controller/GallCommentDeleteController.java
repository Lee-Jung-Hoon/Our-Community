package kr.co.mlec.community.gallery.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.gallery.comment.dao.GallCommentDAO;
import kr.co.mlec.community.gallery.comment.vo.GallCommentVO;
import kr.co.mlec.community.gallery.dao.GalleryDAO;
import kr.co.mlec.community.gallery.vo.GalleryVO;

@WebServlet("/gellery/comment/delete")
public class GallCommentDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");

		String no = req.getParameter("no");
		String coNo = req.getParameter("coNo");
		String id = req.getParameter("id");
		GallCommentVO vo = new GallCommentVO();
		GallCommentDAO dao = new GallCommentDAO();

		vo.setBoardNo(Integer.parseInt(no));
		vo.setCommentNo(Integer.parseInt(coNo));
		vo.setId(id);

		try {
			dao.deleteVO(vo);

			resp.sendRedirect("/OurCommunity/gallery/list");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	
}
