package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Prepareuser1 {
	private final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		 String url="jdbc:mysql://localhost:3306/jdbcclasses";
		 String username="root";
		 String password="harish";
		 String choice = null;
		 String sql = "INSERT into employee(id,name,email,department,salary)values(?,?,?,?,?)";
		 Connection myCon = null;
		 PreparedStatement statement = null;
		 try {
			 
			 myCon=DriverManager.getConnection(url,username,password);
			 Demo1.display(null, statement, myCon);
			 statement=myCon.prepareStatement(sql);
			 
			do {
				 System.out.println("Enter id: ");
				 statement.setInt(1, sc.nextInt());
				 System.out.println("Enter name: ");
				 statement.setString(2, sc.next());
				 System.out.println("Enter email id: ");
				 statement.setString(3, sc.next());
				 System.out.println("Enter department: ");
				 statement.setString(4, sc.next());
				 System.out.println("Enter salary: ");
				 statement.setInt(5, sc.nextInt());
				 int i = statement.executeUpdate();
				 System.out.println(i);
				 System.out.println("do you want enter some more id's..Type(yes/no)");
				 choice=sc.next();
			}
			 while(choice.equalsIgnoreCase("yes")) ;
				 
			 
			 Demo1.display(null, statement, myCon);
			 
		 }
		 catch(Exception e) {
			 System.out.println("Exception will occur..");
		 }
	}
}
