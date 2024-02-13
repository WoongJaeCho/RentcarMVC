package com.basic.rentcar.controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.controller.VO.User;
import com.basic.rentcar.controller.util.sqlController;

public class UserDAO {
	
	static private UserDAO instance;
	static public UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	static private ArrayList<User> list;
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public ArrayList<User> getUserList(){
		list = new ArrayList<User>();
		
		return list;
	}
	
	public int checkLogin(String id, String pw) {
		System.out.println(id);
		System.out.println(pw);
		String sql = "select * from member where id=? and pw=?";
		int num = 0;
		try {
			conn =  sqlController.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			System.out.println(ps);
			rs = ps.executeQuery();
			System.out.println("1");
			
			if(rs.next()) {
				System.out.println("2");
				num = rs.getInt("no");
			}
			return num;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			sqlController.getInstance().dbClose();
		}
		
		return num;
	}
	
	public int addOneMember(User user) {
		String sql ="insert into member values(null,?,?,?,?,?,?,?,?)";
		int row =0;
		try {
			conn =  sqlController.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPw());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getHobby());
			ps.setString(6, user.getJob());
			ps.setString(7, user.getAge());
			ps.setString(8, user.getInfo());
			System.out.println("ps "+ps);
			row=ps.executeUpdate(); // 삽입한 row 갯수를 리턴 
			System.out.println(" 회원 추가 완료 = " + row);
			
			
		}catch(SQLException e) {
			
		}finally{
			sqlController.getInstance().dbClose();
		}
		return row;
	}
}
