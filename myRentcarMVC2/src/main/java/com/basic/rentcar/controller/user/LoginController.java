package com.basic.rentcar.controller.user;

import java.io.IOException;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.frontController.Controller;
import com.basic.rentcar.controller.util.Util;

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
			Util.getInstance().alertAndBack(res, "아이디 또는 비밀번호를 확인하세요");
		} else {
			Util.getInstance().alertAndGo(res, "로그인 완료", "main");
			System.out.println("로그인 됨");
			HttpSession session = req.getSession();
			session.setAttribute("log", idx);
			session.setAttribute("id", id);
			req.removeAttribute("center");
		}
		
		return null;
	}

}
