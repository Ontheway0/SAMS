package com.szy.operateDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.szy.bean.Student;
import com.szy.bean.User;
import com.szy.jdbc.JDBCUtils;

public class StudentOperateSQL_Imp implements StudentOperateSQL {

	private static final String SQL_USER_SELECT = "SELECT * FROM student where uname=?;";
	@Override
	/**
	 * 根据登录的信息找到后台数据库对应的学生信息
	 */
	public Student selectStudent(User user){
		// TODO 自动生成的方法存根
		// 连接数据库
		Student student = null;
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet res = null;
		try {
			// 创建预编译执行环境
			preparedStmt = conn.prepareStatement(SQL_USER_SELECT);
			preparedStmt.setString(1, user.getUname());
			// 接受结果集
			res = preparedStmt.executeQuery();
			while(res.next()) {
				String id = res.getString("id");
				String name = res.getString("name");
				String gender = res.getString("gender");
				int age = res.getInt("age");
				String cl = res.getString("class");
				student = new Student(user, id, name, gender, age, cl);
				return student;
			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			// e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, preparedStmt, res);
		}	
		return null;
	}
	@Override
	public boolean updateStudent(Student student, int item) {
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparedStmt = null;
		int res = -1;
		String field;
		switch(item) {
		case 1:
			field = "id";
			break;
		case 2:
			field = "uname";
			break;
		case 3:
			field = "name";
			break;
		case 4:
			field = "gender";
			break;
		case 5:
			field = "age";
			break;
		case 6:
			field = "class";
			break;
			default:
				field = "";
		}
		String SQL_USER_UPDATE = "UPDATE student SET "+field+"=? WHERE uname=?;";
		try {
			preparedStmt = conn.prepareStatement(SQL_USER_UPDATE);
			System.out.println("请输入修改后的信息：");
			String data = input.nextLine();
			preparedStmt.setString(1, data);
			preparedStmt.setString(2, student.getUname());
			// 接受结果集
			res = preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
		}
		return res < 0?false:true;
	}
}
