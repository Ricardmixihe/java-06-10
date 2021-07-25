package com.jizhong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import com.jizhong.utils.JDBCUtils;

public class JDBCTest01 {
	public static void main(String[] args) throws Exception {
		//1. 加载并且注册驱动
		Class.forName("com.mysql.jdbc.Driver");//com.mysql.jdbc.Driver
		//2. 获取Connection连接
		//DriverManager：驱动管理员
		/**
		 * url：jdbc:mysql:// + 主机地址 + 端口号（3306） + 数据库名称 + [编码格式....]
		 * 		localhost：本地ip  127.0.0.1
		 * 		192.168.7.100
		 * user：用户名
		 * password：密码
		 */
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=true","root","root");
		//3. 创建一个 Statement 对象
		//Statement：用声明SQL语句，发送SQL到mysql数据库
		Statement statement = connection.createStatement();
		//4. 执行语句
		//4.1 声明SQL语句
		String sql = "select * from school";//查询学生表
		//4.2 执行SQL语句
//		statement.executeUpdate(sql);//executeUpdate：执行增删改语句
		//ResultSet：封装查询到的数据
		ResultSet resultSet = statement.executeQuery(sql);//executeQuery：执行查询语句
		//5. 使用ResultSet对象获取查询到的数据
		//next()：判断是否还有下一数据，游标下移。
		while(resultSet.next()){
			int id = resultSet.getInt("id");//columnIndex：列名   {columnName：[数据]}
			String name = resultSet.getString("sc_name");//varchar = String
			System.out.println(id + "--------" + name);
		}
		//6. 关闭连接
		resultSet.close();
		statement.close();
		connection.close();
		
		/*
			//1. 加载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2. 获取数据库连接
			Connection c = DriverManager.getConnection(url);
			//3. 拿到Statement对象，执行SQL语句
			Statement s = c.createStatement();
			String sql2 = "select * from student";
			ResultSet r = s.executeQuery(sql2);
			//4. 获取返回结果集（ResultSet）
			while(r.next()){
				r.getInt("id");
			}
			//5. 关闭连接
			r.close();
			s.close();
			c.close();
		*/
		
		
		/**
		 * 1. 获取数据库连接对象
		 * 2. 关闭连接，释放资源
		 */
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
