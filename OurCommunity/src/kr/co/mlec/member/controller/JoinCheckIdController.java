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

@WebServlet("/member/chkId")
public class JoinCheckIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/Html; charset=UTF-8");
		
		
		String id = req.getParameter("id");
		
		
		memberVO vo =  new memberVO();
		
		vo.setId(id);
		
		MemberDAO dao =  new MemberDAO();
		
		boolean bl;
		try {
			bl = dao.checkId(vo);
			
			req.setAttribute("bl", bl);
			req.setAttribute("id", id);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/checkId.jsp");
			rd.forward(req, resp);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
	
}
