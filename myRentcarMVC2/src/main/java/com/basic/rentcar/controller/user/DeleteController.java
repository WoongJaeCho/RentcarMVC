package com.basic.rentcar.controller.user;

import java.io.IOException;


import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.VO.User;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int log = (int) session.getAttribute("log");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		User user = UserDAO.getInstance().getUserByNum(log);
		String passData = "false";
		
		if(user.getPw().equals(pw)) {
			passData = "pass";
			req.removeAttribute("center");
			int cnt = UserDAO.getInstance().deleteOneMember(id);
			if(cnt>0) {
				session.removeAttribute("User");
				session.removeAttribute("log");
				session.removeAttribute("center");
			}
		}
		res.getWriter().print(passData);
		return null;
	}

}
