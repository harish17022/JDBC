package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "harish";
		String sql = "Select * from harishtech;";
		Connection myCon=null;
		Statement statement = null;
		ResultSet res = null;
		
		try {
			myCon = DriverManager.getConnection(url, username, password);
			statement = myCon.createStatement();
			res = statement.executeQuery(sql);
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String department = res.getString("department");
				int salary = res.getInt("salary");
				System.out.println(id+" "+name+" "+email+" "+department+" "+salary);
			}
			
			
		}
		catch(Exception e) {
			System.out.println("Error will occur");
		}
		finally {
			try {
				myCon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
