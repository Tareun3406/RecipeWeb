package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ReplyVO {

    private int post_no;
    private int re_no;
    private String reviewer;
    private String content;
    private int score;
    private String regdate;
    private String updatedate;
    private String reviewernickname;

}
