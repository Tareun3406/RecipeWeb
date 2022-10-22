package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.service.CommuReplyService;
import com.recipe.vo.CommuReplyVO;

@RestController
public class ReplyController {
	
	@Autowired
	CommuReplyService commuReplyService;
	
	//댓글등록
		@RequestMapping("/addreply") //post로 접근하는 매핑주소 처리
		public ResponseEntity<String> addReply(@RequestBody CommuReplyVO vo){
			//@RequestBody는 전송된 json데이터를 ReplyVO타입으로 변환해준다.
			ResponseEntity<String> entity = null;
			
			try {
				this.commuReplyService.insertReply(vo);//댓글저장
				entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);//댓글등록 성공시 SUCCESS문자가 반환되고,
				//Http 상태 코드 정상을 뜻하는 200(저장 성공한 경우)을 반환한다.
			}catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
				//예외 에러가 발생했을때 에러 메시지와 나쁜 상태 코드 문자열이 반환
			}
			return entity;
		}//addReply()
		
		//게시판 번호에 해당하는 댓글 목록
		@RequestMapping(value="/all/{comu_no}",produces="application/json")//get방식으로 접근하는 매핑주소를 처리
		public ResponseEntity<List<CommuReplyVO>> replyList(@PathVariable("comu_no") int comu_no){
			// /all/{bno}에서 {bno}에는 게시판 번호가 들어간다. 이번호값은 @PathVariable("comu_no")로 가져온다.
			ResponseEntity<List<CommuReplyVO>> entity = null;
			
			try {
				entity = new ResponseEntity<>(this.commuReplyService.listReply(comu_no),
						HttpStatus.OK);//게시파 번호에 대한 댓글 목록
			}catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return entity;
		}//replyList()
		
		
		
	
	
}
