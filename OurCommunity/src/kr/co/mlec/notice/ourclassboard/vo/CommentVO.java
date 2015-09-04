package kr.co.mlec.notice.ourclassboard.vo;

public class CommentVO {
	private String commentNo;
	private String no;
	private String id;
	private String content;
	private String regDate;
	public String getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", no=" + no + ", id=" + id + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
}
