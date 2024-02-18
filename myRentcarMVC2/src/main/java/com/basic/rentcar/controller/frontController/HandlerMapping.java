package com.basic.rentcar.controller.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.admin.CarImgUploadController;
import com.basic.rentcar.controller.admin.CarInsertController;
import com.basic.rentcar.controller.admin.CarUpdateController;
import com.basic.rentcar.controller.admin.adminDeleteUserController;
import com.basic.rentcar.controller.admin.adminUserListController;
import com.basic.rentcar.controller.admin.allCarListController;
import com.basic.rentcar.controller.car.CarInfoController;
import com.basic.rentcar.controller.car.CarListController;
import com.basic.rentcar.controller.car.CarSelectOptionController;
import com.basic.rentcar.controller.car.ReservateCarController;
import com.basic.rentcar.controller.car.ReservationResultController;
import com.basic.rentcar.controller.reservate.ReservateDeleteController;
import com.basic.rentcar.controller.reservate.ReservateUserListController;
import com.basic.rentcar.controller.user.DeleteController;
import com.basic.rentcar.controller.user.JoinController;
import com.basic.rentcar.controller.user.LoginController;
import com.basic.rentcar.controller.user.LogoutController;
import com.basic.rentcar.controller.user.MainController;
import com.basic.rentcar.controller.user.UpdateController;
import com.basic.rentcar.controller.user.UserInfoController;
import com.basic.rentcar.controller.user.ValidIdAjaxController;

public class HandlerMapping {
	
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>(); 
		
		// main
		mappings.put("/main.do", new MainController());
		
		// user
		mappings.put("/userLogin.do", new LoginController());
		mappings.put("/userLogout.do", new LogoutController());
		mappings.put("/userJoin.do", new JoinController());
		mappings.put("/userDelete.do", new DeleteController());
		mappings.put("/userUpdate.do", new UpdateController());
		mappings.put("/userInfo.do", new UserInfoController());
		mappings.put("/validIdAjax.do", new ValidIdAjaxController());
		
		// car
		mappings.put("/carInfo.do", new CarInfoController());
		mappings.put("/carList.do", new CarListController());
		mappings.put("/carSelectOption.do", new CarSelectOptionController());
		mappings.put("/reservateCar.do", new ReservateCarController());
		mappings.put("/reservationResult.do", new ReservationResultController());
		
		// reservate
		mappings.put("/reservateDelete.do", new ReservateDeleteController());
		mappings.put("/reservateUserList.do", new ReservateUserListController());
		
		
		//admin
		mappings.put("/allCarList.do", new allCarListController());
		mappings.put("/carUpdate.do", new CarUpdateController());
		mappings.put("/carInsert.do", new CarInsertController());
		mappings.put("/carImgUpload.do", new CarImgUploadController());
		mappings.put("/adminUserList.do", new adminUserListController());
		mappings.put("/adminDeleteUser.do", new adminDeleteUserController());
		
		//fileupload
		//mappings.put("/uploadProcess.do", new UploadProcess());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
