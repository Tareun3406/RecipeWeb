package com.recipe.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.service.CommuService;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;

@Controller    

public class CommuController {
    
    // 의존관계 주입 => BoardServiceImpl 생성
    // IoC 의존관계 역전
	
    @Autowired
    CommuService commuService;
    
    // 01. 게시글 목록
    @RequestMapping("/commu_list")
    public String list(Model listM,HttpServletRequest request, CommuVO vo) throws Exception{
    	 int page=1;
         int limit=10;//한페이지에 보여지는 목록개수
         if(request.getParameter("page") != null) {
           page=Integer.parseInt(request.getParameter("page"));         
         }
         String find_name = request.getParameter("find_name");//검색어
         String find_field = request.getParameter("find_field");//검색 필드
         vo.setFind_name("%"+find_name+"%");// %는 데이터 베이스에서 검색 와일드 카드 문자로서 하나이상의 
         //임의의 모르는 문자와 매핑대응
         vo.setFind_field(find_field);
         int totalCount=this.commuService.getListCount(vo);
         //검색 전 총레코드 개수,검색후 레코드 개수

         
         vo.setStartrow((page-1)*10+1);//시작행번호
         vo.setEndrow(vo.getStartrow()+limit-1);//끝행 번호
         

          
         List<CommuVO> blist=this.commuService.getComuList(vo);
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
         listM.addAttribute("find_field",find_field);//검색 필드
         listM.addAttribute("find_name",find_name);//검색어
         
      System.out.println(blist);
         return "community/commu_list";//뷰페이지 경로가/WEB-
    }
    
    // 02_01. 게시글 작성화면(로그인 해야만 작성 가능 하게 하기)
    @RequestMapping(value="commu_write", method=RequestMethod.GET)
    public String write(HttpServletResponse response,HttpServletRequest request
    		,Model model,Authentication authentication)throws Exception{
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	String c=userDetails.getUsername();
    	
    	response.setContentType("text/html;charset=UTF-8");
  
        MemberDTO vo = commuService.getmynickname(c);

        model.addAttribute("userlist",vo);

        System.out.println(vo);
        return "community/commu_write";
    }
    
    // 02_02. 게시글 작성처리
    @RequestMapping(value="commu_list", method=RequestMethod.POST)
    public String insert(@ModelAttribute CommuVO vo) throws Exception{
    	
    	commuService.create(vo);

        return "redirect:/commu_list";
    }
    
    
    // 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    // HttpSession 세션객체
    //댓글 등록화면(로그인 되어있는 유저 닉네임 가져오기)
	@RequestMapping(value="/commu_cont", method =RequestMethod.GET)
    public ModelAndView view(@RequestParam int comu_no, HttpSession session
    		,HttpServletRequest request,Authentication authentication
    		,HttpServletResponse response) throws Exception{
	    response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		session = request.getSession();
		 String loginId = (String) session.getAttribute("loginId");
		if(loginId == null) {
    		 out.println("<script>");
	         out.println("alert('로그인후 이용해 주세요!');");
	         out.println("location='loginForm';");
	         out.println("</script>");
    	}
		//로그인한 유저 닉네임 가져오기
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	System.out.println(userDetails.getUsername());

    	String c=userDetails.getUsername();

    	// 조회수 증가 처리     
    	commuService.increaseViewcnt(comu_no,session);//번호에 해당하는 레코드를 가져오고, 그전에 조회수 증가
    	
    	MemberDTO vo = commuService.getmynickname(c);
    
    	// 모델(데이터)+뷰(화면)를 함께 전달하는 객체
        ModelAndView mav = new ModelAndView();
        // 뷰의 이름
        mav.setViewName("/community/commu_cont");
        // 뷰에 전달할 데이터
        mav.addObject("dto", commuService.read(comu_no));
        mav.addObject("userlist",vo);
        
        return mav;
            	
    }
    
    //수정폼 이동
    @RequestMapping(value="/community/commu_edit", method=RequestMethod.GET)
    public ModelAndView update(@RequestParam int comu_no ) throws Exception{
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("/community/commu_edit");
    	mav.addObject("dto", commuService.read(comu_no));
 
        return mav;
    }
    
    // 04. 게시글 수정
    // 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달됨
    @RequestMapping(value="/community/commu_edit_ok", method =  RequestMethod.POST)
    public String update_ok(@ModelAttribute CommuVO vo)
    		throws Exception{
    	
        commuService.update(vo);
        
        return "redirect:/commu_list";
        
    }
    
    
    // 05. 게시글 삭제
    @RequestMapping("/community/commu_del_ok")
    public String delete(@RequestParam int comu_no) throws Exception{
    	
        commuService.delete(comu_no);
        return "redirect:/commu_list";
    }
    
   
    //로그인 화면
    @RequestMapping("loginForm")
    public String login() {
    	return "member/loginForm";
    }
    
    
    
}





