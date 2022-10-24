package com.recipe.controller;

import com.recipe.service.MypageService;
import com.recipe.vo.MypageVO;
import com.recipe.vo.SubscribeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MypageController {

    @Autowired //자동의존성 주입(DI)
    private MypageService mypageService;


    @RequestMapping("/mypage") //마이페이지 본문
    public String mypage(Model mylistm){

        //String v2 = "userid01"; //나중에 세션id추가되면 삭제될것 아래 v2까지
        String b = "userid01"; //나중에 세션id추가되면 삭제될것 아래 v2까지
        /*
        MypageVO vo=(MypageVO)session.getAttribute("id")//로그인세션
         */
        MypageVO pvo = mypageService.getmylist(b);

        mylistm.addAttribute("userlist",pvo);

        return "mypage/mypage";
    }


}


