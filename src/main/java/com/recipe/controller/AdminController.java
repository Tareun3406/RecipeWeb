package com.recipe.controller;

import com.recipe.service.AdminService;
import com.recipe.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 어드민 홈 뷰
    @RequestMapping("")
    public String adminMain(){
        return "/admin/main";
    }

    // 레시피 글 리스트 뷰
    @RequestMapping("recipe")
    public String adminRecipe(){ return "/admin/recipe";}

    // 커뮤니티 글 리스트 뷰
    @RequestMapping("community")
    public String adminCommunity(){ return "/admin/community"; }

    // 회원정보 리스트 뷰
    @RequestMapping("member")
    public ModelAndView adminMember(String page){
        ModelAndView mv =new ModelAndView("/admin/member");
        final int listNum = 20;      // 페이지당 표시할 레코드 개수
        int totalPage = 0;
        if (page == null) page = "1";

        List<MemberDTO> memberList = adminService.getMemberList(page, listNum);
        totalPage = adminService.getMemberListCount(listNum);
        mv.addObject("memberList",memberList);
        mv.addObject("totalPage",totalPage);
        mv.addObject("page", page);
        return mv;
    }

    // 회원정보 수정 뷰
    @PostMapping("member/edit")
    public ModelAndView adminMemberEdit(String userid){
        ModelAndView mv = new ModelAndView("/admin/memberEdit");

        MemberDTO member =  adminService.getMemberInfo(userid);
        mv.addObject("member",member);

        return mv;
    }

    // 회원정보 수정 업데이트
    @PostMapping("member/editUpdate")
    public ModelAndView adminMemberEditUpdate(MemberDTO member){
        adminService.memberUpdate(member);

        return adminMemberEdit(member.getUserid());
    }
}
