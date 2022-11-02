package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Setter
@Getter
@ToString
public class RankingVO {

    private String post_no;
    private String title;
    private int hit;
    private Date regdate;
    private Date updatedate;
    private String thumnail;
    private String ingredient;
    private int bookmark;
    private String post_tag;
    private String tip;
    private String writer;

    //검색어
    private String find_name;

    //페이징 관련변수
    private int startrow; //시작행 번호
    private int endrow; //끝행번호

    private String nickname; //member테이블의 닉네임

    private String score; //댓글에 점수
    
    private String find_date; //검색날짜에 따른 값저장용
}
