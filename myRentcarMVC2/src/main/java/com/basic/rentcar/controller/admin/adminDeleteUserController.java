package com.basic.rentcar.controller.admin;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class adminDeleteUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		if(!id.equals("admin")) {
			
			int cnt = UserDAO.getInstance().deleteOneMember(id);
			
			
			
		} 
			
		
		
		return "redirect:/myRentcarMVC2/adminUserList.do";
	}

}
