package com.basic.rentcar.controller.car;

import java.io.IOException;
import java.util.ArrayList;

import com.basic.rentcar.controller.DAO.RentCarDAO;
import com.basic.rentcar.controller.VO.Rentcar;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReservateCarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		ArrayList<Rentcar> clist = RentCarDAO.getInstance().getSelectCar();
		
		System.out.println(clist);
		req.setAttribute("clist", clist);
		req.setAttribute("center", "rentcar/reserveCarView");
		
		return "main";
	}

}
