package kr.co.mlec.contents.vo;

public class VoteBoardVO {
	private String id;
	private String v_no;
	private String start_date;
	private String end_date;
	private String v_title;
	private String v_progress;
	private String v_clicks;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getV_no() {
		return v_no;
	}
	public void setV_no(String v_no) {
		this.v_no = v_no;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getV_title() {
		return v_title;
	}
	public void setV_title(String v_title) {
		this.v_title = v_title;
	}
	public String getV_progress() {
		return v_progress;
	}
	public void setV_progress(String v_progress) {
		this.v_progress = v_progress;
	}
	public String getV_clicks() {
		return v_clicks;
	}
	public void setV_clicks(String v_clicks) {
		this.v_clicks = v_clicks;
	}
}
