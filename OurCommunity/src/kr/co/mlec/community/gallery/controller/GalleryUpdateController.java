package kr.co.mlec.community.gallery.controller;

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

import kr.co.mlec.community.gallery.dao.GalleryDAO;
import kr.co.mlec.community.gallery.vo.GalleryVO;
import kr.co.mlec.util.MyFileRenamePolicy;

@WebServlet("/gallery/update")
public class GalleryUpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getServletContext().getRealPath("/"));
		System.out.println(req.getServletContext().getRealPath("/"));

		
		
		// 객체생성
		GalleryDAO dao = new GalleryDAO();
		GalleryVO vo = new GalleryVO();

		Calendar cal = Calendar.getInstance(); // 날짜 객체를 불러옴
		String yStr = "" + (cal.get(Calendar.YEAR)); // 년도
		String mStr = "" + (cal.get(Calendar.MONTH) + 1); // 월
		String dStr = "" + (cal.get(Calendar.DAY_OF_MONTH)); // 일

		// 10 미만인 숫자한테 앞에 0을 붙여준다.
		if ((Calendar.MONTH + 1) < 10) {
			mStr = "0" + mStr;
		}
		// 10 미만인 숫자한테 앞에 0을 붙여준다.
		if (Calendar.DAY_OF_MONTH < 10) {
			dStr = "0" + dStr;
		}

		// 사진들을 저장할 경로를 설정 : 년도 폴더 / 월 폴더 / 일 폴더

		String savePath = "C:\\java73\\web-workspace\\OurCommunity\\WebContent\\PothoGallery\\" + yStr + "/" + mStr
				+ "/" + dStr;
		savePath = this.getServletContext().getRealPath("/") + "PothoGallery\\" + yStr + "/" + mStr + "/" + dStr;
		System.out.println("savePath : " + savePath);

		String readPath = "/OurCommunity/PothoGallery/" + yStr + "/" + mStr + "/" + dStr;

		System.out.println(readPath);
		// 저장할 디렉토리가 없을시 디렉토리 자동 생성 : 날짜별 자동 폴더 생성
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// 인코딩할 타입을 설정
		String encType = "UTF-8";
		// 제한 용량을 설정 : 1024 * 1024 = 1MB
		int limitCapacity = 1024 * 1024 * 10;

		// ____________________________________________요청,___저장경로
		// ,______제한용량______,_인코딩타입,___같은 파일의 이름일 경우 이름을 변경
		MultipartRequest multi = new MultipartRequest(req, savePath, limitCapacity, encType, new MyFileRenamePolicy());

		// 앞에서 form을 enctype="multipart/form-data"의 값으로 넘겨주었으므로
		// multiPartRequest로 받아준다.

		String id = multi.getParameter("id");
		String no = multi.getParameter("no");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String scope = multi.getParameter("scope");

		// vo 객체에 각각 받아온 파라미터 값들을 저장.
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setScope(Integer.parseInt(scope));
		vo.setNo(Integer.parseInt(no));

		// 저장된 파일이 있는지 확인하기 위해
		Enumeration<String> e = multi.getFileNames();

		// 저장된 파일이 있는지 확인
		while (e.hasMoreElements()) {
			String fileName = e.nextElement();
			File f = multi.getFile(fileName);

			// 파일이 있으면 VO에 저장.
			if (f != null) {
				String fileSystemName = multi.getFilesystemName(fileName);
				String fileOriginName = multi.getOriginalFileName(fileName);

				vo.setFileName(fileSystemName);
				vo.setOriginFileName(fileOriginName);
				vo.setFilePath(readPath);
			}

		}

		try {
			dao.updateVO(vo);

			resp.sendRedirect("/OurCommunity/gallery/detail?no="+vo.getNo());

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
