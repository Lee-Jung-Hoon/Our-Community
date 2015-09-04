package kr.co.mlec.community.gallery.controller;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/gallery/detail")
public class GalleryDetailController extends HttpServlet {

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");

		String no = req.getParameter("no");

		GalleryDAO dao = new GalleryDAO();
		GalleryVO vo = new GalleryVO();
		
		GallCommentDAO cDao = new GallCommentDAO();
		GallCommentVO cVO = new GallCommentVO();
		
		vo.setNo(Integer.parseInt(no));

		cVO.setBoardNo(Integer.parseInt(no));
		
		try {
			vo = dao.insertChkCnt(vo);
			vo = dao.selectNO(vo);
			GallCommentCntVO cntVO = cDao.selectCommentNoCnt(cVO);

			ArrayList<GallCommentVO> list = cDao.selectComment(cVO);
			
			
			req.setAttribute("vo", vo);
			req.setAttribute("cList", list);
			req.setAttribute("cntVO", cntVO);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/gallery/detail.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
