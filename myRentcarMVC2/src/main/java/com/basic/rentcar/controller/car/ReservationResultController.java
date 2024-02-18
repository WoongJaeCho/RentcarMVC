package com.basic.rentcar.controller.car;

import java.io.IOException;
import java.time.LocalDate;

import com.basic.rentcar.controller.DAO.RentCarDAO;
import com.basic.rentcar.controller.DAO.ReservationDAO;
import com.basic.rentcar.controller.VO.Rentcar;
import com.basic.rentcar.controller.VO.Reservation;
import com.basic.rentcar.controller.frontController.Controller;
import com.basic.rentcar.controller.util.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReservationResultController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String img = req.getParameter("img");
		int no = Integer.parseInt(req.getParameter("no"));
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		int qty = Integer.parseInt(req.getParameter("qty"));
		
		int dday = Integer.parseInt(req.getParameter("dday"));
		String rday = req.getParameter("rday");
		int usein = Integer.parseInt(req.getParameter("usein"));
		int usewifi = Integer.parseInt(req.getParameter("usewifi"));
		int usenavi = Integer.parseInt(req.getParameter("usenavi"));
		int useseat = Integer.parseInt(req.getParameter("useseat"));
		
		
		LocalDate now = LocalDate.now();
	 	int compare = rday.compareTo(now.toString());
	 	
	 	if(compare < 0){
	 		Util.getInstance().alertAndBack(res, "오늘보다 이전 날짜는 선택 불가능");
	 	}
		
		Reservation re = new Reservation(no, id, qty, dday, rday, usein, usewifi, usenavi, useseat);
		ReservationDAO.getInstance().setReserveCar(re);
		
		Rentcar car = RentCarDAO.getInstance().getOneCar(no);
		
		int totalCar = car.getPrice() * qty * dday;
		int totalOption = 0;
		
		if(usein == 1) totalOption += 10000 * qty * dday;
		if(usewifi == 1) totalOption += 10000 * qty * dday;
		if(useseat == 1) totalOption += 10000 * qty * dday;
		
		req.setAttribute("totalCar", totalCar);
		req.setAttribute("totalOption", totalOption);
		req.setAttribute("img", img);
		req.setAttribute("center", "rentcar/reservationResult");
		
		return "main";
	}

}
