package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecipereplyVO {

    private String post_no;
    private int re_no;
    private String content;
    private int score;
    private String regdate;
    private String updatedate;
    private String reviewer;
}
