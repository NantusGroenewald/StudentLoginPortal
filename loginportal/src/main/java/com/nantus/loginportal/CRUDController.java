package com.nantus.loginportal;

import java.util.ArrayList;
import java.util.List;

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
            return "Deleted";
        } catch (Exception er) {
            return er.getMessage();
        }
    }

    @RequestMapping("/student_edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "student.student_id") int id) {
        ModelAndView mav = new ModelAndView("edit_student");
        Student student = studentRepository.findById(id).get();
        mav.addObject("product", student);

        return mav;
    }
}