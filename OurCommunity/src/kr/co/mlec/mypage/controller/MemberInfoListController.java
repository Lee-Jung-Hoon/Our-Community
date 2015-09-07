package kr.co.mlec.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.mypage.dao.MemberInfoDAO;
import kr.co.mlec.mypage.vo.MemberInfoVO;

@WebServlet("/memberInfo/list")
public class MemberInfoListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		MemberInfoDAO dao = new MemberInfoDAO();
		
		try {
			
			List<MemberInfoVO> mList = dao.selectMember();
			req.setAttribute("mList", mList);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/mypage/memberInfo/MemberList.jsp");
			rd.forward(req, res);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}
}
