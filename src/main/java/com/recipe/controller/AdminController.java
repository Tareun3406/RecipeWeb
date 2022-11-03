package com.recipe.controller;

import com.recipe.service.AdminService;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    public ModelAndView adminRecipe(String page, String search){
        ModelAndView mv = new ModelAndView("/admin/recipe");
        final int listNum = 10;      // 페이지당 표시할 레코드 개수
        int totalPage;           // 전체 페이지수
        if (page == null) page = "1";   // 현재페이지 값 없을경우 1 입력.
        if (search == null) search = "";

        List<CategoryVO> recipeList = adminService.getRecipeList(page, search, listNum);
        totalPage = adminService.readRecipeListCount(search, listNum);


        mv.addObject("totalPage", totalPage);
        mv.addObject("page",page);
        mv.addObject("search",search);
        mv.addObject("recipeList",recipeList);

        return mv;
    }

    // 커뮤니티 글 리스트 뷰
    @RequestMapping("community")
    public ModelAndView adminCommunity(String page, String search){
        ModelAndView mv = new ModelAndView("/admin/community");
        final int listNum = 10;      // 페이지당 표시할 레코드 개수
        int totalPage;           // 전체 페이지수
        if (page == null) page = "1";   // 현재페이지 값 없을경우 1 입력.
        if (search == null) search = "";

        List<CommuVO> commuList = adminService.getCommuList(page,search, listNum);    // 게시글 목록 가져오기
        totalPage = adminService.getComuListCount(search, listNum);


        mv.addObject("totalPage", totalPage);
        mv.addObject("page",page);
        mv.addObject("search",search);
        mv.addObject("commuList",commuList);

        return mv;
    }

    // 회원정보 리스트 뷰
    @RequestMapping("member")
    public ModelAndView adminMember(String search, String page){
        ModelAndView mv =new ModelAndView("/admin/member");
        final int listNum = 20;      // 페이지당 표시할 레코드 개수
        int totalPage;           // 전체 페이지수
        if (page == null) page = "1";   // 현재페이지 값 없을경우 1 입력.
        if (search == null) search = "";

        List<MemberDTO> memberList = adminService.getMemberList(search, page, listNum); // 회원 목록 검색
        totalPage = adminService.getMemberListCount(search ,listNum);   // 총 페이지 수

        mv.addObject("memberList",memberList);  // 회원 목록
        mv.addObject("totalPage",totalPage);    // 총 페이지 수
        mv.addObject("page", page); // 현제 페이지
        mv.addObject("search",search);  // 검색어
        return mv;
    }

    //회원정보 삭제
    @PostMapping("member/delete")
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
