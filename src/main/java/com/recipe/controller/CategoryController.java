package com.recipe.controller;

import com.recipe.service.CategoryService;
import com.recipe.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.lang.System.out;


@Controller
public class CategoryController {

    @Autowired //자동의존성 주입(DI)
    private CategoryService categoryService;

    @RequestMapping("/category") //카테고리 메뉴
    public String category_list(HttpServletRequest request, CategoryVO recipe, Model listM){

        int page=1;
        int limit=12;//한페이지에 보여지는 목록개수
        if(request.getParameter("page") != null) {
            page=Integer.parseInt(request.getParameter("page"));
        }

         String find_name = request.getParameter("find_name");//검색어

        if(find_name == null){
            find_name="";
        } //find_name에 빈값이 아닌 null이 들어왔을때 공백으로 만들어준다.

        recipe.setFind_name("%"+find_name+"%"); //%는 데이터베이스에서 검색 와일드카드문자로서 하나이상의 임의의 모르는 문자와 매핑대응


        int totalCount=this.categoryService.getListCount(recipe);//총레코드 개수,검색후 레코드 개수,


        recipe.setStartrow((page-1)*12+1);//시작행번호
        recipe.setEndrow(recipe.getStartrow()+limit-1);//끝행 번호

        int maxpage=(int)((double)totalCount/limit+0.95);//총 페이지수
        int startpage=(((int)((double)page/10+0.9))-1)*10+1;//시작페이지(1,11,21 ..)
        int endpage=maxpage; //현재 페이지에 보여질 마지막 페이지(10,20 ..)
        if(endpage>startpage+10-1) endpage=startpage+10-1;

        List<CategoryVO> blist = this.categoryService.getcategoryList(recipe);//검색 전후 목록


        listM.addAttribute("blist",blist); //작성글 리스트
        listM.addAttribute("startrow",recipe.getStartrow());
        listM.addAttribute("endrow",recipe.getEndrow());
        listM.addAttribute("page",page);
        listM.addAttribute("startpage",startpage);
        listM.addAttribute("endpage",endpage);
        listM.addAttribute("maxpage",maxpage);
        listM.addAttribute("listcount",totalCount);
        listM.addAttribute("find_name",find_name);

        return "category/category";
    }

}
