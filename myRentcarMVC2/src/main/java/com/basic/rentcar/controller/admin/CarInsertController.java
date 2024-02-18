package com.basic.rentcar.controller.admin;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.RentCarDAO;
import com.basic.rentcar.controller.VO.Rentcar;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CarInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
//		String name = req.getParameter("name");
		
//		if(name == null) {
			
			req.setAttribute("center", "rentcar/registerCar");
			return "main";
			
//		} else {
//			String company = req.getParameter("company");
//			String img = req.getParameter("img");
//			String info = req.getParameter("info");
//			int category = Integer.parseInt(req.getParameter("category"));
//			int price = Integer.parseInt(req.getParameter("price"));
//			int usepeople = Integer.parseInt(req.getParameter("usepeople"));
//			int totalQty = Integer.parseInt(req.getParameter("totalQty"));
//			System.out.println(name);
//			System.out.println(company);
//			System.out.println(img);
//			System.out.println(info);
//			System.out.println(category);
//			System.out.println(price);
//			System.out.println(usepeople);
//			System.out.println(totalQty);
//			Rentcar car = new Rentcar(name, category, price, usepeople, totalQty, company, img, info);
//			
//			int cnt = RentCarDAO.getInstance().addOneCar(car);
//			
//			if(cnt>0) {
//				return "redirect:/myRentcarMVC2/allCarList.do";
//			} else {
//				req.setAttribute("center", "rentcar/registerCar");
//				return "main";
//			}
//		}
		
	}

}
