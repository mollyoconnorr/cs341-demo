package edu.carroll.cs341;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "Student") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}