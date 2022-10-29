package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class CategoryVO {

    //recipe_post 테이블 변수
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

    //검색필드와 검색어
    private String find_field;
    private String find_name;

    //페이징 관련변수
    private int startrow; //시작행 번호
    private int endrow; //끝행번호

    private String nickname; //member테이블의 닉네임
    
    private String score; //댓글에 점수
}
