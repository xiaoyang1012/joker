package com.yang.joker.controller;

import com.yang.joker.entity.student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    @RequestMapping("/")
    public String init(Model model){
        List<String> users=new ArrayList();
        users.add("yang");
        users.add("yang1");
        users.add("yang2");
        student student=new student("yang","25",45,"男");

        model.addAttribute("users",users);
        model.addAttribute("student",student);

        return "hello";
    }
}
