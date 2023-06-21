package lcm.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Jdbc连接
public class JdbcUtil {
	//MySQL数据源参数
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/his?useSSL=false&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true";
	private static final String USER = "root";
	private static final String PASSWORD = "zjj030125";
	
	//ͨ从属性文件中获取数据库参数
//	private static final String DRIVER =PropertyUtil.driverClass;
//	private static final String URL =PropertyUtil.url;
//	private static final String USER =PropertyUtil.userName;
//	private static final String PASSWORD =PropertyUtil.password;	
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void closeAll( ResultSet rs,Statement stmt,Connection con) {
		try {
			if (rs != null) {
				rs.close(); 
				rs = null;   
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null && !con.isClosed()) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//关闭数据库对象
	public static void close(Statement stmt,Connection conn) {
		try {

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close(); 
				conn = null;   
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
