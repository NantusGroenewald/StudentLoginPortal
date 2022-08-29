package com.nantus.loginportal;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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

	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/student_login")
	public String studentLoginForm(Model model) {
		model.addAttribute("student", new Student());
		return "student_login";
	}
	
	@PostMapping("/student_login")
	public String studentLoginSubmit(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student); 
		Iterable<Student> storedStudents = studentRepository.findAll();
		boolean loggedIn = false;
		for (Student savedStudent : storedStudents) {
			if (student.getStudent_email().equals(savedStudent.getStudent_email()) && student.getStudent_password().equals(savedStudent.getStudent_password())) {
				loggedIn = true;
                break; 
			} else {
				loggedIn = false;
			} 
		}
		if (loggedIn) {
			return "login_successful";
		} else{
			return "student_login";
		}
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
	public String adminLoginForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin_login";
	}

	@PostMapping("/admin_login")
	public String adminLoginSubmit(@ModelAttribute Admin admin, Model model) {
		model.addAttribute("admin", admin); 
		Iterable<Admin> storedAdmin = adminRepository.findAll();
		boolean loggedIn = false;
		for (Admin savedAdmin : storedAdmin) {
			if (admin.getAdmin_email().equals(savedAdmin.getAdmin_email()) && admin.getAdmin_password().equals(savedAdmin.getAdmin_password())) {
				loggedIn = true;
                break; 
			} else {
				loggedIn = false;
			} 
		}
		if (loggedIn) {
			Iterable<Student> intermediate = studentRepository.findAll();
			List<Student> studentList = new ArrayList<Student>();
			intermediate.forEach(studentList::add);
			model.addAttribute("studentList", studentList);
			return "admin_opperations";
		} else{
			return "admin_login";
		}
	}
	@GetMapping("/admin_opperations")
    public String studentDisplay(Model model) {
        Iterable<Student> intermediate = studentRepository.findAll();
        List<Student> studentList = new ArrayList<Student>();
        intermediate.forEach(studentList::add);
		System.out.println("ttest");
        model.addAttribute("studentList", studentList);
        return "admin_opperations";
    }

	@GetMapping("/display_admin")
	public @ResponseBody Iterable<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}

	@GetMapping("/display_students")
	public @ResponseBody Iterable<Student> getAllStudents(){
		return studentRepository.findAll();
	}
}
