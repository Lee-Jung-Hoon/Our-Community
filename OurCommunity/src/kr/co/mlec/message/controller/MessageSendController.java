package kr.co.mlec.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.message.dao.MessageDAO;
import kr.co.mlec.message.vo.MessageVO;
@WebServlet("/message/MessageSendController")
public class MessageSendController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String sendId = req.getParameter("sendId");
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("userId");
		
		MessageVO message = new MessageVO();
		message.setSendId(sendId);
		message.setContent(content);
		message.setTitle(title);
		message.setId(id);
		
		MessageDAO dao = new MessageDAO();
		try {
			dao.sendMessage(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("/OurCommunity/jsp/message/messagemain.jsp");
	}
}
