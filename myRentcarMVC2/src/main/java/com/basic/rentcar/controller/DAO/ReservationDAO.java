package com.basic.rentcar.controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.basic.rentcar.controller.VO.Reservation;
import com.basic.rentcar.controller.VO.joinCarView;
import com.basic.rentcar.controller.util.Util;


public class ReservationDAO {
	
	static private ReservationDAO instance;
	static public ReservationDAO getInstance() {
		if(instance == null) {
			instance = new ReservationDAO();
		}
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public void setReserveCar(Reservation bean) {
		
		conn =  Util.getInstance().getConnection();
		try {

			String sql = "INSERT INTO carreserve ( no, id, qty, dday, rday, "
					+ "usein, usewifi, usenavi, useseat)" + " VALUES( ?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, bean.getNo());
			ps.setString(2, bean.getId());
			ps.setInt(3, bean.getQty());
			ps.setInt(4, bean.getDday());
			ps.setString(5, bean.getRday());
			ps.setInt(6, bean.getUsein());
			ps.setInt(7, bean.getUsewifi());
			ps.setInt(8, bean.getUsenavi());
			ps.setInt(9, bean.getUseseat());

			if(ps.executeUpdate() > 0) {
				updateRentcarQty(bean.getNo() ,bean.getQty());
				System.out.println("차량 예약 완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.getInstance().dbClose();
		}
	}

	public ArrayList<joinCarView> getAllReserve(String id) {
	
		ArrayList<joinCarView> vlist = new ArrayList<>();
		joinCarView bean = null;
	
		conn =  Util.getInstance().getConnection();
	
		try {
			
			//select * from rentcar a2 ,carreserve a1  where a1.id = 'qwer' and curdate() < date_format(a1.rday , '%y-%m-%d') and a1.no = a2.no;
			// select * from rentcar a2 ,carreserve a1  where a1.id = 'qwer' and a1.no = a2.no;
			
			String sql = null;
			if(id.equals("admin")) {
				sql = "select * from rentcar a2 ,carreserve a1  where a1.no = a2.no order by rday" ;
				ps = conn.prepareStatement(sql);
			} else {
				sql = "select * from rentcar a2 ,carreserve a1  where a1.id = ? and a1.no = a2.no order by rday";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
			}
			System.out.println(id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				bean = new joinCarView();
				bean.setNo(rs.getInt("no"));
				bean.setReserveSeq(rs.getInt("reserve_seq"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("price"));
				bean.setImg(rs.getString("img"));
				bean.setQty(rs.getInt("qty"));
				bean.setDday(rs.getInt("dday"));
				bean.setRday(rs.getString("rday"));
				bean.setUsein(rs.getInt("usein"));
				bean.setUsewifi(rs.getInt("usewifi"));
				bean.setUsenavi(rs.getInt("usenavi"));
				bean.setUseseat(rs.getInt("useseat"));		
				vlist.add(bean);
				System.out.println(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.getInstance().dbClose();
		}
	
		return vlist;
	}
	
	private void updateRentcarQty(int no , int rentQty) {
		conn =  Util.getInstance().getConnection();

		try {
			String sql = "update rentcar set total_qty =total_qty - ? where no = ?";
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, rentQty);
			ps.setInt(2, no);
		
			ps.executeUpdate();	
			
			System.out.println("수량 업데이트 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.getInstance().dbClose();
		}
	}

	
	public void oneUserRemoveReserve(String id) {
		conn =  Util.getInstance().getConnection();
		try {
			String sql = "select * from carreserve where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int reserveSeq = rs.getInt("reserve_seq");
				int no = rs.getInt("no");
				int qty = rs.getInt("qty");
				
				carRemoveReserve(reserveSeq, qty, no);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.getInstance().dbClose();
		}
	}
	
	
	
	public void carRemoveReserve(int reserveSeq ,int qty , int no) {

		conn =  Util.getInstance().getConnection();
		try {
			String sql = "DELETE FROM carreserve where reserve_seq = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reserveSeq);
			if(ps.executeUpdate()> 0 ) {
				backRentcarQty(no, qty);
				System.out.println("삭제 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.getInstance().dbClose();
		}
	}
	
	//삭제하면 다시 토탈 car 다시 업데이트 되야함 
	private void backRentcarQty(int no , int rentQty) {
		conn =  Util.getInstance().getConnection();

		try {
			String sql = "update rentcar set total_qty =total_qty + ? where no = ?";
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, rentQty);
			ps.setInt(2, no);
		
			ps.executeUpdate();	
			
			System.out.println("rentQty= " + rentQty);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.getInstance().dbClose();
		}
	}
}
