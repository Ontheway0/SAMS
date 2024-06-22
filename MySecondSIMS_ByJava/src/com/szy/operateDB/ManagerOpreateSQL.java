package com.szy.operateDB;

import com.szy.bean.User;

public interface ManagerOpreateSQL {
	/**
	 * 用于登录
	 * @param user：从登录界面拿到的用户信息
	 * @return -1 失败， 1admin， 2teacher， 3student
	 */
	int login(User user);
	/**
	 * 用于插入一条用户信息
	 * @param user：封装好的用户信息的对象
	 * @return 插入结果，true为成功， false为失败
	 */
	boolean insert(User user);
	/**
	 * 用于删除一个账号
	 * @param uname 接收要删除的账号
	 * @return	返回结果，true为成功， false为失败
	 */
	boolean delete(String uname);
	/**
	 * 用于插入一条用户信息
	 * @param user：封装好的用户信息的对象
	 * @return 插入结果，true为成功， false为失败
	 */
	boolean update(User user);
	/**
	 * 查询用户的信息
	 * @param uname 账号
	 * @return 账号身份
	 */
	int select(String uname);
}
