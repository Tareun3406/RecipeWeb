package com.recipe.controller;

import com.recipe.service.MemberService;
import com.recipe.vo.MemberVO;
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

    @PostMapping("/member/idCheck")
    public String member_idcheck(@RequestParam("userid") String userid, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        MemberVO db_id = this.memberService.idCheck(userid);

        int re = -1;    // 중복아이디가 없는 경우 반환값

        if(db_id != null){
            re=1;   // 중복 아이디가 있는 경우
        }
        out.println(re);    //값 반환

        return null;
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

    @PostMapping("/member/findID")
    public ModelAndView memberFindIdList(String email){

        ModelAndView mv = new ModelAndView("/member/findIdList");
        List<MemberVO> memberList =  memberService.findIdList(email);
        mv.addObject("memberList", memberList);
        return mv;
    }


    @GetMapping("/member/findPW")
    public String memberFindPW(){
        return "/member/findPw";
    }
}
