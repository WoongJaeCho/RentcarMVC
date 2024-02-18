package com.basic.rentcar.controller.car;

import java.io.IOException;



import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CarSelectOptionController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int no = Integer.parseInt(req.getParameter("no"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		String img = req.getParameter("img");
		
		if(req.getParameter("no") == null) {
			return "redirect:/myRentcarMVC2/carList.do";
		}
		
		req.setAttribute("no", no);
		req.setAttribute("qty", qty);
		req.setAttribute("img", img);
		req.setAttribute("center", "rentcar/carOption");
		
		return "main";
	}

}
