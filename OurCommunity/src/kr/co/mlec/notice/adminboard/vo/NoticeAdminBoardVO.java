package kr.co.mlec.notice.adminboard.vo;

public class NoticeAdminBoardVO {
	private String id;
	private String no;
	private String boardHead;
	private String title;
	private String content;
	private String regDate;
	private String checkCnt;
	private String scope;

	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBoardHead() {
		return boardHead;
	}

	public void setBoardHead(String boardHead) {
		this.boardHead = boardHead;
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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getCheckCnt() {
		return checkCnt;
	}

	public void setCheckCnt(String checkCnt) {
		this.checkCnt = checkCnt;
	}

	


}
