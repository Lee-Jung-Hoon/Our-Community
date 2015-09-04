package kr.co.mlec.community.gallery.comment.vo;

public class GallCommentVO {

//	 create table t_community_gallery_comment(
//	 id varchar2(30) not null,
//	 comment_no number not null,
//	 comment_content varchar2(600),
//	 board_no number not null,
//	 comment_reg_date date default sysdate
//	 )

	// create sequence s_community_gallery_comment

	private String id;
	private int commentNo;
	private String commentContent;
	private int boardNo;
	private String commentRegDate;

	@Override
	public String toString() {
		return "GallCommentVO [id=" + id + ", commentNo=" + commentNo + ", commentContent=" + commentContent
				+ ", boardNo=" + boardNo + ", commentRegDate=" + commentRegDate + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getCommentRegDate() {
		return commentRegDate;
	}

	public void setCommentRegDate(String commentRegDate) {
		this.commentRegDate = commentRegDate;
	}

}
