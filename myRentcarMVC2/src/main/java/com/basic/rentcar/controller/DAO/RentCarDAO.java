package com.basic.rentcar.controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.controller.VO.Rentcar;
import com.basic.rentcar.controller.util.Util;


public class RentCarDAO {
	
	static private RentCarDAO instance;
	static public RentCarDAO getInstance() {
		if(instance == null) {
			instance = new RentCarDAO();
		}
		return instance;
	}
	
	static private ArrayList<Rentcar> clist;
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
public ArrayList<Rentcar> getSelectCar() {
		
		clist = new ArrayList<Rentcar>();
		try {
			
			conn =  Util.getInstance().getConnection();

			String sql = "SELECT * FROM rentcar ORDER BY rand() limit 3";
//			String sql = "SELECT * FROM rentcar ORDER BY no DESC";
			// String sql = "SELECT * FROM rentcar ORDER BY no DESC LIMIT 3";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {

				Rentcar bean = new Rentcar();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));
				
				clist.add(bean);
				count++;
				
				if (count > 2)
					break; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.getInstance().dbClose();
		}

		return clist;
	}
public int updateOneCar(int no, String name, int category, int price, int usepeople, int total_qty, String company, String img, String info) {
	int cnt =0;
	String sql="update rentcar set name=?, category=?, price=?, usepeople=?, total_qty=?, company=?, img=?, info=? where no=?";
	
	try {
		conn =  Util.getInstance().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, category);
		ps.setInt(3, price);
		ps.setInt(4, usepeople);
		ps.setInt(5, total_qty);
		ps.setString(6, company);
		ps.setString(7, img);
		ps.setString(8, info);
		ps.setInt(9, no);
		cnt = ps.executeUpdate();
		
		if(cnt >0) {
		  System.out.println("차량 수정 성공");
		}else {
		  System.out.println("차량 수정 실패");
		}
	} catch (SQLException e){
		
	} finally {
		Util.getInstance().dbClose();
	}
	
	return cnt;
}

public int addOneCar(Rentcar car) {
	String sql = "insert into rentcar values(null,?,?,?,?,?,?,?,?)";
	int cnt=0;
	try {
		conn =  Util.getInstance().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, car.getName());
		ps.setInt(2, car.getCategory());
		ps.setInt(3, car.getPrice());
		ps.setInt(4, car.getUsepeople());
		ps.setInt(5, car.getTotalQty());
		ps.setString(6, car.getCompany());
		ps.setString(7, car.getImg());
		ps.setString(8, car.getInfo());
		System.out.println("ps "+ps);
		cnt=ps.executeUpdate(); // 삽입한 cnt 갯수를 리턴 
		System.out.println(" 차량 신규 추가 완료 = " + cnt);
		
	}catch(SQLException e) {
		
	}finally{
		Util.getInstance().dbClose();
	}
	
	return cnt;
	
}
public Rentcar getOneCar(int no) {
	
	Rentcar bean = new Rentcar();
	conn =  Util.getInstance().getConnection();

	try {
		
		String sql = "SELECT * FROM rentcar WHERE no=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, no);

		rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("no=" + no );
			System.out.println("total qty=" + rs.getInt("total_qty"));
			bean.setNo(no);
			bean.setName(rs.getString("name"));
			bean.setCategory(rs.getInt("category"));
			bean.setPrice(rs.getInt("price"));
			bean.setUsepeople(rs.getInt("usepeople"));
			bean.setTotalQty(rs.getInt("total_qty"));
			bean.setCompany(rs.getString("company"));
			bean.setImg(rs.getString("img"));
			bean.setInfo(rs.getString("info"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Util.getInstance().dbClose();
	}
	return bean;
}


public ArrayList<Rentcar> getAllCar() {
	clist = new ArrayList<Rentcar>();
	
	Rentcar bean = null;

	conn =  Util.getInstance().getConnection();
	try {
		String sql = "SELECT * FROM rentcar ORDER BY no DESC";
		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			bean = new Rentcar();
			bean.setNo(rs.getInt("no"));
			bean.setName(rs.getString("name"));
			bean.setCategory(rs.getInt("category"));
			bean.setPrice(rs.getInt("price"));
			bean.setUsepeople(rs.getInt("usepeople"));
			bean.setTotalQty(rs.getInt("total_qty"));
			bean.setCompany(rs.getString("company"));
			bean.setImg(rs.getString("img"));
			bean.setInfo(rs.getString("info"));
			
			clist.add(bean);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Util.getInstance().dbClose();
	}
	return clist;

}
public ArrayList<Rentcar> getCategoryCar(int cate) {

	clist = new ArrayList<Rentcar>();
	
	Rentcar bean = null;

	conn =  Util.getInstance().getConnection();
	try {
		String sql = "SELECT * FROM rentcar WHERE category=?";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, cate);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			bean = new Rentcar();
			bean.setNo(rs.getInt("no"));
			bean.setName(rs.getString("name"));
			bean.setCategory(rs.getInt("category"));
			bean.setPrice(rs.getInt("price"));
			bean.setUsepeople(rs.getInt("usepeople"));
			bean.setTotalQty(rs.getInt("total_qty"));
			bean.setCompany(rs.getString("company"));
			bean.setImg(rs.getString("img"));
			bean.setInfo(rs.getString("info"));
			
			clist.add(bean);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Util.getInstance().dbClose();
	}
	return clist;
}

}
