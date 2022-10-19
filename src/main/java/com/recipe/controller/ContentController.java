package com.recipe.controller;

import com.recipe.service.ContentService;
import com.recipe.service.PostService;
import com.recipe.service.ReplyService;
import com.recipe.vo.ContentVO;
import com.recipe.vo.PostVO;
import com.recipe.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private ContentService contentService;
    @Autowired
    private PostService postService;

    @RequestMapping("/content")
    public String content(Model m, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        int post_no = 1;
        List<ContentVO> clist = contentService.getContentList(post_no);
        PostVO postVO = postService.getPost(post_no);
        List<ReplyVO> rlist = replyService.getReplyList(post_no);
        List<String> tagList = new ArrayList<>(); //태그 리스트
        List<String> ingredient_names = new ArrayList<>(); // 재료 이름 리스트
        List<String> ingredient_amounts = new ArrayList<>(); // 재료 양 리스트

        // 태그 나눠서 저장
        String tags = postVO.getPost_tag();
        String[] tagArray = tags.split(",");
        for (String tag : tagArray){
            tagList.add(tag);
        }

        // 재료 나눠서 저장 (이름, 양)
        String ingredientsBefore = postVO.getIngredient();
        String[] ingArray = ingredientsBefore.split(",");
        String ingredientsAfter = "";
        for(String ingredient : ingArray){
            ingredientsAfter += ingredient;
        }
        String[] ingredientArray = ingredientsAfter.split("!");
        for (int i = 0; i < ingredientArray.length; i++) {
            if(i / 2 == 0){
                ingredient_names.add(ingredientArray[i]);
            }else{
                ingredient_amounts.add(ingredientArray[i]);
            }
        }

        // \n -> </br>
        for(ContentVO c : clist){
            c.setManual(c.getManual().replace("\n", "</br>"));
        }
        for(ReplyVO r : rlist){
            r.setContent(r.getContent().replace("\n", "</br>"));
        }

        m.addAttribute("clist", clist);
        m.addAttribute("p", postVO);
        m.addAttribute("rlist", rlist);
        m.addAttribute("tagList", tagList);
        m.addAttribute("ingredient_names", ingredient_names);
        m.addAttribute("ingredient_amounts", ingredient_amounts);

        return "/content/content";
    }

    @RequestMapping("/addreply")
    public ModelAndView addreply(HttpServletResponse response, int post_no, String reviewer, ReplyVO r) throws Exception{

        ModelAndView cm = new ModelAndView();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        r.setPost_no(post_no);
        r.setReviewer(reviewer);

        replyService.insertReply(r);

        cm.setViewName("/content/content");

        return cm;
        //return "redirect:/content/content?post_no="+post_no;
    }

}
