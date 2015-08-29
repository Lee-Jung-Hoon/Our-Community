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

	// Ŭ���� ������ �ε��� �� �����ͺ��̽� ����̹� �ε� �� Ŀ�ݼ��� ����
	static {
		try{
			Class.forName(JDBC_DRIVER);
			for(int i = 0; i < INIT_COUNT; i++){
				//���� Ŭ���� �ε��� �����ͺ��̽��� ���� ��ü�� �����ؼ� ���� �Է���..
				freeList.add(DriverManager.getConnection(URL, USER, PASSWORD));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		if(freeList.isEmpty()) {
			throw new Exception ("��� Ŀ�ؼ��� ������Դϴ�. ��ø� ��ٷ�");
		}
		//freeǮ���� ������ ����
		Connection con = freeList.remove(0);  //������ ��ü�� �Ѱ���
		//usedǮ�� Ŀ�ݼ��� �Է�.
		usedList.add(con);
	    System.out.println("����� : " + usedList.size());
	    System.out.println("�����ִ� : " + freeList.size());
	    return con;
	}

	public static void close(Connection con) {
		usedList.remove(usedList.indexOf(con));
		freeList.add(con);
	}

}
