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
import kr.co.mlec.community.gallery.dao.GalleryDAO;
import kr.co.mlec.community.gallery.vo.GalleryVO;

@WebServlet("/gallery/search")
public class GallerySearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=UTF-8");
		
		req.getParameter("select");
		req.getParameter("search");
		
		
		ArrayList<GalleryVO> list = new ArrayList<>();
		GalleryDAO dao = new GalleryDAO();
		
		GallCommentDAO cDao = new GallCommentDAO();
		
		String pageNum = req.getParameter("page");
		int sizePage = 0;
		try {
			
			
			if(pageNum == null){
			 sizePage = 1;
			}else{
				sizePage = Integer.parseInt(pageNum);
			}

			list = dao.selectVO(sizePage);
			int size = dao.selectPage();
			
			ArrayList<GallCommentCntVO> cntList = cDao.selectCommentCnt();
			
			req.setAttribute("list", list);
			req.setAttribute("cntList", cntList);
			req.setAttribute("size", size);
			
			

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/gallery/list.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	
}
