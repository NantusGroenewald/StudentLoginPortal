package com.nantus.loginportal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginportalController {
	@GetMapping("/student_login")
	public String studentLogin() {
		return "student_login";
	}
	@GetMapping("/student_register")
	public String studentRegister() {
		return "student_register";
	}
	@GetMapping("/admin_login")
	public String adminLogin() {
		return "admin_login";
	}
}
