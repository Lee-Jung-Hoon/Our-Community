package kr.co.mlec.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		// 파일명은 바꾸지만 확장자는 그대로 유지
		String id = UUID.randomUUID().toString();
		String name = f.getName(); //원래 사용자가 입력한 파일 이름
		String ext = "";
		int dot = name.lastIndexOf(".");
		
		if(dot != -1) {
			ext = name.substring(dot);
		}
		File renameFile = new File(f.getParent(), id + ext);
		return renameFile;
	}

}
