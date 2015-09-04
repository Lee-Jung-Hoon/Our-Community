package kr.co.mlec.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {



	@Override
	public File rename(File f) {
		
		//기존에 사용자 입력 파일 명  ex) a.jpg
		// 유니크한 아이디 ex) 5575-454f541-45df5g6-a4542
		//__________유니크한 아이디를 반환
		String id = UUID.randomUUID().toString();
		
		//원래 사용자가 가지고 있는 입력값을 추출
		String name = f.getName();
		//유니크한 아이디.jsp를 설정하기 위해서 .jsp를 ext값에 저장한다.
		String ext = "";
		
		//뒤에서 부터 . 을 찾아내고 없다면 ext는 빈공간이 들어가게 설정
		int dot = name.lastIndexOf(".");
		if(dot!=-1){
			ext = name.substring(dot);
		}
		
		File renameFile = new File(f.getParent(), id + ext);
		return renameFile;
	}


}
