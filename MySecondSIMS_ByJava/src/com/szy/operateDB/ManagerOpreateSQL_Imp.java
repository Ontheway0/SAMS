package com.szy.operateDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.szy.bean.Student;
import com.szy.bean.User;
import com.szy.jdbc.JDBCUtils;
import com.szy.view.View;

public class ManagerOpreateSQL_Imp implements ManagerOpreateSQL {
	private static final String SQL_USER_LOGIN = "SELECT type FROM user WHERE uname=? AND upass=?;";
	// 添加学生的sql语句
	private static final String SQL_USER_INSERT = "INSERT INTO user VALUES(?, ?, 2);";
	private static final String SQL_STUDENT_INSERT = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=?;";
	private static final String SQL_USER_UPDATE = "UPDATE user SET upass=? WHERE uname=?;";
	private static final String SQL_STUDENT_UPDATE = "UPDATE student SET upass=? WHERE uname=?;";
	private static final String SQL_USER_SELECT = "SELECT type FROM user where uname=?;";
	
	@Override
	public int login(User user) {
		// TODO 自动生成的方法存根
		// 连接数据库
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet res = null;
		try {
			// 创建预编译执行环境
			preparedStmt = conn.prepareStatement(SQL_USER_LOGIN);
			preparedStmt.setString(1, user.getUname());
			preparedStmt.setString(2, user.getUpass());
			// 接受结果集
			res = preparedStmt.executeQuery();
			while(res.next()) {
				int type = res.getInt("type");
				return type;
			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, preparedStmt, res);
		}
		
		return -1;
	}
	// 在此页面增加student的insert
	@Override
	public boolean insert(User user) {
		// TODO 自动生成的方法存根
		// 插入语句：INSERT INTO user VALUES(id, ?, ?, 2);	返回的是受影响的行数
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStmt = null;
		int lineUsr = -1;
		int lineStu = 1;
		try {
			// 创建预编译执行环境
			preparedStmt = conn.prepareStatement(SQL_USER_INSERT);
			preparedStmt.setString(1, user.getUname());
			preparedStmt.setString(2, user.getUpass());
			// 接受结果
			lineUsr = preparedStmt.executeUpdate();
			
			preparedStmt.close();
			Student student  = View.addStudentView(user);
			preparedStmt = conn.prepareStatement(SQL_STUDENT_INSERT);
			preparedStmt.setString(1, student.getId());
			preparedStmt.setString(2, student.getUname());
			preparedStmt.setString(3, student.getUpass());
			preparedStmt.setString(4, student.getName());
			preparedStmt.setString(5, student.getGender());
			preparedStmt.setInt(6, student.getAge());
			preparedStmt.setString(7, student.getCl());
			// 接受结果
			lineStu = preparedStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			// System.out.println("插入失败");
			// 插入失败
			//e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, preparedStmt, null);
		}
		if(lineUsr > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delete(String uname) {
		// TODO 自动生成的方法存根
		// 插入语句：INSERT INTO user VALUES( ?, ?, 2);	返回的是受影响的行数
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStmt = null;
		int line = -1;
		try {
			// 创建预编译执行环境
			preparedStmt = conn.prepareStatement(SQL_USER_DELETE);
			preparedStmt.setString(1, uname);
			// 接受结果
			line = preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			
			// e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, preparedStmt, null);
		}
		if(line > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean update(User user) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStmt = null;
		int line = -1;
		try {
			// 创建预编译执行环境
			preparedStmt = conn.prepareStatement(SQL_USER_UPDATE);
			preparedStmt.setString(2, user.getUname());
			preparedStmt.setString(1, user.getUpass());
			// 接受结果
			line = preparedStmt.executeUpdate();
			preparedStmt.close();
			preparedStmt = conn.prepareStatement(SQL_STUDENT_UPDATE);
			preparedStmt.setString(2, user.getUname());
			preparedStmt.setString(1, user.getUpass());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			// e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, preparedStmt, null);
		}
		if(line > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	// 查询身份
	public int select(String uname) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet res = null;
		int type = -1;
		try {
			// 创建预编译执行环境
			preparedStmt = conn.prepareStatement(SQL_USER_SELECT);
			preparedStmt.setString(1, uname);
			// 接受结果
			res = preparedStmt.executeQuery();
			while(res.next()) {
				type = res.getInt("type");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			// e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, preparedStmt, res);
		}
		return type;
	}

}
