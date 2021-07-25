package com.jizhong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import com.jizhong.utils.JDBCUtils;

public class JDBCTest2 {
	public static void main(String[] args){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			//1. 获取连接
			connection = JDBCUtils.getConnection();
			statement = connection.createStatement();
			String sql = "select * from school";//查询学生表
			resultSet = statement.executeQuery(sql);//executeQuery：执行查询语句
			while(resultSet.next()){
				int id = resultSet.getInt("id");//columnIndex：列名   {columnName：[数据]}
				String name = resultSet.getString("sc_name");//varchar = String
				System.out.println(id + "--------" + name);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//2. 关闭资源
			JDBCUtils.close(resultSet, statement, connection);
		}
	}
}
