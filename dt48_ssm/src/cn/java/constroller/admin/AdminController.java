package cn.java.constroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/")
public class AdminController {
	@RequestMapping("Login")
	public void AdminController() {
		System.out.println("AdminController.............Login");
	}
}
