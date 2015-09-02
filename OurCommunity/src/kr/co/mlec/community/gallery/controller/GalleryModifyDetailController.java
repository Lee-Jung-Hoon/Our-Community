package kr.co.mlec.community.gallery.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.community.gallery.dao.GalleryDAO;
import kr.co.mlec.community.gallery.vo.GalleryVO;
@WebServlet("/gallery/modifyDetail")
public class GalleryModifyDetailController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");

		String no = req.getParameter("no");

		GalleryDAO dao = new GalleryDAO();
		GalleryVO vo = new GalleryVO();

		vo.setNo(Integer.parseInt(no));

		try {
			vo = dao.insertChkCnt(vo);
			vo = dao.selectNO(vo);

			req.setAttribute("vo", vo);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/community/gallery/update.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
