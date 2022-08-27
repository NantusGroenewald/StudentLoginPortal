package com.nantus.loginportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginportalController {

	@Autowired
	private StudentRepository studentRepository; 
	
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
	public String studentRegisterSubmit(@ModelAttribute Student student, Model model){
		studentRepository.save(new Student(student.getStudent_name(), student.getStudent_address(), student.getStudent_course(), student.getStudent_email(),student.getStudent_password()));
		model.addAttribute("student", new Student()); 
		return "student_login";
	}
	@GetMapping("/admin_login")
	public String adminLogin() {
		return "admin_login";
	}


	
}
