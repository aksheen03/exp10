
package com.example.hostelmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hostelmgmt.domain.Student;
import com.example.hostelmgmt.repository.StudentRepository;

@Controller
public class RegisterController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/signup")
    public String displaySignup() {
        return "redirect:/register.html";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/index.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(
            @RequestParam String studentname,
            @RequestParam String password) {

        Student student =
                repo.findByStudentnameAndPassword(
                        studentname, password);

        if (student != null) {
            return "Login successful! Welcome, "
                    + studentname + "!";
        }

        return "Invalid username or password. Please try again.";
    }
}
