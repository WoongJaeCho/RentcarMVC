package com.basic.rentcar.controller.user;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		if(id == null || pw == null) {
			System.out.println("Login 들어옴");
			req.setAttribute("center", "user/login");
			return "main";
		}
		int idx = UserDAO.getInstance().checkLogin(id, pw);
		
		if(idx == 0) {
			req.setAttribute("center", "user/login");
			System.out.println("로그인 안됨");
		} else {
			System.out.println("로그인 됨");
			HttpSession session = req.getSession();
			session.setAttribute("log", idx);
			session.setAttribute("id", id);
			req.removeAttribute("center");
		}
		
		return "main";
	}

}
