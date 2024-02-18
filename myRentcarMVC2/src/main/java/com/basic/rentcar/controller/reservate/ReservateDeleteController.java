package com.basic.rentcar.controller.reservate;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.ReservationDAO;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReservateDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int resSeq = Integer.parseInt(req.getParameter("resSeq"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		int no = Integer.parseInt(req.getParameter("no"));
		
		ReservationDAO.getInstance().carRemoveReserve(resSeq, qty, no);
		
		req.setAttribute("center", "rentcar/userReserveList");
		return "redirect:/myRentcarMVC2/reservateUserList.do";
	}

}
