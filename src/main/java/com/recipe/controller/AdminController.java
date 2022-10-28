package com.recipe.controller;

import com.recipe.service.AdminService;
import com.recipe.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("")
    public String adminMain(){
        return "/admin/main";
    }

    @RequestMapping("recipe")
    public String adminRecipe(){ return "/admin/recipe";}

    @RequestMapping("community")
    public String adminCommunity(){ return "/admin/community"; }

    @RequestMapping("member")
    public ModelAndView adminMember(){
        ModelAndView mv =new ModelAndView("/admin/member");

        List<MemberDTO> memberList = adminService.getMemberList();
        mv.addObject("memberList",memberList);

        return mv;
    }
}
