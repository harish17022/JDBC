package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PrepareUser {
	public final static Scanner sc = new Scanner(System.in);
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
			 statement=myCon.prepareStatement(sql);
			 statement.setInt(1, sc.nextInt());
			 statement.setString(2,sc.next());
			 int i = statement.executeUpdate();
			 System.out.println(i);
			 Demo1.display(null, statement, myCon);
			 
		 }
		 catch(Exception e){
			 System.out.println("Error will occur");
		 }
	}
}
