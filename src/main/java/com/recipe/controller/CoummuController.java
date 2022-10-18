package com.recipe.controller;


import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recipe.service.CommuService;
import com.recipe.vo.CommuVO;

@Controller
public class CoummuController {
	
	@Autowired
	private CommuService commuService;
	
	
	//자료실 글쓰기 폼
	@RequestMapping("/commu_write")
	public ModelAndView commu_write(HttpServletResponse response,HttpSession session
			,HttpServletRequest request) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String id = (String)session.getAttribute("id");//관리자 세션 아이디를 구함
		/*if(id == null) {
			out.print("<script>");
			out.print("alert('로그인 하세요!');");
			out.print("location='loginForm';");
			out.print("</script>");
		}else {} */
			int page=1;
			if(request.getParameter("page")!= null) {
				page = Integer.parseInt(request.getParameter("page"));//get으로 전달된 쪽번호를
				//받아서 정수 숫자로 변경
			}
			ModelAndView wm = new ModelAndView("./community/commu_write");
			wm.addObject("page",page);
			return wm;
		
		//return null;
	}//자료실 글쓰기 폼=>commu_write()메서드
	
		
		//자료실 저장
		@RequestMapping(value="/commu_write_ok",method=RequestMethod.POST)
		//POST방식으로 접근하는 매핑주소 처리.bbs_write_ok 매핑주소 등록
		public ModelAndView commu_write_ok(CommuVO c,HttpServletRequest request,HttpServletResponse response
				,HttpSession session,RedirectAttributes rttr) 
				throws Exception {
			response.setContentType("text/html;charset=utf-8");
			/*PrintWriter out = response.getWriter();
			
			String id = (String)session.getAttribute("id");//관리자 세션 아이디를 구함
			if(id ==null) {
				out.print("<script>");
				out.print("alert('다시 로그인 하세요!');");
				out.print("location='admin_index';");
				out.print("</script>");
			}else {}*/
				this.commuService.insertCommu(c);//게시판 저장.this.은 생략가능함
				rttr.addFlashAttribute("msg","SUCCESS");//서버컨트롤로에서 다른 매핑주소로 이동시 값을 전달할 때 
				//사용한다. msg키이름에 SUCCESSS문자를 담아서 전달한다. 주소창에 노출안된다. 보안이 좋다.
				return new ModelAndView("redirect:/community/commu_list");//board_list매핑주소로 이동

			
			//return null;
		}
		//commu_write_ok()
		
		
		
		//자료실 목록(페이징과 검색기능이 추가됨)
		@RequestMapping(value="/commu_list",method=RequestMethod.GET) //get으로 접근하는 매핑주소 처리
		public String commu_list(Model listM,HttpServletRequest request, CommuVO c) {
			int page=1;
		      int limit=10;//한페이지에 보여지는 목록개수
		      if(request.getParameter("page") != null) {
	        	page=Integer.parseInt(request.getParameter("page"));         
		      }
		      String find_name = request.getParameter("find_name");//검색어
		      String find_field = request.getParameter("find_field");//검색 필드
		      c.setFind_name("%"+find_name+"%");// %는 데이터 베이스에서 검색 와일드 카드 문자로서 하나이상의 
		      //임의의 모르는 문자와 매핑대응
		      c.setFind_field(find_field);
		      int totalCount=this.commuService.getListCount(c);
		      //검색 전 총레코드 개수,검색후 레코드 개수
		      
		      c.setStartrow((page-1)*10+1);//시작행번호
		       c.setEndrow(c.getStartrow()+limit-1);//끝행 번호
		      
		      List<CommuVO> clist=this.commuService.getCommuList(c);
		      //검색 전후 목록
		      
		      //총 페이지수
		      int maxpage=(int)((double)totalCount/limit+0.95);
		      //시작페이지(1,11,21 ..)
		      int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		      //현재 페이지에 보여질 마지막 페이지(10,20 ..)
		      int endpage=maxpage;
		      if(endpage>startpage+10-1) endpage=startpage+10-1;
		      
		      listM.addAttribute("clist",clist);
		      listM.addAttribute("page",page);
		      listM.addAttribute("startpage",startpage);
		      listM.addAttribute("endpage",endpage);
		      listM.addAttribute("maxpage",maxpage);
		      listM.addAttribute("listcount",totalCount);
		      listM.addAttribute("find_field",find_field);//검색 필드
		      listM.addAttribute("find_name",find_name);//검색어
		      
		   
		      return "community/commu_list";//뷰페이지 경로가/WEB-INF/views/bbs/bbs_list.jsp
		}//commu_list()
		
		//내용보기+답변폼+수정폼+삭제폼
		@RequestMapping("/commu_cont")
		public ModelAndView commu_cont(@RequestParam("comu_no")int comu_no, int page,
				String state,CommuVO c) {
			//@RequestParam("bbs_no")은 서블릿의 request.getParameter("bbs_no")와 같다
			//int page,String state만 사용해서 각각 피라미터 값을 받을수 있다.
			
			if(state.equals("cont")) {//내용보기일때만 조회수 증가
				c=this.commuService.getCommuCont(comu_no);
			}else {//답변폼,수정폼,삭제폼일때 실행->조회수 증가 안함
				c=this.commuService.getCommuCont2(comu_no);
			}
			
			String content=c.getContent().replace("\n", "<br/>");//textarea 글내용 입력박스에서 
			//엔터키 친부분을 다음줄로 줄바꿈(<br/>)
			
			ModelAndView cm = new ModelAndView();
			cm.addObject("c",c);
			cm.addObject("content", content);
			cm.addObject("page", page);
			
			if(state.equals("cont")) {//내용보기 일때
				cm.setViewName("community/commu_cont");// /WEB-INF/views/bbs/bbs_cont.jsp
			}else if(state.equals("reply")) {//답변폼
				cm.setViewName("community/commu_reply");
			}else if(state.equals("edit")) {//수정폼
				cm.setViewName("community/commu_edit");
			}else if(state.equals("del")) {//삭제폼
				cm.setViewName("community/commu_del");
			}
			return cm;
		}//bbs_cont()
}		