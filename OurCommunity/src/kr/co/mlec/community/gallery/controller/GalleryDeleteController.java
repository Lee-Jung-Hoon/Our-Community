package kr.co.mlec.community.gallery.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.gallery.comment.dao.GallCommentDAO;
import kr.co.mlec.community.gallery.comment.vo.GallCommentCntVO;
import kr.co.mlec.community.gallery.comment.vo.GallCommentVO;
import kr.co.mlec.community.gallery.dao.GalleryDAO;
import kr.co.mlec.community.gallery.vo.GalleryVO;

@WebServlet("/gallery/delete")
public class GalleryDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; UTF-8");

		String no = req.getParameter("no");

		GalleryDAO dao = new GalleryDAO();
		GalleryVO vo = new GalleryVO();

		vo.setNo(Integer.parseInt(no));

		try {
			dao.deleteVO(vo);

			resp.sendRedirect("/OurCommunity/gallery/list");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
