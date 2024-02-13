package com.basic.rentcar.controller.user;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.VO.User;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Join 들어옴");
		String id = req.getParameter("id");
		System.out.println(id);
		if(id == null) {
			req.setAttribute("center", "user/join");
			return "main";
		}
		String pw = req.getParameter("pw");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String hobby = req.getParameter("hobby");
		String job = req.getParameter("job");
		String age = req.getParameter("age");
		String info = req.getParameter("info");
		
		
		User u = new User(0, id, pw, email, tel, hobby, job, age, info);
		
		int cnt = UserDAO.getInstance().addOneMember(u);
		if(cnt>0) {
			req.removeAttribute("center");
		} else {
			req.setAttribute("center", "user/join");
		}
		return "main";
	}

}
