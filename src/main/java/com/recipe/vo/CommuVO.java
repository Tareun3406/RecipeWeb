package com.recipe.vo;

import lombok.Data;

@Data
public class CommuVO {
	private int comu_no;            // 게시글 번호
    private String title;       // 게시글 제목
    private String content;     // 게시글 내용
    private String writer;      // 게시글 작성자
    private String regdate;       // 게시글 작성일자 
    private int viewcnt;        // 게시글 조회수
    
  //페이징 관련변수
  	private int startrow;//시작행 번호
  	private int endrow;//끝행 번호
  	
  	//검색 필드와 검색어
  	private String find_field;//검색필드
  	private String find_name;//검색어
   
}
