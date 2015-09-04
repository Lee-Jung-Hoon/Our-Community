package kr.co.mlec.community.gallery.comment.vo;

public class GallCommentCntVO {

	private int commentCnt;
	private int boardNO;
	@Override
	public String toString() {
		return "GallCommentCntVO [commentCnt=" + commentCnt + ", boardNO=" + boardNO + "]";
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getBoardNO() {
		return boardNO;
	}
	public void setBoardNO(int boardNO) {
		this.boardNO = boardNO;
	}
}
