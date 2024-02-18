package com.basic.rentcar.controller.user;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ValidIdAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passData = UserDAO.getInstance().isValidId(id)? "notValid" : "Valid";
		
		res.getWriter().print(passData);
		return null;
	}

}
