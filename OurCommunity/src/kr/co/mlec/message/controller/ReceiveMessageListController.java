package kr.co.mlec.message.controller;

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

import kr.co.mlec.message.dao.MessageDAO;
import kr.co.mlec.message.vo.MessageVO;

@WebServlet("/message/receivelist")
public class ReceiveMessageListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		List<MessageVO> list = new ArrayList();
		
		HttpSession session = req.getSession();
		
		MessageDAO dao = new MessageDAO();
		String id = (String) session.getAttribute("userId");
		
		try {
			list = dao.selectReceiveMessage(id);
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/message/receivemessageboard.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
