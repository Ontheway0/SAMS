package com.szy.view;

import java.util.Scanner;

import com.szy.bean.Student;
import com.szy.bean.User;
import com.szy.operateDB.StudentOperateSQL_Imp;

public class View {
	private static Scanner input = new Scanner(System.in);
	/**
	 * 首页视图
	 * @return	返回登录的用户
	 */
	public static User indexView() {
		System.out.println("***********************************************");
		System.out.println("************\t学生信息管理系统\t*******");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t请输入账号\t***************");
		String uname = input.nextLine();
		System.out.println("************\t请输入密码\t***************");
		String upass = input.nextLine();
		
		return new User(uname, upass);
	}
	/**
	 * 管理员视图
	 * @return	返回管理员的操作类型
	 */
	
	public static int managerMenuView() {
		System.out.println("***********************************************");
		System.out.println("************\t欢迎管理员回家\t***************");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t0.退出\t***********************");
		System.out.println("************\t1.添加学生信息\t***************");
		System.out.println("************\t2.删除学生账号\t***************");
		System.out.println("************\t3.修改学生账号\t***************");
		System.out.println("************\t4.查询学生账号\t***************");
		String op = input.nextLine();
		int item = Integer.parseInt(op);
		if(item < 0||item > 4) {
			System.out.println("请按提示输入");
			return managerMenuView();
		}
		return item;
	}
	/**
	 * 添加学生账号视图
	 * @return	返回添加的用户
	 */
	public static User addMenuView() {
		System.out.println("***********************************************");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t增加学生账号\t****************");
		System.out.println("************\t请输入账号\t***************");
		String uname = input.nextLine();
		System.out.println("************\t请输入密码\t***************");
		String upass = input.nextLine();
		User user = new User(uname, upass);
		return user;
		// 查询当前数据库是否有该账号的信息
	}
	public static Student addStudentView(User user) {
		System.out.println("***********************************************");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t增加学生信息\t****************");
		System.out.println("************\t请输入id\t***************");
		String id = input.nextLine();
		System.out.println("************\t请输入姓名\t***************");
		String name = input.nextLine();
		System.out.println("************\t请输入性别（F / M）\t***************");
		String gender = input.nextLine();
		System.out.println("************\t请输入年龄\t***************");
		int age =Integer.parseInt(input.nextLine()) ;
		System.out.println("************\t请输入班级\t***************");
		String cl = input.nextLine();
		Student student = new Student(user, id, name, gender, age, cl);
		return student;
		// 查询当前数据库是否有该账号的信息
	}
	
	/**
	 * 删除信息视图
	 * @return
	 */
	public static String deleteMenuView() {
		System.out.println("***********************************************");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t请输入账号\t***************");
		String uname = input.nextLine();
		return uname;
	}
	/**
	 * 查询信息视图
	 * @return	返回要的查询账号
	 */
	public static String selectMenuView() {
		System.out.println("***********************************************");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t请输入账号\t***************");
		String uname = input.nextLine();
		
		return uname;
	}
	/**
	 * 更新信息视图
	 * @return	返回要更新后的用户
	 */
	public static User updateMenuView() {
		System.out.println("***********************************************");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t请输入账号\t***************");
		String uname = input.nextLine();
		System.out.println("************\t输入新密码\t***************");
		String upass = input.nextLine();
		return new User(uname, upass);
	}
	/**
	 * 学生菜单视图
	 */
	public static int studentMenuView(Student student) {
		System.out.println("***********************************************");
		System.out.println("************\t欢迎" + student.getName()+ "进入\t***************");
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t0.退出\t***************");
		System.out.println("************\t1.查询当前信息\t***************");
		System.out.println("************\t2.更改某项信息\t***************");
		int item = input.nextInt();
		return item;
	}
	/**
	 * 更新学生视图
	 * @param student
	 * @return
	 */
	public static int studentUpdateView() {
		System.out.println("************\t根据提示操作\t***************");
		System.out.println("************\t0.退出\t***************");
		System.out.println("************\t1.修改当前学号\t***************");
		System.out.println("************\t2.修改当前账号\t***************");
		System.out.println("************\t3.修改当前姓名\t***************");
		System.out.println("************\t4.修改当前性别\t***************");
		System.out.println("************\t5.修改当前年龄\t***************");
		System.out.println("************\t6.修改当前班级\t***************");
		int item = input.nextInt();
		return item;
	}
}
