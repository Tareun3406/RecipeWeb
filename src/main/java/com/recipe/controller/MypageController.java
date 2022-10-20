package com.recipe.controller;

import com.recipe.service.MypageService;
import com.recipe.vo.mypageVO;
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
        //mypageVO v=this.mypageService.getuser(v2);

        List<mypageVO> mylist=this.mypageService.getmylist(b);

        mylistm.addAttribute("mylist",mylist);
        /*
        ModelAndView mv=new ModelAndView();

        //멤버테이블
        mv.addObject("userid",v.getUserid());
        mv.addObject("userpw",v.getUserpw());
        mv.addObject("nickname",v.getNickname());
        //구독테이블
        mv.addObject("subscriber_id",v.getSubscriber_id());
        mv.addObject("target_id",v.getTarget_id());

        mv.setViewName("mypage/mypage");
        */
        return "mypage/mypage";
    }
}


