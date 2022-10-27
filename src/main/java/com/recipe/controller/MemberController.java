package com.recipe.controller;

import com.recipe.service.MemberService;
import com.recipe.vo.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 로그인 뷰 페이지
    @GetMapping("/member/login")
    public String memberLogin(){
        return "/member/loginForm";
    }


    // 로그아웃
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

    //아이디 중복 확인 ajax
    @PostMapping("/member/idCheck")
    public String member_idcheck(@RequestParam("userid") String userid, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        MemberDTO db_id = this.memberService.idCheck(userid);
        int re = -1;    // 중복아이디가 없는 경우 반환값
        if(db_id != null){
            re=1;   // 중복 아이디가 있는 경우
        }
        out.println(re);    //값 반환
        return null;
    }

    // 회원가입 확인(일반 유저)
    @PostMapping("/member/join")
    public String memberJoinCheck(MemberDTO vo){
        memberService.insertMemberUser(vo);
        return "redirect: login";
    }

    // 아이디 찾기 주소 매핑
    @GetMapping("/member/findID")
    public String memberFindID(){
        return "/member/findId";
    }

    // 아이디 찾기 결과 확인
    @PostMapping("/member/findID")
    public ModelAndView memberFindIdList(String email){

        ModelAndView mv = new ModelAndView("/member/findIdList");
        List<MemberDTO> memberList =  memberService.findIdList(email);
        mv.addObject("memberList", memberList);
        return mv;
    }

    // 비밀번호 찾기 주소 매핑
    @GetMapping("/member/findPW")
    public String memberFindPW(){
        return "/member/findPw";
    }

    // 비밀번호 변경후 이메일로 전송 및 확인
    @PostMapping("/member/findPW")
    public ModelAndView sendPwToEmail(MemberDTO member){
        ModelAndView mv = new ModelAndView("/member/findPwSended");
        String message;
        System.out.println(member);
        int result = memberService.changePwSend(member);

        if (result == 0){
            message = "아이디와 이메일을 다시 확인해주세요";
        }
        else {
            message = "이메일로 비밀번호가 전송되었습니다.";
        }
        mv.addObject("message", message);
        return mv;
    }
}
