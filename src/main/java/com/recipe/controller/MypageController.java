package com.recipe.controller;

import com.recipe.security.MemberDetailsService;
import com.recipe.security.domain.MemberUser;
import com.recipe.service.MypageService;
import com.recipe.vo.MemberVO;
import com.recipe.vo.MypageVO;
import com.recipe.vo.SubscribeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.security.Principal;
import java.security.acl.AclEntry;
import java.util.List;

import static java.lang.System.out;

@Controller
public class MypageController {

    @Autowired //자동의존성 주입(DI)
    private MypageService mypageService;


    @RequestMapping("/mypage") //마이페이지 본문
    public String mypage(Model mylistm,Authentication authentication ){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //시큐리티 인증로그인 할때 저장된 유저이름 가져오기
        String b=userDetails.getUsername();
        out.println("마이페이지 간다"+b);
        MemberVO pvo = mypageService.getmylist(b);

        mylistm.addAttribute("userlist",pvo);

        return "mypage/mypage";
    }


}


