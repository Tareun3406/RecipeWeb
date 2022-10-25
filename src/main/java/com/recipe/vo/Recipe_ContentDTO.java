package com.recipe.vo;

import lombok.Getter;


@Getter
public class Recipe_ContentDTO {

	private int Post_no;
	private int Step;
	private String Image;
	private String Manual;
	
	
	
	public Recipe_ContentDTO(String Image,String Manual,int Step,int Post_no){
		
		this.Post_no=Post_no;
		this.Step=Step;
		this.Image=Image;
		this.Manual=Manual;
		

	}
}
