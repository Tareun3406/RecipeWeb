package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class categoryVO {

    private int post_no;
    private String title;
    private String writer;
    private int hit;
    private String thumnail;
    private String cont;

    private int bbs_no;
    private String bbs_name;
    private String bbs_title;
    private String bbs_pwd;
    private String bbs_cont;
    private String bbs_file;
    private int bbs_ref;
    private int bbs_step;
    private int bbs_level;
    private String bbs_date;

    //검색필드와 검색어
    private String find_field;
    private String find_name;

    //페이징 관련변수
    private int startrow; //시작행 번호
    private int endrow; //끝행번호
}
