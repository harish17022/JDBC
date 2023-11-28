package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {

	public static void main(String[] args) {
		
			 String url="jdbc:mysql://localhost:3306/jdbcclasses";
			 String username="root";
			 String password="harish";
			 String sql ="DELETE from `employee` where `id` = 12";
			 Connection myCon = null;
			 Statement statement = null;
			 ResultSet res = null;
			 try {
				 myCon=DriverManager.getConnection(url,username,password);
				 statement=myCon.createStatement();
				 int i =statement.executeUpdate(sql);
				 System.out.println(i);
				 
				 
				 
				 
				 
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
}