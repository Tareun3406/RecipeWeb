package com.recipe.controller;

import com.recipe.service.MypageService;
import com.recipe.vo.mypageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MypageController {

    @Autowired //자동의존성 주입(DI)
    private MypageService mypageService;


    @RequestMapping("/mypage") //마이페이지 본문
    public ModelAndView mypage(){

        String v2 = "id2"; //나중에 세션id추가되면 삭제될것 아래 v2까지
        mypageVO v=this.mypageService.getuser(v2);

        ModelAndView mv=new ModelAndView();

        mv.addObject("id",v.getId());
        mv.addObject("pw",v.getPw());
        mv.addObject("name",v.getName());
        mv.addObject("subscript",v.getSubscript());
        mv.addObject("bookmark",v.getBookmark());

        mv.setViewName("mypage/mypage");

        return mv;
    }
}


