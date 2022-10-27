package com.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @RequestMapping("")
    public String adminMain(){
        return "/admin/main";
    }

    @RequestMapping("recipe")
    public String adminRecipe(){ return "/admin/recipe";}

    @RequestMapping("community")
    public String adminCommunity(){ return "/admin/community"; }

    @RequestMapping("member")
    public String adminMember(){ return "/admin/member"; }
}
