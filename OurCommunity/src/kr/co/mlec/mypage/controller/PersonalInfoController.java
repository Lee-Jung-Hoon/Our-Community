package kr.co.mlec.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.member.vo.memberVO;
import kr.co.mlec.mypage.dao.personalInfoDAO;
@WebServlet("/mypage/personalInfo")
public class PersonalInfoController extends HttpServlet{

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	


	resp.setContentType("text/html; charset=UTF-8"); 
	
	
	
	HttpSession  session = req.getSession();
	String id = (String) session.getAttribute("userId");	
	
	
	
	memberVO vo = new memberVO();
	personalInfoDAO dao = new personalInfoDAO();
	
	vo.setId(id);
	try {
		vo = dao.selectAll(vo);
		
		req.setAttribute("vo", vo);
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/mypage/personalInfo/personalUpdateDetail.jsp");
		rd.forward(req, resp);
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
