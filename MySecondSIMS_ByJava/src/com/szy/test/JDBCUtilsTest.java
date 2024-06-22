package com.szy.test;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.szy.bean.User;
import com.szy.jdbc.JDBCUtils;
import com.szy.operateDB.ManagerOpreateSQL_Imp;

public class JDBCUtilsTest {
	
	@Test
	public void jdbcConnection() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * from user;");
		while(res.next()) {
			System.out.println(res.getInt("id"));
		}
		JDBCUtils.close(conn, stmt, res);
	}
	@Test
	public void loginTest() throws Exception {
		ManagerOpreateSQL_Imp userdao_imp = new ManagerOpreateSQL_Imp();
		User user = new User("admin", "admin");
		int type = userdao_imp.login(user);
		System.out.println(type);
	}
	@Test
	public void insertTest() throws Exception {
		ManagerOpreateSQL_Imp userdao_imp = new ManagerOpreateSQL_Imp();
		User user = new User("www", "www");
		boolean type = userdao_imp.insert(user);
		System.out.println(type);
	}
	@Test
	public void deleteTest() throws Exception {
		ManagerOpreateSQL_Imp userdao_imp = new ManagerOpreateSQL_Imp();
		boolean type = userdao_imp.delete("www");
		System.out.println(type);
	}
	@Test
	public void updateTest() throws Exception {
		ManagerOpreateSQL_Imp userdao_imp = new ManagerOpreateSQL_Imp();
		User user = new User("admin", "123456");
		boolean type = userdao_imp.update(user);
		System.out.println(type);
	}
	@Test
	public void selectTest() throws Exception {
		ManagerOpreateSQL_Imp userdao_imp = new ManagerOpreateSQL_Imp();
		int type = userdao_imp.select("admin");
		System.out.println(type);
	}
}
