package kr.co.mlec.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.memberVO;
import kr.co.mlec.mypage.dao.personalInfoDAO;

@WebServlet("/mypage/personalUpdate")
public class PersonalUpdateController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		personalInfoDAO dao = new personalInfoDAO();
		memberVO member = new memberVO();
		member.setName(req.getParameter("name"));
		member.setPassword(req.getParameter("password"));
		member.setTel(req.getParameter("tel"));
		member.setGender(req.getParameter("gender"));
		member.setEmailId(req.getParameter("emailId"));
		member.setEmailDomain(req.getParameter("emailDomain"));
		member.setAddress(req.getParameter("address"));
		member.setHint(req.getParameter("hint"));
		member.setHintAnswer(req.getParameter("hintAnswer"));
		
		try {
			dao.updatePersonalInfo(member);
			
			req.setAttribute("msg", "회원정보를 수정했습니다.");
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/mypage/myPage.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
