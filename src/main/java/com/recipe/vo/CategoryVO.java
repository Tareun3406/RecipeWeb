package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryVO {

    //recipe_post 테이블 변수
    private int post_no;
    private String title;
    private int hit;
    private String regdate;
    private String updatedate;
    private String thumnail;
    private String ingredient;
    private int recommend;
    private String post_tag;
    private String tip;

    //member테이블 (유저)
    private String userid;
    private String userpw;
    private String nickname;

    //구독 테이블
    private String subscriber_id;
    private String target_id;

    //검색필드와 검색어
    private String find_field;
    private String find_name;

    //페이징 관련변수
    private int startrow; //시작행 번호
    private int endrow; //끝행번호
}
