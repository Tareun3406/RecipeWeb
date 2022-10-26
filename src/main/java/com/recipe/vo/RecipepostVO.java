package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecipepostVO {

    private String post_no;
    private String title;
    private int hit;
    private String regdate;
    private String updatedate;
    private String thumnail;
    private String ingredient;
    private int recommend;
    private String post_tag;
    private String tip;
    private String writer;
}
