package com.basic.rentcar.controller.car;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.RentCarDAO;
import com.basic.rentcar.controller.VO.Rentcar;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CarInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int no = Integer.parseInt(req.getParameter("no"));
		Rentcar car = RentCarDAO.getInstance().getOneCar(no);
		
		System.out.println(car);
		req.setAttribute("car", car);
		
		req.setAttribute("center", "rentcar/rentCarInfo");
		
		return "main";
	}

}
