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
    

   
}
