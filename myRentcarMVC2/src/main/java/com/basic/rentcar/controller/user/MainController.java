package com.basic.rentcar.controller.user;

import java.io.IOException;

import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.removeAttribute("center");
		
		Object log = req.getAttribute("log");
		
		System.out.println("main-log="+log);
		
		return "main";
	}

}
