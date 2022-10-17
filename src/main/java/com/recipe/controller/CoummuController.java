package com.recipe.controller;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.recipe.service.CommuService;
import com.recipe.vo.CommuVO;

@Controller
public class CoummuController {
	
	@Autowired
	private CommuService commuService;
	
	//자료실 글쓰기 폼
		@GetMapping("/commu_write")//get방식으로 접근하는 매핑주소를 처리,bbs_write라는 매핑주소등록
		//등록
		public ModelAndView commu_write(HttpServletRequest request) {
			int page=1;
			if(request.getParameter("page")!= null) {
				page = Integer.parseInt(request.getParameter("page"));
				//get으로 전달된 쪽번호를 전달받아서 정수 숫자로 변경해서 저장(책갈피 기능)
			}
			ModelAndView wm = new ModelAndView();
			wm.addObject("page",page);//페이지 키값쌍으로 저장
			wm.setViewName("./community/commu_write");//뷰리졸브 경로 설정. 
			//즉 뷰페이지 경로는 /WEB-INF/views/bbs/bbs_write.jsp
			return wm;
		}//자료실 글쓰기 폼=>bbs_write()메서드
	
		
		//자료실 저장
		@RequestMapping(value="/commu_write_ok",method=RequestMethod.POST)
		//POST방식으로 접근하는 매핑주소 처리.bbs_write_ok 매핑주소 등록
		public String bbs_write_ok(CommuVO c,HttpServletRequest request) throws Exception {
			//이진파일 업로드 서버경로지정
			String saveFolder = request.getRealPath("/resources/upload");
			System.out.println(saveFolder);//이진 파일 업로드 되는 서버경로를 출력해본다.
			//C:\\20220607\\20220607Spring_work\\.metadata\\.plugins\\
			//org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project\\resources\\upload
			//이클립스 메이븐 폴더 가상경로가 아닌 톰켓 was서버에 의해서 변경된 실제 톰켓 프로젝트 경로가 반환
			
			int fileSize = 5*1024*1024;//이진파일 업로드 최대크기(5M)
			MultipartRequest multi = null;//cos-05Nov2002.jar 외부 라이브러리에 있는 api를 사용함
			//첨부된 이진 파일을 가져오는 api이다.
			
			multi = new MultipartRequest(request, saveFolder,fileSize,"UTF-8");//throws선택
			
			//글쓴이 부터 가져오기
			String comm_name = multi.getParameter("comm_name");
			String comm_title = multi.getParameter("comm_title");//글제목 가져오기
			String comm_pwd = multi.getParameter("comm_pwd");//비번 가져오기
			String comm_cont = multi.getParameter("comm_cont");//글내용 가져오기
			
			File upFile = multi.getFile("comm_file");//첨부된 파일을 가져온다.
			
			if(upFile != null) {//첨부된 파일이 있는 경우
				String fileName = upFile.getName();//첨부된 파일명을 구함
				Calendar cal = Calendar.getInstance();//칼렌더는 추상클래스로 
				//new로 객체생성을 못한다. 하지만 년원일시분초 값을 반환할때 사용
				int year = cal.get(Calendar.YEAR);//년도값
				int month = cal.get(Calendar.MONTH)+1;//월값,+1을한 이유는 1월이 0으로
				//반환 되기 때문이다.
				int date = cal.get(Calendar.DATE);//일값
				
				String homedir = saveFolder+"/"+year+"-"+month+"-"+date;//오늘날짜 폴더
				//경로를 저장
				File path01 = new File(homedir);
				
				if(!(path01.exists())) {//오늘날짜 폴더경로가 없다면
					path01.mkdir();//오늘 날짜 폴더를 생성
				}
				
				Random r = new Random(); //난수(정해지지 않은 임의의 숫자)를 발생 시키는 클래스
				int random = r.nextInt(100000000);//0이상 1억 미만의 임의의 정수 숫자 난수 발생
				
				//첨부파일 확장자를 구함
				int index=fileName.lastIndexOf(".");// .를 맨오른쪽 부터 찾아서 가장 먼저 
				//나오는 .위치 번호를 맨 왼쪽 부터 카운트 해서 구함 첫문자는 0부터 시작
				String fileExtendsion = fileName.substring(index+1);//첨부파일에서
				// .이후부터 마지막 문자까지 구함, 첨부 파일 확장자를구함
				String refileName = "commu"+year+month+date+random+"."+fileExtendsion;
				//bbs년원일 1억 미만 랜덤 숫자.확장자 즉 새로운 첨부파일명을 구함
				String fileDBName="/"+year+"-"+month+"-"+date+"/"+refileName;
				//데이터베이스에 저장될 레코드값
				
				upFile.renameTo(new File(homedir+"/"+refileName));//변경된 이진파일로
				//생성된 폴더 경로에 실제 업로드한다.
				
				c.setComm_file(fileDBName);
			}else {//첨부파일이 없는 경우
				String fileDBName="";
				c.setComm_file(fileDBName);
			}
			
			c.setComm_name(comm_name); c.setComm_title(comm_title);
			c.setComm_pwd(comm_pwd); c.setComm_cont(comm_cont);
			
			this.commuService.insertCommu(c);//자료실 저장
			
			return "redirect:/commu_list";//새로운 목록보기 매핑주소로 이동		
		}//bbs_write_ok()
		
		
		
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
		      
		      listM.addAttribute("blist",clist);
		      listM.addAttribute("page",page);
		      listM.addAttribute("startpage",startpage);
		      listM.addAttribute("endpage",endpage);
		      listM.addAttribute("maxpage",maxpage);
		      listM.addAttribute("listcount",totalCount);
		      listM.addAttribute("find_field",find_field);//검색 필드
		      listM.addAttribute("find_name",find_name);//검색어
		      
		   
		      return "community/commu_list";//뷰페이지 경로가/WEB-INF/views/bbs/bbs_list.jsp
		}//bbs_list()
		
		
		
		
}
