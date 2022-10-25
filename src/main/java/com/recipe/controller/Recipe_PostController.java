package com.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.service.Recipe_PostService;
import com.recipe.vo.Recipe_ContentDTO;
import com.recipe.vo.Recipe_PostDTO;

@Controller
public class Recipe_PostController {

	@Autowired
	private Recipe_PostService recipe_PostService;
	
	
	/*	
	// 다중파일 업로드
	@PostMapping("/muti-file")
	public String multFileUpload(@RequestParam("")List<MultipartFile> multiFileList,HttpServletRequest request) {


		// 경로 가져오기
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		String root= path + "/uploadFiles";
		
		File fileCheck = new File(root);
		
		if(!fileCheck.exists()) fileCheck.mkdirs();
		
		List<Map<String,String>> fileList = new ArrayList<>();
		
		for(int i=0; i<multiFileList.size(); i++) {
			String originFile=multiFileList.get(i).getOriginalFilename();
			String ext=originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString()+ext;
			
			Map<String, String> map = new HashMap<>();
			map.put("originFile",originFile);
			map.put("changeFile",changeFile);
			
			fileList.add(map);
		}
		
		// 파일 업로드
		try {
			for(int i =0; i < multiFileList.size(); i++) {
				File uploadFile = new File(root+"\\"+fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}
			System.out.println("업로드 완료!");
		}catch(IllegalStateException | IOException e) {
			System.out.println("업로드 실패");
			e.printStackTrace();
			for(int i=0; i < multiFileList.size(); i++) {
				new File(root+"\\"+fileList.get(i).get("changeFile")).delete();
			}
		}
		
		return null;
	}
*/	
	
	
	// 레시피 글쓰기
	@RequestMapping("recipe_post")
	public ModelAndView recipe_post(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		int page=1;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
			ModelAndView wv=new ModelAndView("content/recipe_post");
			wv.addObject("page",page);
			return wv;
		
	}
	
	
	// 레시피 등록완료
	@PostMapping("recipe_post_ok")
	public ModelAndView recipe_post_ok(@RequestParam("")List<MultipartFile> multiFileList,Recipe_PostDTO rpd,Recipe_ContentDTO rcd,
								HttpSession session,HttpServletResponse response,HttpServletRequest request)throws Exception{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		
		
		// 경로 가져오기
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		String root= path + "/uploadFiles";
				
		File fileCheck = new File(root);
				
		if(!fileCheck.exists()) fileCheck.mkdirs();
				
		List<Map<String,String>> fileList = new ArrayList<>();
				
		for(int i=0; i<multiFileList.size(); i++) {
			String originFile=multiFileList.get(i).getOriginalFilename();
			String ext=originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString()+ext;
					
			Map<String, String> map = new HashMap<>();
			map.put("originFile",originFile);
			map.put("changeFile",changeFile);
			
			fileList.add(map);
		}
				
		// 파일 업로드
		try {
			for(int i =0; i < multiFileList.size(); i++) {
				File uploadFile = new File(root+"\\"+fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}
			out.println("게시글 등록 완료!");
			
		}catch(IllegalStateException | IOException e) {
			out.println("게시글 등록 실패.");
			e.printStackTrace();
			for(int i=0; i < multiFileList.size(); i++) {
				new File(root+"\\"+fileList.get(i).get("changeFile")).delete();
			}
		}
				
			this.recipe_PostService.insertRp(rpd);
			
			ModelAndView wv2=new ModelAndView("main/index");
			return wv2;
		
		
	}
}
