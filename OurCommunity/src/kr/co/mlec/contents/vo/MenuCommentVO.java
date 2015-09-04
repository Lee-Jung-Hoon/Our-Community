package kr.co.mlec.contents.vo;

public class MenuCommentVO {
	private int no;
	private int num;
	private String id;
	private String menuComment;
	private String commentDate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuComment() {
		return menuComment;
	}

	public void setMenuComment(String menuComment) {
		this.menuComment = menuComment;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

}
// create table recommend_menu_comment (
// no number primary key,
// num number not null,
// id varchar2(20) not null,
// menu_comment varchar2(500),
// comment_date date default sysdate )

//sequence seq_recommend_menu_comment_no
