package com.basic.rentcar.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.basic.rentcar.controller.DAO.RentCarDAO;
import com.basic.rentcar.controller.VO.Rentcar;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class allCarListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ArrayList<Rentcar> clist = RentCarDAO.getInstance().getAllCar();
		
		req.setAttribute("clist", clist);
		req.setAttribute("center", "admin/allCarList");
		return "main";
	}

}
