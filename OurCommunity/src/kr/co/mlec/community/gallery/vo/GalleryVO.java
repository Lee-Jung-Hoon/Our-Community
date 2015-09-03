package kr.co.mlec.community.gallery.vo;

public class GalleryVO {

	/*
	 create table t_community_Gallery_board (
	 id varchar2(30) not null,
	 no number not null,
	 title varchar2(150),
	 content varchar2(1500),
	 reg_date date default sysdate,
	 check_cnt number,
	 scope number(1),
	 file_name varchar(120),
	 origin_file_name varchar2(120),
	 file_path varchar(210)
	 )
	 */

	private String id;
	private int no;
	private String title;
	private String content;
	private String regDate;
	private int checkCnt;
	private int scope;
	private String fileName;
	private String originFileName;
	private String filePath;

	@Override
	public String toString() {
		return "GalleryVO [id=" + id + ", no=" + no + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", checkCnt=" + checkCnt + ", scope=" + scope + ", fileName=" + fileName
				+ ", originFileName=" + originFileName + ", filePath=" + filePath + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getCheckCnt() {
		return checkCnt;
	}

	public void setCheckCnt(int checkCnt) {
		this.checkCnt = checkCnt;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
