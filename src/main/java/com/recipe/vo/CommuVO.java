package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommuVO {
	private int comu_no;//글번호
	private String title;//글제목
	private String content;//글내용
	private String writer;//글쓴이
	private int category;//카테고리 10,11
	private String regdate;//작성 날짜

	//페이징 관련변수
	private int startrow;//시작행 번호
	private int endrow;//끝행 번호
	
	//검색 필드와 검색어
	private String find_field;//검색필드
	private String find_name;//검색어
	
}
