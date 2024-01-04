package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Crud_Operations {
	static String INSERT_QUERY= "INSERT into `student_management`(`ID`, `NAME`, `EMAIL`, `DEPARTMENT`, `CONTACT`, `CGPA`)values(?,?,?,?,?,?)";
	static String UPDATE_QUERY1 = "UPDATE `student_management` set `EMAIL` = ? WHERE ID = ?";
	static String UPDATE_QUERY2 = "UPDATE `student_management` set `CONTACT` = ? WHERE ID = ?";
	static String UPDATE_QUERY3 = "UPDATE `student_management` set `CGPA` = ? WHERE ID = ?";
	static String DELETE_QUERY = "DELETE from `student_management` WHERE ID = ?";
	static String SELECT_QUERY = "SELECT * FROM `student_management`";
	static Scanner sc = new Scanner(System.in);
	static Connection myCon;
	static PreparedStatement statement ;
	static Statement createStatement = null;
	static  ResultSet res = null;

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "harish";
		
		try {
			myCon = DriverManager.getConnection(url, username, password);
			System.out.println("Select the Query number you want to excute");
			System.out.println("1.INSERT \n2.UPDATE \n3.DELETE \n4.SELECT \n5.EXIT" );
			int num = sc.nextInt();
			if(num == 1) {
				insert();
				dispaly();
			}
			else if(num == 2) {
				update();
				dispaly();
			}
			else if(num == 3) {
				delete();
				dispaly();
			}
			else if(num == 4) {
				select();
			}
			else if(num == 5) {
				myCon.close();
				dispaly();
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	public static void insert() throws SQLException {
		statement = myCon.prepareStatement(INSERT_QUERY);
		do {
			System.out.println("ENTER STUDENT ID: ");
			 statement.setInt(1, sc.nextInt());
			 System.out.println("ENTER STUDENT NAME: ");
			 statement.setNString(2, sc.next());
			 System.out.println("ENTER STUDENT EMAIL: ");
			 statement.setNString(3, sc.next());
			 System.out.println("ENTER STUDENT DEPARTMENT: ");
			 statement.setNString(4, sc.next());
			 System.out.println("ENTER STUDENT CONTACT: ");
			 statement.setString(5, sc.next());
			 System.out.println("ENTER STUDENT CGPA: ");
			 statement.setFloat(6, sc.nextFloat());
			 int i = statement.executeUpdate();
			 System.out.println("Do you want insert more student details: (yes/no)");
		}
		while(sc.next().equalsIgnoreCase("yes"));
	}
	public static void update() throws SQLException {
		System.out.println("Enter details to UPDATE EMAIL or CONTACT or CGPA");
		String Str = sc.next();
		if(Str.equalsIgnoreCase("email")) {
			statement = myCon.prepareStatement(UPDATE_QUERY1);
			System.out.println("Enter Student email: ");
			statement.setString(1, sc.next());
			System.out.println("Enter Student id: ");
			statement.setInt(2, sc.nextInt());
			int i = statement.executeUpdate(); 
			System.out.println(i);
		}
		else if(Str.equalsIgnoreCase("contact")) {
			statement = myCon.prepareStatement(UPDATE_QUERY2);
			System.out.println("Enter Contact Number: ");
			statement.setString(1, sc.next());
			System.out.println("Enter Student id: ");
			statement.setInt(2, sc.nextInt());
			int i = statement.executeUpdate();
			System.out.println(i);
		}
		else if(Str.equalsIgnoreCase("cgpa")) {
			statement = myCon.prepareStatement(UPDATE_QUERY3);
			 System.out.println("Enter Student CGPA: ");
			 statement.setFloat(1, sc.nextFloat());
			 System.out.println("Enter Student id: ");
			 statement.setInt(2, sc.nextInt());
			 int i = statement.executeUpdate();
			 System.out.println(i);
		}
	}
	public static void delete() throws SQLException {
		statement = myCon.prepareStatement(DELETE_QUERY);
		do {
			System.out.println("ENTER STUDENT ID: ");
			statement.setInt(1, sc.nextInt());
			int i = statement.executeUpdate();
			System.out.println("Do you want delete more student details: (yes/no)");
			
		}
		while(sc.next().equalsIgnoreCase("yes"));
	}
	public static void  select() throws SQLException {
		createStatement = myCon.createStatement();
		res = createStatement.executeQuery(SELECT_QUERY);
		while(res.next()) {
			int id = res.getInt("ID");
			String name = res.getString("NAME");
			String email = res.getString("EMAIL");
			String department = res.getString("DEPARTMENT");
			String contact = res.getString("CONTACT");
			float cgpa = res.getFloat("CGPA");
			System.out.println(id+" "+name+" "+email+" "+department+" "+contact+" "+cgpa);
	}
	}
		public static void  dispaly() throws SQLException {
			createStatement = myCon.createStatement();
			res = createStatement.executeQuery(SELECT_QUERY);
			System.out.println("-------------------------------------------------------------------------------");
			while(res.next()) {
				int id = res.getInt("ID");
				String name = res.getString("NAME");
				String email = res.getString("EMAIL");
				String department = res.getString("DEPARTMENT");
				String contact = res.getString("CONTACT");
				float cgpa = res.getFloat("CGPA");
				
				System.out.println(id+" "+name+" "+email+" "+department+" "+contact+" "+cgpa);
		}
			System.out.println("-------------------------------------------------------------------------------");

}}
