package kr.co.mlec.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.mypage.dao.MemberInfoDAO;
import kr.co.mlec.mypage.vo.MemberInfoVO;

@WebServlet("/memberInfo/modify")
public class MemberInfoUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String emailId = req.getParameter("emilId");
		String emailDomain = req.getParameter("emailDomain");
		String grade = req.getParameter("grade");
		String hint = req.getParameter("hint");
		String hintAnswer = req.getParameter("hintAnswer");
		
		MemberInfoVO member = new MemberInfoVO();
		member.setId(id);
		member.setName(name);
		member.setPassword(password);
		member.setEmailId(emailId);
		member.setEmailDomain(emailDomain);
		member.setGrade(grade);
		member.setHint(hint);
		member.setHintAnswer(hintAnswer);
		MemberInfoDAO dao = new MemberInfoDAO();
		try {
			
			dao.updateMember(member);
			res.sendRedirect("/OurCommunity/memberInfo/detail?id="+id+"&name="+name);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
