package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ConnectionPool {

	private static final int INIT_COUNT = 5;
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "hr";
	private static final String PASSWORD = "hr";

	public static ArrayList<Connection> freeList = new ArrayList<>();
	public static ArrayList<Connection> usedList = new ArrayList<>();

	// 클래스 정보가 로딩할 때 데이터베이스 드라이버 로딩 및 커넷션을 생성
	static {
		try{
			Class.forName(JDBC_DRIVER);
			for(int i = 0; i < INIT_COUNT; i++){
				//최초 클래스 로딩시 데이터베이스의 연결 객체를 생성해서 폴에 입력함..
				freeList.add(DriverManager.getConnection(URL, USER, PASSWORD));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		if(freeList.isEmpty()) {
			throw new Exception ("모든 커넥션이 사용중입니다. 잠시만 기다려");
		}
		//free풀에서 꺼내고 삭제
		Connection con = freeList.remove(0);  //삭제된 객체를 넘겨줌
		//used풀로 커넷션을 입력.
		usedList.add(con);
	    System.out.println("사용중 : " + usedList.size());
	    System.out.println("남아있는 : " + freeList.size());
	    return con;
	}

	public static void close(Connection con) {
		usedList.remove(usedList.indexOf(con));
		freeList.add(con);
	}

}
