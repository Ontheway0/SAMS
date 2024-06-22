package com.szy.controller;

import com.szy.bean.Student;
import com.szy.bean.User;
import com.szy.operateDB.ManagerOpreateSQL_Imp;
import com.szy.operateDB.StudentOperateSQL_Imp;
import com.szy.view.View;

public class Serve {
	/**
	 * 管理员的服务
	 */
	public static void managerServe() {
		ManagerOpreateSQL_Imp user_imp = new ManagerOpreateSQL_Imp();

		while (true) {
			int item = View.managerMenuView();
			boolean flag;
			switch (item) {
			case 0:
				System.out.println("再见");
				System.exit(-1);
				break;
			case 1:
				// 加载菜单
				// 接受信息
				User user = View.addMenuView();
				// 连接数据库
				flag = user_imp.insert(user);
				System.out.println(flag?"添加成功":"添加失败");
				break;
			case 2:
				String upassDelete = View.deleteMenuView();
				flag = user_imp.delete(upassDelete);
				System.out.println(flag?"删除成功":"删除失败");
				break;
			case 3:
				User user1 = View.updateMenuView();
				flag = user_imp.update(user1);
				System.out.println(flag?"更新成功":"更新失败");
				break;
			case 4:
				String upassSelect = View.selectMenuView();
				int type = user_imp.select(upassSelect);
				if(type < 0) {
					System.out.println("查无此人");
				} else if(type == 1) {
					System.out.println("此人是管理员");
				} else if(type == 2) {
					System.out.println("此人是学生");
				} 
				break;
			}
		}

	}
	/**
	 * 
	 * @param user 登录的信息
	 */
	public static void studentServe(User user) {
		StudentOperateSQL_Imp studentoperatesql_imp = new StudentOperateSQL_Imp();
		Student student = studentoperatesql_imp.selectStudent(user);
		boolean flag;
		while(true) {
			int item = View.studentMenuView(student);
			switch(item) {
			case 0 :
				System.out.println("再见");
				System.exit(-1);
				break;
			case 1:
				System.out.println("************\t当前您的信息\t***************");
				student.printStudent();
				break;
			case 2:
				item = View.studentUpdateView();
				flag = studentoperatesql_imp.updateStudent(student, item);
				System.out.println(flag?"更新成功":"更新失败");
				break;
			}
		}
	}
}
