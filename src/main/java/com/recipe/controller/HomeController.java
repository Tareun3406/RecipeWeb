package com.recipe.controller;

import com.recipe.service.HomeService;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/")
    public ModelAndView home(){

        ModelAndView mv = new ModelAndView("main/index");
        List<CategoryVO> rankedRecipeList = homeService.getRecipeRankedList();
        List<CategoryVO> bookmarkRecipeList = homeService.getBookmarkRecipeList();
        List<CategoryVO> recentRecipeList = homeService.getRecentRecipeList();
        List<CommuVO> recentCommuList = homeService.getRecentCommuList();

        mv.addObject("rankedRecipeList", rankedRecipeList);
        mv.addObject("bookmarkRecipeList", bookmarkRecipeList);
        mv.addObject("recentRecipeList", recentRecipeList);
        mv.addObject("recentCommuList",recentCommuList);

        return mv;
    }

    @GetMapping("/header")
    public ModelAndView mainHeader(){
        ModelAndView mv = new ModelAndView("/main/header");

        String[] keywordArr = {"중식","일식","한식","양식","디저트"};
        List<MemberDTO> chefList = homeService.getChefRankedList();

        // 랜덤 인덱스로 배열의 값 꺼내기
        Random random = new Random();
        int i = random.nextInt(keywordArr.length);
        String recommendKeyword = keywordArr[i];

        // 종성 구분하여 을or를 정해주기
        char lastName = recommendKeyword.charAt(recommendKeyword.length() - 1);
        int index= (lastName - 0xAC00) % 28;
        String lastChar;
        if (index==0) lastChar="를";
        else lastChar = "을";

        mv.addObject("chefList", chefList);
        mv.addObject("recommendKeyword",recommendKeyword);
        mv.addObject("lastChar", lastChar);
        return mv;
    }
}
