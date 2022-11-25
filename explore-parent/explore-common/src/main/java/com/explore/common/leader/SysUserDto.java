package com.explore.common.leader;

public class SysUserDto {
private String userName;
private String passwd;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public SysUserDto selectOne() {
	SysUserDto user =new SysUserDto();
	   user.setPasswd("password");
	   user.setUserName("admin");
	   return user;
}
}
