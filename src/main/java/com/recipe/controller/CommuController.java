package com.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.service.CommuService;
import com.recipe.vo.CommuVO;

@Controller    

public class CommuController {
    
    // 의존관계 주입 => BoardServiceImpl 생성
    // IoC 의존관계 역전
    @Autowired
    CommuService commuService;
    
    // 01. 게시글 목록
    @RequestMapping("/commu_list")
    public ModelAndView list() throws Exception{
        List<CommuVO> list = commuService.listAll();
        // ModelAndView - 모델과 뷰
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/community/commu_list"); // 뷰를 list.jsp로 설정
        mav.addObject("commu_list", list); // 데이터를 저장
        return mav; // list.jsp로 List가 전달된다.
    }
    
    // 02_01. 게시글 작성화면
    // @RequestMapping("board/write.do")
    // value="", method="전송방식"
    @RequestMapping(value="commu_write", method=RequestMethod.GET)
    public String write(){
        return "community/commu_write"; // write.jsp로 이동
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
    @RequestMapping(value="/community/commu_cont", method =RequestMethod.GET)
    public ModelAndView view(@RequestParam int comu_no, HttpSession session) throws Exception{
        // 조회수 증가 처리     
        commuService.increaseViewcnt(comu_no,session);//번호에 해당하는 레코드를 가져오고, 그전에 조회수 증가
		
        // 모델(데이터)+뷰(화면)를 함께 전달하는 객체
        ModelAndView mav = new ModelAndView();
        // 뷰의 이름
        mav.setViewName("/community/commu_cont");
        // 뷰에 전달할 데이터
        mav.addObject("dto", commuService.read(comu_no));
        
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
    
}
