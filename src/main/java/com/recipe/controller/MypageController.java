package com.recipe.controller;

import com.recipe.service.AdminService;
import com.recipe.service.MypageService;
import com.recipe.vo.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class MypageController {

    @Autowired //자동의존성 주입(DI)
    private MypageService mypageService;
    @Autowired
    private AdminService adminService;


    @RequestMapping("/mypage") //마이페이지 본문
    public String mypage(Model mylistm,Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();//시큐리티 인증로그인 할때 저장된 유저이름 가져오기
        String b=userDetails.getUsername();//가져온 이름 b객체에 저장

        MemberDTO pvo = mypageService.getmylist(b); //저장된 b로 내정보 가져오기

        mylistm.addAttribute("userlist",pvo);

        return "mypage/mypage";
    }


    // 회원정보 수정 뷰
    @PostMapping("mem/edit")
    public ModelAndView adminMemberEdit(String userid){
        ModelAndView mv = new ModelAndView("/mypage/memEdit");


        MemberDTO member =  adminService.getMemberInfo(userid);
        mv.addObject("member",member);

        return mv;
    }

    // 회원정보 수정 업데이트
    @PostMapping("mem/editUpdate")
    public String adminMemberEditUpdate(MemberDTO member){
        adminService.memberUpdate(member);

        return "redirect:/mypage";
        //return adminMemberEdit(member.getUserid());
    }

    @PostMapping("mem/delete")
    public String modelAndView(String userid, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out =  response.getWriter();
        adminService.deleteMember(userid);

        out.println("<script>");
        out.println("alert('삭제되었습니다.');");
        out.println("location='/admin/member';");
        out.println("</script>");

        return null;
    }
}


