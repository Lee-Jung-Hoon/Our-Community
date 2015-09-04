package kr.co.mlec.message.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.message.dao.MessageDAO;
import kr.co.mlec.message.vo.MessageVO;
@WebServlet("/message/receivedetailmessage")

public class ReceiveMessageDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		String no = req.getParameter("no");
		MessageVO message = new MessageVO();
		MessageDAO dao = new MessageDAO();
		
		try {
			dao.updateReadMessage(no);
			message = dao.selectReceiveMessage(Integer.parseInt(no));
			req.setAttribute("message", message);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/message/receivedetailmessage.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
