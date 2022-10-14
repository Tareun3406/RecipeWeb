package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommuVO {

	private int comm_no;
	private String comm_name;
	private String comm_title;
	private String comm_pwd;
	private String comm_cont;
	private String comm_file;
	private int comm_hit;
	private int comm_ref;//글 그룹 번호=>원본글과 답변글을 묶어주는 기능
	private int comm_step;//원본글이면 0,첫번째 답변글이면1,두번째답변글이면 2 결국 원본글과
	//답변글을 구분하는 번호값이면서 몇번째 답변글인가를 알려준다.
	private int comm_level;//답변글 정렬 순서
	private String comm_date;

	//페이징 관련변수
	private int startrow;//시작행 번호
	private int endrow;//끝행 번호
	
	//검색 필드와 검색어
	private String find_field;//검색필드
	private String find_name;//검색어
	
}
