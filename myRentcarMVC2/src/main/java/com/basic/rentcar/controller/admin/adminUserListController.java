package com.basic.rentcar.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.basic.rentcar.controller.DAO.UserDAO;
import com.basic.rentcar.controller.VO.User;
import com.basic.rentcar.controller.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class adminUserListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ArrayList<User> ulist = UserDAO.getInstance().getUserList();
		
		req.setAttribute("ulist", ulist);
		req.setAttribute("center", "admin/allUserList");
		return "main";
	}

}
