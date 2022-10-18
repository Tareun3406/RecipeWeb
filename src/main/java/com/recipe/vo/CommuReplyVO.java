package com.recipe.vo;

import lombok.Data;

@Data
public class CommuReplyVO {
	//되도록이면 코드라인을 줄이기 위해서 (reply.xml) tbl_reply테이블의 컬럼 명과 빈클래스 변수명을 같게한다.
		private int reply_no;//댓글번호(댓글수정, 삭제)
		private int comu_no;//외래키 설정(게시판 번호값만 저장)
		private String reviewer;//댓글 작성자,
		private String content;//댓글 내용
		private String regdate;//등록날짜

}
