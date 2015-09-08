package kr.co.mlec.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.mypage.dao.MemberInfoDAO;
import kr.co.mlec.mypage.vo.MemberInfoVO;

@WebServlet("/memberInfo/detail")
public class MemberInfoDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String secession = req.getParameter("secession");
		MemberInfoDAO dao = new MemberInfoDAO();
		
		try {
			MemberInfoVO memberDetail = dao.selectDetailMember(id);
			req.setAttribute("secession", secession);
			req.setAttribute("memberDetail", memberDetail);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/mypage/memberInfo/memberDetail.jsp");
			rd.forward(req, res);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
