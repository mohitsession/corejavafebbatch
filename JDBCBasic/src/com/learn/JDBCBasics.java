package com.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBasics {

	public static void main(String[] args) {

		Connection connection = null;
		try {
			// Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Get connection from driverManager
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "admin");

			Statement statement = connection.createStatement();

			int executeUpdate2 = statement.executeUpdate(
					"insert into students (name, email,course,marks) values ('select 1 from dual', 'sham3@gmail.com', 'dot net', 66.5)");

			System.out.println("Execute Update count is " + executeUpdate2);

			// Prepared statement
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into students (name, email,course,marks) values (?, ?, ?, ?)");

			preparedStatement.setString(1, "delete * from dual");
			preparedStatement.setString(2, "rohan2@gmail.com");
			preparedStatement.setString(3, "Node.js");
			preparedStatement.setDouble(4, 99.9);

			int rowAffected = preparedStatement.executeUpdate();
			System.out.println("No of rows inserted " + rowAffected);
			preparedStatement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		try (Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
				"admin");
				PreparedStatement preparedStatement = connection1
						.prepareStatement("update students set marks = ? where id = ?")) {
			preparedStatement.setDouble(1, 50);
			preparedStatement.setInt(2, 5);
			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println("rows affected : " + executeUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try (Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
				"admin");
				PreparedStatement preparedStatement = connection1.prepareStatement("select * from students")) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.print("Id : " + resultSet.getInt("id"));
				System.out.print(" Name : " + resultSet.getString("name"));
				System.out.print(" email : " + resultSet.getString("email"));
				System.out.print(" course : " + resultSet.getString("course"));
				System.out.print(" marks : " + resultSet.getDouble("marks"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// delete from students where name = 'ram'
	}

}
