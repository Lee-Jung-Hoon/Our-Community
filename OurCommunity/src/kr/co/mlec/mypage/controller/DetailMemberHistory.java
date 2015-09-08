package kr.co.mlec.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.mypage.dao.MemberHistoryDAO;
import kr.co.mlec.mypage.vo.MemberHistoryVO;

@WebServlet("/mypage/detailMemberHistory")
public class DetailMemberHistory extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");		
		MemberHistoryDAO dao = new MemberHistoryDAO();
		
		List<MemberHistoryVO> list = new ArrayList<>();
		
		try {
			list = dao.selectMemberInfo(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("Hlist", list);
		req.setAttribute("id", id);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/mypage/memberhistory/HistoryList.jsp");
		rd.forward(req, resp);
	}
}
