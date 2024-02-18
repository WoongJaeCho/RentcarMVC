package com.basic.rentcar.controller.user;

import java.io.IOException;



import com.basic.rentcar.controller.frontController.Controller;
import com.basic.rentcar.controller.util.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		session.removeAttribute("log");
		session.removeAttribute("id");
		
		req.removeAttribute("center");
		Util.getInstance().alertAndGo(res, "로그아웃 완료", "main");
		return null;
	}

}
