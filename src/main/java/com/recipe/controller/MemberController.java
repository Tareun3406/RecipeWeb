package com.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("member/login")
    public String memberLogin(){
        return "member/loginForm";
    }

    @GetMapping("member/join")
    public String memberJoin(){
        return "member/joinForm";
    }

    @GetMapping("member/findID")
    public String memberFindID(){
        return "member/findId";
    }

    @GetMapping("member/findPW")
    public String memberFindPW(){
        return "member/findPw";
    }
}
