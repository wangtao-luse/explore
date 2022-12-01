package com.explore.member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class TestMysqlConnection {
	@Test
public void testMysqlConnection() {
	//2.获取与数据库的链接
	//端口号:3306  数据库名称:jsp_database
	String url = "jdbc:mysql://1.116.226.147:3306/member?serverTimezone=UTC&useSSL=false";//链接地址
	String username = "root";//用户名
	String password = "mysql@958958";//密码
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		connection.close();
		System.out.println(connection);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
