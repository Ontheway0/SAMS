package com.szy.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class JDBCUtils {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	// 静态语句块
	static {
		// 流的形式读取配置文件
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		
		// 创建Property类型的对象
		Properties p = new Properties();
		// 加载流文件
		try {
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			// 加载mysql驱动
			Class.forName(driver);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	// 获得连接对象的方法
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
	}
	
	// 关闭释放资源的方法
	public static void close(Connection conn, Statement stmt, ResultSet res) {
		try {
			if(res!=null) {
				res.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
