package kr.co.mlec.community.studyFile.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/studyFile/download")
public class StudyFileDownload extends HttpServlet
{
	public static String uploadPath;
	
//	public void init(ServletConfig config) {
//		uploadPath = config.getInitParameter("upload");
//	}
	
	public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		doGet( req, res );
	}

	/**
	 * Download 처리 메소드 (doPost, doGet을 동일하게 처리).
	 *
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @exception	 ServletException
	 * @exception	 IOException
	 * 
	 * 인자 : 
	 *     org_filename  : 다운로드될 때 사용될 파일이름
	 *     real_filename : 실제 저장된 파일이름   
	 *     type          : 이지미를 출력하기 위해서는 imageDraw 값을 전달해야함 
	 * 
	 */		
	public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
	{
    	String orgFileName  ;
    	String realFileName ;
    	String readPath;
    	String type;
    	
		
    	orgFileName  = req.getParameter( "orgFileName" );
    	realFileName = req.getParameter( "realFileName" );
    	readPath = req.getParameter("readPath");
    	type = req.getParameter("type");

    	uploadPath = readPath;
    	
    	System.out.println(orgFileName);
    	
     	File file = new File( uploadPath, realFileName );
    	FileInputStream fileInput = new FileInputStream( file );

    	if (type == null || !type.equals("imageDraw")) {
    		res.setHeader("Content-Type", "application/octet-stream");
    		res.setHeader("Content-Disposition", "attachment;filename="+ new String(orgFileName.getBytes("UTF-8"),"8859_1"));
	    	res.setHeader("Content-Transfer-Encoding", "binary;");
	    	res.setHeader("Content-Length", String.valueOf(file.length()));
	    	res.setHeader("Pragma", "no-cache;");
	    	res.setHeader("Expires", "-1;");
    	} else {
    		res.setHeader("Content-Type", "image/jpg");
    	}

    	if (file.isFile()) {
    		BufferedInputStream fin = new BufferedInputStream( fileInput );
    		BufferedOutputStream outs = new BufferedOutputStream( res.getOutputStream() );
    
    		int read = 0;
    		while ( ( read = fin.read() ) != -1 ){
    			outs.write(read);
    		}
    		outs.close();
    		fin.close();
    	}
	}
}
