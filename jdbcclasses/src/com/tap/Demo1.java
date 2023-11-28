package com.tap;

import java.sql.*;

public class Demo1 {
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		 String username="root";
		 String password="harish";
		 
		 
		 Connection myCon = null;
		 Statement statement = null;
		 ResultSet res = null;
		 try {
			 
			 myCon=DriverManager.getConnection(url,username,password);
			 display(res, statement, myCon);
			 
			 
		 }
		 catch(Exception e){	
			 e.printStackTrace();
			 
		 }
		 finally {
			 try {
				 if(res != null) {
					 res.close();
				 }
				 
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 try {
				 if(statement != null) {
					 statement.close();
				 }
				 
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 try {
				 if(myCon != null) {
					 myCon.close(); 
				 }
				 
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 
		 }
		 
	}


	public static void display(ResultSet res, Statement statement, Connection myCon) throws SQLException {
		String sql ="SELECT * FROM employee;";
		 
		 
		 statement=myCon.createStatement();
		 res =statement.executeQuery(sql);
		 
		 System.out.println("------------------------------------------------------------------");
		while(res.next()) {
			 
			 
			 int id = res.getInt("id");
			 String name = res.getString("name");
			 String email = res.getString("email");
			 String department = res.getString("department");
			 int salary = res.getInt("salary");
			 //System.out.println(id+" "+ name +" "+ email +" "+ department +" "+ salary);
			 System.out.printf("| %-4d | %-10s | %-20s | %-8s | %-8d |\n",id,name,email,department,salary);
		 }
		System.out.println("------------------------------------------------------------------");
	}
	

	private static String getString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int getInt(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

}
