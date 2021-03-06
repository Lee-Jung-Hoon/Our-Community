package kr.co.mlec.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.memberVO;

@WebServlet("/join/MemberJoinController")
public class MemberJoinController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		memberVO member = new memberVO();
		member.setName(req.getParameter("name"));
		member.setId(req.getParameter("id"));
		member.setPassword(req.getParameter("password"));
		member.setTel(req.getParameter("tel"));
		member.setGender(req.getParameter("gender"));
		member.setEmailId(req.getParameter("emailId"));
		member.setEmailDomain(req.getParameter("emailDomain"));
		member.setAddress(req.getParameter("address"));
		member.setHint(req.getParameter("hint"));
		member.setHintAnswer(req.getParameter("hintAnswer"));
		
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMember(member);
			req.setAttribute("msg", "회원가입을 완료했습니다.");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
