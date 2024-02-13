package com.basic.rentcar.controller.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlController {
	
	private sqlController() {}
	
	private static sqlController sql = new sqlController();
	
	public static sqlController getInstance() {
		return sql;
	}
	
	private Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/rentcarDB01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String dbID = "root";
		String dbPassword = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void dbClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
	}
}
