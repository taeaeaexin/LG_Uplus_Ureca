package app.book.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Connection 객체를 생성, 전달
// ResultSet, PreparedStatement, Connection 객체 종료 close()
public class DBManager {

	static String url = "jdbc:mysql://localhost:3306/madang";
	static String user = "root";
	static String pwd = "1234";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;		
	}
	
	public static void releaseConnection(PreparedStatement pstmt, Connection con) {
		try {
			if( pstmt != null ) pstmt.close();
			if( con != null ) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if( rs != null ) rs.close();
			if( pstmt != null ) pstmt.close();
			if( con != null ) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
