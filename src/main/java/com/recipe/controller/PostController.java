package com.recipe.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.service.PostService;
import com.recipe.vo.ContentVO;
import com.recipe.vo.PostVO;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	
	
	
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
	
	
	@RequestMapping(value="/form")
    public String form() {
        return "uploadForm";
    }
	
	
	
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
	@RequestMapping("recipe_post_ok")
	public ModelAndView recipe_post_ok(PostVO pv,ContentVO cv,HttpServletResponse response)throws Exception{
		this.postService.insertRp(pv,cv);

		
		response.setContentType("text/html;charset=UTF-8");
		ModelAndView wv2=new ModelAndView("main/index");
		
		return wv2;
		
	}
}
