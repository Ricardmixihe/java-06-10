package com.jizhong.jdbccontroller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.jizhong.utils.JDBCUtils;


public class login {	
		public static void main(String[] args) throws Exception {
			//控制台输入用户名密码
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名");
			String username = 	scanner.next();
			System.out.println("请输入密码");
			String password = scanner.next();
			
			//	2.获取数据库数据，判断用户名和密码是否正确	
			Connection connection = null;
			Statement statement = null;
			ResultSet result = null;
			try {
				connection = JDBCUtils.getConnection();
				statement	= connection.createStatement();
				String sql = "select * from user where username = '" + username +   "'";
				result = 	statement.executeQuery(sql);
				if (result.next()) {
					String passwordResult = result.getString("password");
					if (password.equals(passwordResult)) {
						System.out.println("登录成功");
					}
					else {
						System.out.println("密码错误");
					}
				}else {
					System.out.println("密码错误");
				}
				
				//2.4判断密码是否正确
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				JDBCUtils.close(result, statement, connection);
			}
		}

}
