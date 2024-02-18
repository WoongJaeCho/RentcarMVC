package com.basic.rentcar.controller.car;

import java.io.IOException;

import java.util.ArrayList;

import com.basic.rentcar.controller.DAO.RentCarDAO;
import com.basic.rentcar.controller.VO.Rentcar;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CarListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String cate = req.getParameter("category");
		int category = 0;
		if(cate != null) {
			category = Integer.parseInt(cate);
		}
		
		ArrayList<Rentcar> clist;
		
		if(category>0) {
			clist = RentCarDAO.getInstance().getCategoryCar(category);
			
		} else {
			clist = RentCarDAO.getInstance().getAllCar();
			
		}
		
		System.out.println(clist);
		req.setAttribute("clist", clist);
		
		req.setAttribute("center", "rentcar/rentCarList");
		
		return "main";
		
	}

}
