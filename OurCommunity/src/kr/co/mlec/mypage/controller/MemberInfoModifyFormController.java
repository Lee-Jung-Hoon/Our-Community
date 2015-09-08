package kr.co.mlec.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.mypage.dao.MemberInfoDAO;
import kr.co.mlec.mypage.vo.MemberInfoVO;

@WebServlet("/memberInfo/modifyForm")
public class MemberInfoModifyFormController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		
		MemberInfoDAO dao = new MemberInfoDAO();
		try{
			MemberInfoVO update = dao.selectDetailMember(id);
			req.setAttribute("update", update);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/mypage/memberInfo/memberModify.jsp");
			rd.forward(req, res);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}
}
