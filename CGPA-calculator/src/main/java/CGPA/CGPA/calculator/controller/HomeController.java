package CGPA.CGPA.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")  // root URL: http://localhost:8080/
    public String home() {
        return "Welcome to CGPA Calculator 🚀";
    }
}