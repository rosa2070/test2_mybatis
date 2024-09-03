package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.mybatis.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class InsertController {

    @Autowired MemberService service;

    @GetMapping("/member/insert")
    public String insertForm() {
        return "member/insert";
    }

    @PostMapping("/member/insert")
    public String insert(@ModelAttribute Member dto, Model model) {
        try {
            service.insert(dto);
            model.addAttribute("result", "회원가입성공!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("result", "회원가입실패");

        }
        return "member/result";
    }

}
