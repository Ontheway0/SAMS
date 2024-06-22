package com.szy.bean;

public class User {
	private String uname;
	private String upass;
	private int type;
	{
		uname = null;
		upass = null;
		type = 0;
	}
	
	public User() {
		type = 0;
		uname = null;
		upass = null;
	}

	public User(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}
	public User(String uname, String upass, int type) {
		
		this.type = type;
		this.uname = uname;
		this.upass = upass;
	}
	
	
	public void setUname(String uname) {
		
		this.uname = uname;

	}
	public void setUpass(String upass) {
		if(this.upass.length()!=0) {
			this.upass.replaceAll(this.upass, upass);
		} else {
			this.upass = upass;
		}
	}
	public void setType(int type) {
		this.type = type;
	}
	// get

	public String getUname() {
		return this.uname;
	}
	public String getUpass() {
		return this.upass;
	}
	public int getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + " [uname=" + uname + ", upass=" + upass + ", type=" + type + "]";
	}
}
