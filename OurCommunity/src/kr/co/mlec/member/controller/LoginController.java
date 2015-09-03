package kr.co.mlec.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.memberVO;

@WebServlet("/join/LoginController")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		try {
			memberVO member = dao.selectMember(id, password);
			if(member.getId()==null)	// 아이디나 비밀번호가 틀리거나 없을 경우
				res.sendRedirect("/OurCommunity/jsp/member/login.html");
			else  {						// 로그인 성공
				System.err.println("로그인 성공");
				HttpSession session = req.getSession();
				session.setAttribute("userId", id);
				session.setAttribute("grade", member.getGrade());
				System.err.println( member.getGrade());
				res.sendRedirect("/OurCommunity/jsp/main/index.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
