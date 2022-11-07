package edu.depaul.cdm.se452.se452demo.concepts.webcontroller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GreeterController {
    @GetMapping("/greeting")
    public String greetingForm() {
        return "greeting";
    }    

    @GetMapping("/greeting/{name}")
    public String greetingForm(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "greetme";
    }    
}
