package com.basic.rentcar.controller.user;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.VO.User;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int log = (int) session.getAttribute("log");
		
		if(log <= 0 ) {
			req.removeAttribute("center");
			return "main";
		}
		
		
		int no = Integer.parseInt(req.getParameter("no"));
		String pw = req.getParameter("pw");
		User user = UserDAO.getInstance().getUserByNum(no);
		if(!user.getPw().equals(pw)) {
			req.setAttribute("user", user);
			req.setAttribute("center", "user/userInfo");
			return "main";
		}
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String hobby = req.getParameter("hobby");
		String job = req.getParameter("job");
		String age = req.getParameter("age");
		String info = req.getParameter("info");
		
		int cnt = UserDAO.getInstance().updateOneMember(no, age, email, tel, hobby, job, info);
		User newUser = UserDAO.getInstance().getUserByNum(no);
		if(cnt>0) {
			req.setAttribute("user", newUser);
			req.setAttribute("center", "user/userInfo");
		} else {
			req.setAttribute("user", user);
			req.setAttribute("center", "user/userInfo");
		}
		return "main";
	}

}
