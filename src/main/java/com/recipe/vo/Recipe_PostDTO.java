package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public class Recipe_PostDTO {

	private int post_no;   // 
	private String writer;   // 
	private String title;
	private String post_tag;
	private String ingredient;
	private String tip;
	private String thumnail;
	private int hit;
	private String recommend;
	private String regdate;
	private String update;
	
	public Recipe_PostDTO(int post_no,int hit,String writer,String title,String post_tag,String ingredient,String tip,String recommend
						  ,String regdate,String update) {
		this.post_no=post_no;
		this.hit=hit;
		this.writer=writer;
		this.title=title;
		this.post_tag=post_tag;
		this.ingredient=ingredient;
		this.tip=tip;
		this.recommend=recommend;
		this.regdate=regdate;
		this.update=update;
	}
}
