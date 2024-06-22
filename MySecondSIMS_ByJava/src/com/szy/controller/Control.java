package com.szy.controller;

import com.szy.bean.User;
import com.szy.operateDB.ManagerOpreateSQL_Imp;
import com.szy.view.*;

public class Control {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// 展示登陆界面
		User user = View.indexView();
		// 加载操作数据的类
		ManagerOpreateSQL_Imp user_imp = new ManagerOpreateSQL_Imp();
		// 登录
		int type = user_imp.login(user);
		switch (type) {
		case -1:
			System.out.println("账号或密码有误，请重新输入");
			break;
		case 1:
			System.out.println("恭喜管理员登录成功");
			Serve.managerServe();
			break;
		case 2:
			Serve.studentServe(user);
			break;
		}

	}
}
