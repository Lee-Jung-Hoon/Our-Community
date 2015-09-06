package kr.co.mlec.community.studyFile.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.community.studyFile.dao.StudyFileDAO;
import kr.co.mlec.community.studyFile.vo.StudyFileVO;
import kr.co.mlec.util.MyFileRenamePolicy;

@WebServlet("/studyFile/update")
public class StudyFileUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		StudyFileDAO dao = new StudyFileDAO();

		Calendar cal = Calendar.getInstance(); // 날짜 객체를 불러옴
		String yStr = "" + (cal.get(Calendar.YEAR)); // 년도
		String mStr = "" + (cal.get(Calendar.MONTH) + 1); // 월
		String dStr = "" + (cal.get(Calendar.DAY_OF_MONTH)); // 일

		if ((Calendar.MONTH + 1) < 10) {
			mStr = "0" + mStr;
		}
		if (Calendar.DAY_OF_MONTH < 10) {
			dStr = "0" + dStr;
		}

		String savePath = "C:\\Java73\\web-WorkSpace\\OurCommunity\\WebContent\\studyFile" + yStr + "/" + mStr + "/"
				+ dStr;
		savePath = req.getServletContext().getRealPath("/") + "studyFile\\" + yStr + "/" + mStr + "/" + dStr;
		String readPath = "C:\\Java73\\tomcat-work\\wtpwebapps\\OurCommunity\\studyFile\\" + yStr + "/" + mStr + "/"
				+ dStr;
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String encType = "UTF-8";
		int limitCapacity = 1024 * 1024 * 10;

		MultipartRequest multi = new MultipartRequest(req, savePath, limitCapacity, encType, new MyFileRenamePolicy());
		StudyFileVO file = new StudyFileVO();

		int no = Integer.parseInt(multi.getParameter("no")); 
		String title = multi.getParameter("title");
		String type = multi.getParameter("searchType");
		String content = multi.getParameter("content");
		String scope = multi.getParameter("scope");

		file.setNo(no);
		file.setTitle(title);
		file.setType(type);
		file.setContent(content);
		file.setScope(scope);

		@SuppressWarnings("unchecked")
		Enumeration<String> e = multi.getFileNames();
		// 저장된 파일이 있는지 확인
		while (e.hasMoreElements()) {
			String fileName = e.nextElement();
			File f = multi.getFile(fileName);

			if (f != null) {
				String realName = multi.getFilesystemName(fileName);
				String orignalName = multi.getOriginalFileName(fileName);

				file.setRealFileName(realName);
				file.setOriginFileName(orignalName);
				file.setFilePath(readPath);
			}
		}
		
		try {
			dao.updateStudyFile(file);
			res.sendRedirect("/OurCommunity/studyFile/detail?no="+no);
		} catch (Exception ea) {
			throw new ServletException(ea);
		}
	}
}
