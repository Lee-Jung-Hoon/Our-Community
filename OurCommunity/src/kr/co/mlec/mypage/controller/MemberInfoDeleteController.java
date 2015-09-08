package kr.co.mlec.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.mypage.dao.MemberInfoDAO;

@WebServlet("/memberInfo/delete")
public class MemberInfoDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		System.out.println("delet부분입니다."+id + "" + name);
		
		MemberInfoDAO dao = new MemberInfoDAO();
		
		try {
			dao.updateSecessionMember(id);
			
			res.sendRedirect("/OurCommunity/memberInfo/detail?id="+id);
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
