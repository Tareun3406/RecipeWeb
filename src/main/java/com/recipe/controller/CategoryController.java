package com.recipe.controller;

import com.recipe.service.CategoryService;
import com.recipe.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class CategoryController {

    @Autowired //자동의존성 주입(DI)
    private CategoryService categoryService;

    @RequestMapping("/category") //카테고리 메뉴
    public String category_list(HttpServletRequest request, CategoryVO b, Model listM) {

        int page=1;
        int limit=10;//한페이지에 보여지는 목록개수
        if(request.getParameter("page") != null) {
            page=Integer.parseInt(request.getParameter("page"));
        }
        String find_name = request.getParameter("find_name");//검색어
        String find_field = request.getParameter("find_field");//검색필드
        b.setFind_name("%"+find_name+"%"); //%는 데이터베이스에서 검색 와일드카드문자로서
        //하나이상의 임의의 모르는 문자와 매핑대응
        b.setFind_field(find_field);

        int totalCount=this.categoryService.getListCount(b);
        //총레코드 개수,검색후 레코드 개수,

        b.setStartrow((page-1)*10+1);//시작행번호
        b.setEndrow(b.getStartrow()+limit-1);//끝행 번호

        List<CategoryVO> blist=this.categoryService.getcategoryList(b);
        //검색 전후 목록

        //총 페이지수
        int maxpage=(int)((double)totalCount/limit+0.95);
        //시작페이지(1,11,21 ..)
        int startpage=(((int)((double)page/10+0.9))-1)*10+1;
        //현재 페이지에 보여질 마지막 페이지(10,20 ..)
        int endpage=maxpage;
        if(endpage>startpage+10-1) endpage=startpage+10-1;

        listM.addAttribute("blist",blist);
        listM.addAttribute("page",page);
        listM.addAttribute("startpage",startpage);
        listM.addAttribute("endpage",endpage);
        listM.addAttribute("maxpage",maxpage);
        listM.addAttribute("listcount",totalCount);
        listM.addAttribute("find_field",find_field);
        listM.addAttribute("find_name",find_name);

        return "category/category";
    }


    @RequestMapping("/ranking")
    public  String ranking(){ return "category/ranking";}



}
