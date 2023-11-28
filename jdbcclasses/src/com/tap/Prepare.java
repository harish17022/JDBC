package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prepare {
	public PreparedStatement statement;
	public static void main(String[] args) {
		
		 String url="jdbc:mysql://localhost:3306/jdbcclasses";
		 String username="root";
		 String password="harish";
		 String sql ="UPDATE `employee` SET `salary`=`salary`+? WHERE `department`= ?";
		 Connection myCon = null;
		 PreparedStatement statement = null;
		 
		 try {
			 myCon=DriverManager.getConnection(url,username,password);
			 Demo1.display(null, statement, myCon);
			 statement = myCon.prepareStatement(sql);
			 statement.setInt(1,17000);
			 statement.setString(2, "IT");
			 int i = statement.executeUpdate();
			 System.out.println(i);
			 Demo1.display(null, statement, myCon);
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
		 }
		 catch(Exception e){	
			 e.printStackTrace();
			 
		 }
		 
			 
		 }
}
