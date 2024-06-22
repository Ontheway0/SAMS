package com.szy.bean;

import com.szy.operateDB.StudentOperateSQL_Imp;

public class Student extends User {
	
	private String id;
	private String name;
	private String gender;
	private int age;
	private String cl;
	{
		super.setType(2);
	}
	public Student( User user, String id, String name, String gender, int age, String cl) {
		super(user.getUname(), user.getUpass());
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.cl = cl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCl() {
		return cl;
	}
	public void setCl(String cl) {
		this.cl = cl;
	}

	public void printStudent() {
		System.out.println("Student [name=" + name + ", gender=" + gender + ", age=" + age + ", cl=" + cl + "]");
	}
	public String getId() {
		// TODO 自动生成的方法存根
		return id;
	}
	
}
