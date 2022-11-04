package com.recipe.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.service.PostService;
import com.recipe.vo.ContentVO;
import com.recipe.vo.PostVO;

@Controller
public class Recipe_PostController {

	@Autowired
	private PostService postService;
	
	
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
	public ModelAndView recipe_post_ok(String fileContent,PostVO pv,ContentVO cv,HttpSession session,HttpServletResponse response,HttpServletRequest request)
			throws Exception{
		
	
		response.setContentType("text/html;charset=UTF-8");
		
			
			// 받아온것 출력 확인
//			System.out.println("multiFileList : " + multiFileList);
			System.out.println("fileContent : " + fileContent);
			
			// path 가져오기
			String path = request.getSession().getServletContext().getRealPath("resources");
			String root = path + "\\" + "uploadFiles";
			
			File fileCheck = new File(root);
			
			if(!fileCheck.exists()) fileCheck.mkdirs();
			
			
			List<Map<String, String>> fileList = new ArrayList<>();
			
//			for(int i = 0; i < multiFileList.size(); i++) {
//				String originFile = multiFileList.get(i).getOriginalFilename();
//				String ext = originFile.substring(originFile.lastIndexOf("."));
//				String changeFile = UUID.randomUUID().toString() + ext;
				
				
				Map<String, String> map = new HashMap<>();
//				map.put("originFile", originFile);
//				map.put("changeFile", changeFile);
				
				fileList.add(map);
//			}
			
			
			// System.out.println(fileList);
			
			// 파일업로드
//			try {
//				for(int i = 0; i < multiFileList.size(); i++) {
//					File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
//					multiFileList.get(i).transferTo(uploadFile);
//				}
//				
//				System.out.println("다중 파일 업로드 성공!");
//				
//			} catch (IllegalStateException | IOException e) {
//				System.out.println("다중 파일 업로드 실패 ㅠㅠ");
//				// 만약 업로드 실패하면 파일 삭제
//				for(int i = 0; i < multiFileList.size(); i++) {
//					new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
//				}
				
				
//				e.printStackTrace();
//			}
		ModelAndView wv2=new ModelAndView("content/index");
		return wv2;
		}
		
		
}
		
		
	

