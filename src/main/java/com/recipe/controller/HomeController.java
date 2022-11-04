package com.recipe.controller;

import com.recipe.service.HomeService;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
}
