package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {
   private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
   private static final String URL = "jdbc:oracle:thin:@192.168.200.93:1521:XE";
//   private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
   private static final String USER = "hr";
   private static final String PASSWORD = "hr";
   
   public static Connection getConnection() throws Exception {
      try {
         Class.forName(JDBC_DRIVER);
         return DriverManager.getConnection(URL,USER,PASSWORD);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   public static void close(Connection con) {
      try {
         con.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}