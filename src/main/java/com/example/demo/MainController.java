package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/")
    public String getIndexPage() {
      return "index";
   }

    @GetMapping("/student")
    public String getStudentPage() {
        //чтобы вывести список студентов нужно добавить бин StudentsRepository положить данные в Model
        return "student";
    }

    @PostMapping("/students")
    public String students() {
        System.out.println("students");
        return "students";
    }

    @PostMapping("/addStudent")
    public String sendForm(@ModelAttribute Student student) {
        System.out.println(student);
//        studentsRepository.saveOrUpdateStudent(student);
        return "redirect:/";
    }

}