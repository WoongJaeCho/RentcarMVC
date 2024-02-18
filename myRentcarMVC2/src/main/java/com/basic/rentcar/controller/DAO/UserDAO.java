package com.basic.rentcar.controller.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.controller.VO.User;
import com.basic.rentcar.controller.util.Util;


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
		String sql = "select * from member";
		try {
			conn =  Util.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String hobby = rs.getString("hobby");
				String job = rs.getString("job");
				String age = rs.getString("age");
				String info = rs.getString("info");
				
				User u = new User(no,id,pw,email,tel,hobby,job,age,info);
				System.out.println(u);
				list.add(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			Util.getInstance().dbClose();
		}
		System.out.println(list.size());
		return list;
	}
	
	public boolean isValidId(String id) {
		String sql = "select * from member where id=?";
		try {
			conn =  Util.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			return rs.next();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			Util.getInstance().dbClose();
		}
		return false;
	}
   
	
	public int checkLogin(String id, String pw) {
		System.out.println(id);
		System.out.println(pw);
		String sql = "select * from member where id=? and pw=?";
		int num = 0;
		try {
			conn =  Util.getInstance().getConnection();
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
			Util.getInstance().dbClose();
		}
		
		return num;
	}
	
	public int addOneMember(User user) {
		String sql ="insert into member values(null,?,?,?,?,?,?,?,?)";
		int row =0;
		try {
			conn =  Util.getInstance().getConnection();
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
			Util.getInstance().dbClose();
		}
		return row;
	}
	
	public int updateOneMember(int no, String age, String email, String tel, String hobby, String job, String info) {
    	int cnt =0;
    	  String sql="update member set age=?, email=?, tel=?, hobby=?, job=?, info=? where no=?";
   
    	  try {
    		  conn =  Util.getInstance().getConnection();
    		  ps = conn.prepareStatement(sql);
    		  ps.setString(1, age);
    		  ps.setString(2,email);
    		  ps.setString(3,tel);
    		  ps.setString(4,hobby);
    		  ps.setString(5,job);
    		  ps.setString(6,info);
    		  ps.setInt(7, no);
    		  cnt = ps.executeUpdate();
    		  
    		  if(cnt >0) {
    			  System.out.println("회원 수정 성공");
    		  }else {
    			  System.out.println("회원 수정 실패");
    		  }
    		  
    	  }catch(SQLException e) {
    			
    		}finally{
    			Util.getInstance().dbClose();
    		}
    	return cnt;
    }
	
	public int deleteOneMember(String id) {
		System.out.println(id);
		  String sql="delete from member where id = ?";
		  int cnt =0;
		  try {
			  ReservationDAO.getInstance().oneUserRemoveReserve(id);
			  conn =  Util.getInstance().getConnection();
			  ps = conn.prepareStatement(sql);
			  ps.setString(1, id);
			  cnt = ps.executeUpdate();
			  System.out.println("여기cnt="+cnt);
			  if(cnt >0) {
				  System.out.println("회원 삭제 성공");
			  }else {
				  System.out.println("회원 삭제 실패");
			  }
			  
		  }catch(SQLException e) {
				
			}finally{
				Util.getInstance().dbClose();
			}
		  return cnt;
		}
	
	public User getUserByNum(int num) {
		list = getUserList();
		for(User u : list) {
			if(u.getNo() == num) {
				return u;
			}
		}
		return null;
	}
}
