package com.nantus.loginportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginportalController {

	@GetMapping("/student_login")
	public String studentLoginForm(Model model) {
		model.addAttribute("student", new Student());
		return "student_login";
	}

	@PostMapping("/student_login")
	public String studentLoginSubmit(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student); 
		return "login_successful";
	}

	@GetMapping("/student_register")
	public String studentRegister(Model model) {
		model.addAttribute("student", new Student());
		return "student_register";
	}

	@PostMapping("/student_register")
	public String studentRegisterSubmit(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student); 
		return "student_login";
	}
	@GetMapping("/admin_login")
	public String adminLogin() {
		return "admin_login";
	}


	
}
