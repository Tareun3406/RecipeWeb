package com.recipe.controller;

import com.oreilly.servlet.MultipartRequest;
import com.recipe.service.TestService;
import com.recipe.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.Principal;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request){
        return "/content/test";
    }

    @RequestMapping("/uploadOK")
    public String uploadOk(HttpServletRequest request, TestVO testVO) throws Exception {

        int post_no = testService.getPostNo(); // 시퀀스 다음 번호값 가져오기
        testVO.setPost_no(post_no);
        System.out.println(post_no);
        String saveFolder=request.getSession().getServletContext().getRealPath("/resources/upload");
            // 주소 --> RecipeWeb/target/controller-1.0.0-BUILD-SNAPSHOT/resources/upload
        int fileSize=5*1024*1024;//이진파일 업로드 최대크기
        MultipartRequest multi=new MultipartRequest(request, saveFolder,  fileSize,"UTF-8");

        File UpFile=multi.getFile("thumbnail");//첨부한 이진파일을 받아옴.


        String fileName=UpFile.getName();//첨부한 파일명

        String homedir=saveFolder+"/"+post_no;// 번호값으로 폴더 경로 저장
        File path1=new File(homedir);

        if(!(path1.exists())) { // 폴더가 없으면
            path1.mkdir();// 폴더경로를 생성
        }

        /*첨부 파일 확장자 구함*/
        int index=fileName.lastIndexOf(".");//마침표 위치 번호를 구함
        String fileExtension=fileName.substring(index+1);//마침표 이후부터 마지막 문자까지 구함.첨부파일 확장자를 구함
        String refileName="thumnail."+ fileExtension;//새로운 이진파일명 저장
        String fileDBName="/"+refileName;//디비에 저장될 레코드값
        UpFile.renameTo(new File(homedir+"/"+refileName));//바뀌어진 이진파일로 업로드

        testVO.setThumnail(fileDBName);
        testService.insertImage(testVO);

        return "redirect:/content";
    }

}
