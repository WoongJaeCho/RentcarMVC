package com.basic.rentcar.controller.user;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.VO.User;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int log = -1;
		log = (int) session.getAttribute("log");
		
		if(log == -1) {
			req.removeAttribute("center");
			return "main";
		}
		
		User user = UserDAO.getInstance().getUserByNum(log);
		System.out.println(user);
		req.setAttribute("user", user);
		
		req.setAttribute("center", "user/userInfo");
		return "main";
	}

}
