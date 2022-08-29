package com.nantus.loginportal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

    @Autowired
    private StudentRepository studentRepository;

    @DeleteMapping("/student_delete/{id}")
    public String studentDelete(@ModelAttribute Integer id, Model model) {
        try {
            studentRepository.deleteById(id);
            return "redirect:/admin_opperations";
        } catch (Exception er) {
            return er.getMessage();
        }
    }

    @RequestMapping("/student_edit")
    @ResponseBody
    public ModelAndView showEditstudentPage(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_student");
        Optional<Student> student = studentRepository.findById(id);
        mav.addObject("student", student);

        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);

        return "redirect:/admin_opperations";
    }
}