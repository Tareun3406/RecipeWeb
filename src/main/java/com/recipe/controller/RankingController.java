package com.recipe.controller;

import com.recipe.service.RankingService;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.RankingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RankingController {

    @Autowired //자동의존성 주입(DI)
    private RankingService rankingService;

    @RequestMapping("/ranking")
    public String ranking(HttpServletRequest request, RankingVO r, Model model){


        String find_date=request.getParameter("find_date");

        if(find_date==null){
            find_date="";
        }
        r.setFind_date(find_date);

        int page=1;
        int limit=12;//한페이지에 보여지는 목록개수
        if(request.getParameter("page") != null) {
            page=Integer.parseInt(request.getParameter("page"));
        }

        String find_name = request.getParameter("find_name");//검색어

        if(find_name == null) {
            find_name="";
        }
        if(find_name.equals("레시피랭킹")){
            find_name="레시피랭킹";
        }
        if(find_name.equals("쉐프랭킹")){
            find_name="쉐프랭킹";
        }
        //find_name에 빈값이 아닌 null이 들어왔을때 공백으로 만들어준다.

        r.setFind_name(find_name);
        //하나이상의 임의의 모르는 문자와 매핑대응
        System.out.println(find_name);
        System.out.println(r.getFind_name());
        int totalCount=this.rankingService.getListCount(r);
        //총레코드 개수,검색후 레코드 개수,

        r.setStartrow((page-1)*12+1);//시작행번호
        r.setEndrow(r.getStartrow()+limit-1);//끝행 번호

        List<RankingVO> rlist=this.rankingService.getrankList(r);//검색 전후 목록

        int maxpage=(int)((double)totalCount/limit+0.95);//총 페이지수
        int startpage=(((int)((double)page/10+0.9))-1)*10+1;//시작페이지(1,11,21 ..)
        int endpage=maxpage; //현재 페이지에 보여질 마지막 페이지(10,20 ..)
        if(endpage>startpage+10-1) endpage=startpage+10-1;

        model.addAttribute("rlist",rlist); //작성글 리스트
        model.addAttribute("startrow",r.getStartrow());
        model.addAttribute("endrow",r.getEndrow());
        model.addAttribute("page",page);
        model.addAttribute("startpage",startpage);
        model.addAttribute("endpage",endpage);
        model.addAttribute("maxpage",maxpage);
        model.addAttribute("listcount",totalCount);
        model.addAttribute("find_name",find_name);
        model.addAttribute("find_date",find_date);

        return "category/ranking";
    }

}
