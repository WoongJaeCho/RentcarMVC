package com.basic.rentcar.controller.util;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.basic.rentcar.controller.DAO.RentCarDAO;
import com.basic.rentcar.controller.VO.Rentcar;


@WebServlet("/uploadProcess.do")
public class UploadProcess extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		try {
			String saveDirectory = getServletContext().getRealPath("/IMG");
			System.out.println("save=" +saveDirectory);
			
			String originalFileName = Util.uploadFile(req, saveDirectory);
			int cnt = insertMyFile(req, res, originalFileName);
			if(cnt == 0) {
				Util.getInstance().alertAndBack(res, "업로드 실패");
			} else {
				Util.getInstance().alertAndGo(res, "업로드 성공", "allCarList");
			}
			
		} catch (Exception e) {

		}
	}
	
	private int insertMyFile(HttpServletRequest req, HttpServletResponse res, String oFileName) {
		
		String num = req.getParameter("no");
		
		String name = req.getParameter("name");
		String company = req.getParameter("company");
		String img = oFileName.equals("")? req.getParameter("img") : oFileName;
		System.out.println(oFileName);
		System.out.println(img);
		String info = req.getParameter("info");
		int category = Integer.parseInt(req.getParameter("category"));
		int price = Integer.parseInt(req.getParameter("price"));
		int usepeople = Integer.parseInt(req.getParameter("usepeople"));
		int totalQty = Integer.parseInt(req.getParameter("totalQty"));
		int cnt =0;
		if(num == null) {
			Rentcar car = new Rentcar(name, category, price, usepeople, totalQty, company, img, info);
			
			cnt = RentCarDAO.getInstance().addOneCar(car);
			
		} else {
			int no = Integer.parseInt(num);
			
			cnt = RentCarDAO.getInstance().updateOneCar(no, name, category, price, usepeople, totalQty, company, img, info);
		
		}
		return cnt;
		
	}

}
