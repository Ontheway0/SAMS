package com.szy.operateDB;

import com.szy.bean.Student;
import com.szy.bean.User;

/**
 * 用于学生登录并操作信息的接口
 */
public interface StudentOperateSQL {
	/** 通过登录界面的user获得后台数据库的对应的学生信息
	 * 
	 * @param user 登录界面的user
	 * @return 获得后台数据库的对应的学生信息
	 */
	public Student selectStudent(User user);
	/**修改学生本人的信息
	 * 
	 * @param student 学生信息
	 * @return 结果
	 */
	public boolean updateStudent(Student student, int item);
	
}
