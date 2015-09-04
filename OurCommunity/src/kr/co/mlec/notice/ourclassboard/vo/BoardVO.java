package kr.co.mlec.notice.ourclassboard.vo;

public class BoardVO {
	private String no;
	private String id;
	private String boardhead; 
	private String title;
	private String content;
	private String regDate;
	private String checkCnt;
	private String scope;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getBoardhead() {
		return boardhead;
	}
	public void setBoardhead(String boardhead) {
		this.boardhead = boardhead;
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
	public String getCheckCnt() {
		return checkCnt;
	}
	public void setCheckCnt(String checkCnt) {
		this.checkCnt = checkCnt;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", no=" + no + ", boardhead=" + boardhead + ", title=" + title + ", content="
				+ content + ", regDate=" + regDate + ", checkCnt=" + checkCnt + ", scope=" + scope + "]";
	}
	

}
