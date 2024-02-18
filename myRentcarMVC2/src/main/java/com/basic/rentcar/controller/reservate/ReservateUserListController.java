package com.basic.rentcar.controller.reservate;

import java.io.IOException;
import java.util.ArrayList;

import com.basic.rentcar.controller.DAO.ReservationDAO;
import com.basic.rentcar.controller.VO.joinCarView;
import com.basic.rentcar.controller.frontController.Controller;
import com.basic.rentcar.controller.util.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReservateUserListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			Util.getInstance().alertAndGo(res, "로그인 후 이용가능", "userLogin");
		}
		ArrayList<joinCarView> clist = ReservationDAO.getInstance().getAllReserve(id);
		
		for(int i=0; i<clist.size();i+=1) {
			int totalprice = clist.get(i).getPrice();
			if(clist.get(i).getUsein() == 1) totalprice += 10000;
			if(clist.get(i).getUseseat() == 1) totalprice += 10000;
			if(clist.get(i).getUsewifi() == 1) totalprice += 10000;
			
			totalprice = totalprice * clist.get(i).getQty() * clist.get(i).getDday();
			clist.get(i).setPrice(totalprice);
		}
		req.setAttribute("clist", clist);
		req.setAttribute("center", "rentcar/userReserveList");
		
		return "main";
	}

}
