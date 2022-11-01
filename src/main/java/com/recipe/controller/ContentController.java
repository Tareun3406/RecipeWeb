package com.recipe.controller;

import com.recipe.service.PostService;
import com.recipe.service.ReplyService;
import com.recipe.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContentController { // 신고, 구독, 즐겨찾기 아작스


    @Autowired
    private ReplyService replyService;

    @Autowired
    private PostService postService;


    // 본문 페이지
    @RequestMapping("/content")
    public String content(Model m, Principal principal) {

        // 받아올 정보
        int post_no = 1;

        ReplyVO replyVO = new ReplyVO();
        List<PostVO> plist = postService.getPost(post_no); // 본문내용, 작성자, 레시피
        List<ReplyVO> rlist = replyService.getReply(post_no); // 댓글, 댓글 작성자
        List<String> tagList = new ArrayList<>(); //태그 리스트
        List<String> ingredient_names = new ArrayList<>(); // 재료 이름 리스트
        List<String> ingredient_amounts = new ArrayList<>(); // 재료 양 리스트
        List<SubscribeVO> subscriberList = postService.getSubscriberList(plist.get(0).getMember().get(0).getUserid()); // 구독자 리스트
        List<BookmarkVO> bookmarkList = postService.getBookmarkList(post_no); // 즐겨찾기 아이디 리스트
        List<ReportVO> reportList = postService.getReportList(post_no); // 신고자 리스트
        String userid = null; // 로그인한 유저 아이디
        int report_state = 0; // 신고 여부
        int subscribe_state = 0; // 글쓴이 구독 여부
        int bookmark_state = 0; // 즐겨찾기 상태
        int reply_state = 0; // 리뷰 중복 등록 방지용
        int replyCount = 0; // 댓글 개수
        int total = 0; // 별점 총점
        float averageScore; // 평균 별점

        // 로그인한 아이디 가져오기
        try{
            if (principal.getName() != null) {
                userid = principal.getName();
            }
        }catch (Exception e){
            userid = "notlogin";
            e.printStackTrace();
        }

        // 리뷰 중복 등록 방지용
        replyVO.setPost_no(post_no);
        replyVO.setReviewer(userid);
        reply_state = replyService.getReplyState(replyVO);

        // 즐겨찾기 상태 표시 (1일때 즐겨찾기 상태)
        for(BookmarkVO bookmark : bookmarkList){
            if(bookmark.getUserid().equals(userid)){
                bookmark_state = 1;
            }
        }
        for(ReportVO reportVO : reportList){
            if(reportVO.getUserid().equals(userid)){
                report_state = 1;
            }
        }
        for(SubscribeVO subscribeVO: subscriberList){
            if(subscribeVO.getSubscriber_id().equals(userid)){
                subscribe_state = 1;
            }
        }


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

        // 리뷰 개수 구하기, 평점 구하기
        for(ReplyVO r : rlist) {
            replyCount += 1; // 리뷰 개수
            total += r.getScore();
        }
        averageScore = (float)total / replyCount;

        m.addAttribute("userid", userid);
        m.addAttribute("report_state", report_state);
        m.addAttribute("subscribe_state", subscribe_state);
        m.addAttribute("bookmark_state", bookmark_state);
        m.addAttribute("plist", plist);
        m.addAttribute("tagList", tagList);
        m.addAttribute("ingredient_names", ingredient_names);
        m.addAttribute("ingredient_amounts", ingredient_amounts);
        m.addAttribute("rlist", rlist);
        m.addAttribute("replyCount", replyCount);
        m.addAttribute("averageScore", averageScore);
        m.addAttribute("reply_state", reply_state);

        return "/content/content";

    }

    // 리뷰 저장
    @RequestMapping("/insert_reply")
    public ModelAndView insert_reply(HttpServletResponse response, ReplyVO r) throws IOException {

        ModelAndView cm = new ModelAndView();
        PrintWriter out = response.getWriter();

        replyService.insertReply(r);

        out.println("<script>");
        out.println("alert('등록 완료');");
        out.println("</script>");

        cm.setViewName("redirect:/content");

        return cm;

    }

    // 리뷰 수정
    @RequestMapping("/edit_reply")
    public String edit_reply(HttpServletResponse response, ReplyVO replyVO){

        response.setContentType("text/html;charset=UTF-8");

        //replyService.editReply(replyVO);

        return null;

    }

    // 리뷰 삭제
    @RequestMapping("/del_reply")
    public String del_reply(ReplyVO replyVO){

        replyService.deleteReply(replyVO);

        return "redirect:/content";

    }

    // 구독 추가
    @RequestMapping("/insert_subscribe")
    public String update_subscribe(SubscribeVO subscribeVO){

        postService.insertSubscribe(subscribeVO);

        return "redirect:/content";

    }

    // 구독 삭제
    @RequestMapping("/del_subscribe")
    public String check_subscribe(SubscribeVO subscribeVO){

        postService.deleteSubscribe(subscribeVO);

        return "redirect:/content";

    }

    // 즐겨찾기 추가
    @RequestMapping("/insert_bookmark")
    public String update_bookmark(BookmarkVO bookmarkVO){

        postService.insertBookmark(bookmarkVO);

        return "redirect:/content";

    }

    // 즐겨찾기 삭제
    @RequestMapping("/del_bookmark")
    public String check_bookmark(BookmarkVO bookmarkVO){

        postService.deleteBookmark(bookmarkVO);

        return "redirect:/content";

    }

    // 신고 추가
    @RequestMapping("/insert_report")
    public String update_report(ReportVO reportVO){

        postService.insertReport(reportVO);

        return "redirect:/content";

    }

    // 신고 삭제
    @RequestMapping("/del_report")
    public String check_report(ReportVO reportVO){

        postService.deleteReport(reportVO);

        return "redirect:/content";

    }

}
