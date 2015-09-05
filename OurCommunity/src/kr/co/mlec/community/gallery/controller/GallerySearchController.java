package kr.co.mlec.community.gallery.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.community.gallery.comment.dao.GallCommentDAO;
import kr.co.mlec.community.gallery.comment.vo.GallCommentCntVO;
import kr.co.mlec.community.gallery.dao.GalleryDAO;
import kr.co.mlec.community.gallery.dao.GallerySearchDAO;
import kr.co.mlec.community.gallery.vo.GalleryVO;

@WebServlet("/gallery/search")
public class GallerySearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=UTF-8");
		
		String select = req.getParameter("select");
		String search = req.getParameter("search");
		
	
		
		
		
		ArrayList<GalleryVO> list = new ArrayList<>();
		GalleryDAO dao = new GalleryDAO();
	    HttpSession session = req.getSession();
	    
	     String userId = (String) session.getAttribute("userId");
		
		GallCommentDAO cDao = new GallCommentDAO();
		GallerySearchDAO sDao = new GallerySearchDAO();
		String pageNum = req.getParameter("page");
		int sizePage = 0;
		try {
			
			
			if(pageNum == null){
			 sizePage = 1;
			}else{
				sizePage = Integer.parseInt(pageNum);
			}		
			int size = 0;
			if( userId != null ){
				
				
				switch(select){
				case "0":
					
					list = sDao.selectSearchAll(sizePage, search);
					size = sDao.selectPageSearchAll(search);
					break;
				case "1":
					
					list = sDao.selectSearchTitle(sizePage, search);
					size = sDao.selectPageSearchTitle(search);
					
					break;
				case "2":
					
					list = sDao.selectSearchContent(sizePage, search);
					size = sDao.selectPageSearchContent(search);
					
					break;
				case "3":

						list = sDao.selectSearchId(sizePage, search);
				size = sDao.selectPageSearchId(search);
					
					break;
				}
				
				
				
				
			}else{
				
				list = dao.selectNotUserVO(sizePage);
				size = dao.selectPageNotUser();
				
			}
			
			
			
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
