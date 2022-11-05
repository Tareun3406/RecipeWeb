package com.recipe.controller;

import com.recipe.service.MypageService;
import com.recipe.vo.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MypageController {

    @Autowired //자동의존성 주입(DI)
    private MypageService mypageService;


    @RequestMapping("/mypage") //마이페이지 본문
    public String mypage(Model mylistm,Authentication authentication ){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();//시큐리티 인증로그인 할때 저장된 유저이름 가져오기
        String b=userDetails.getUsername();//가져온 이름 b객체에 저장

        MemberDTO pvo = mypageService.getmylist(b); //저장된 b로 내정보 가져오기

        mylistm.addAttribute("userlist",pvo);

        return "mypage/mypage";
    }


}


