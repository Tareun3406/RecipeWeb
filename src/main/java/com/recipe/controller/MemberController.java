package com.recipe.controller;

import com.recipe.service.MemberService;
import com.recipe.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 로그인 뷰 페이지
    @GetMapping("/member/login")
    public String memberLogin(){
        return "/member/loginForm";
    }


    @RequestMapping("/member/logout")
    public String memberLogout(HttpSession session, HttpServletResponse response){
        session.invalidate();

        return "redirect: /";
    }

    //회원가입페이지 매핑
    @GetMapping("/member/join")
    public String memberJoin(){
        return "/member/joinForm";
    }

    // 회원가입 확인(일반 유저)
    @PostMapping("/member/join")
    public String memberJoinCheck(MemberVO vo){
        memberService.insertMemberUser(vo);
        return "redirect: login";
    }

    @GetMapping("/member/findID")
    public String memberFindID(){
        return "/member/findId";
    }

    @GetMapping("/member/findPW")
    public String memberFindPW(){
        return "/member/findPw";
    }
}
