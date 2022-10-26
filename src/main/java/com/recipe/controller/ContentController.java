package com.recipe.controller;

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
    private PostService postService;

    @RequestMapping("/content")
    public String content(Model m, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        int post_no = 1;
        List<PostVO> plist = postService.getPost(post_no); // 본문내용, 작성자, 레시피
        List<ReplyVO> rlist = replyService.getReply(post_no); // 댓글, 댓글 작성자
        List<String> tagList = new ArrayList<>(); //태그 리스트
        List<String> ingredient_names = new ArrayList<>(); // 재료 이름 리스트
        List<String> ingredient_amounts = new ArrayList<>(); // 재료 양 리스트
        int replyCount = 0; // 댓글 개수
        int total = 0; // 별점 총점
        float averageScore; // 평균 별점

        // 태그 문자열 나눠서 저장
        String tags = plist.get(0).getPost_tag();
        String[] tagArray = tags.split(",");
        for (String tag : tagArray){
            tagList.add(tag);
        }

        // 재료 문자열 나눠서 저장 (이름, 양)
        String ingredientList = plist.get(0).getIngredient();
        String[] ingArray = ingredientList.split(",");
        for (int i = 0; i < ingArray.length; i++) {
            String a1 = ingArray[i].split("!")[0];
            String b1 = ingArray[i].split("!")[1];
            ingredient_names.add(a1);
            ingredient_amounts.add(b1);
        }

        // 줄 바꾸기 (\n -> </br>)
        for (ContentVO c : plist.get(0).getContent()) {
            c.setManual(c.getManual().replace("\n", "</br>"));
        }
        for(ReplyVO r : rlist){
            r.setContent(r.getContent().replace("\n", "</br>"));
        }
        for(PostVO p : plist){
            p.setTip(p.getTip().replace("\n", "</br>"));
        }

        // 리뷰 개수 구하기, 평점 구하기
        for(ReplyVO r : rlist) {
            replyCount += 1; // 리뷰 개수
            total += r.getScore();
        }
        averageScore = (float)total / replyCount;


        m.addAttribute("plist", plist);
        m.addAttribute("tagList", tagList);
        m.addAttribute("ingredient_names", ingredient_names);
        m.addAttribute("ingredient_amounts", ingredient_amounts);
        m.addAttribute("rlist", rlist);
        m.addAttribute("replyCount", replyCount);
        m.addAttribute("averageScore", averageScore);

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

        cm.setViewName("");

        return cm;
        //return "redirect:/content/content?post_no="+post_no;
    }

}
