package kr.co.mlec.contents.vo;

public class RecommendMenuVO {
	private int num;
	private String id;
	private String title;
	private String restaurantName;
	private String content;
	private String regDate;
	private String latitude;
	private String longitude;
	private int count;
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

}

//
//create table recommend_menu (
//num number primary key,
//id varchar2(20) not null,
//title varchar2(50) not null,
//content varchar2(300),
//reg_date date default sysdate,
//latitude varchar2(30),
//longitude varchar2(30),
//count number default 0,
//restaurant_name varchar(50) not null )

// seq_recommend_menu_num
