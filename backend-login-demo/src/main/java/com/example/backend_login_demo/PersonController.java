package com.example.backend_login_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PersonController {
    @Autowired  // PersonRepository 의 인스턴스 주입 받음
    private PersonRepository repository;

    @GetMapping("/signup")
    public String showSignUpPage() {
        return "signup";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String userPwd, Model model) {
        Optional<Person> optPerson = repository.findByUserId(userId);
        if (optPerson.isPresent() && optPerson.get().getUserPwd().equals(userPwd)) {
            return "success";
        }

        model.addAttribute("error", "로그인 실패");
        return "index";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Person person, Model model) {
        if (repository.findByUserId(person.getUserId()).isPresent()) {
            model.addAttribute("error", "동일 아이디 존재");
            return "index";
        }

        repository.save(person);
        return "success";
    }
}
