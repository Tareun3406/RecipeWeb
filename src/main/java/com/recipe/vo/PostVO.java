package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PostVO {

    private int post_no;
    private String title;
    private int hit;
    private String regdate;
    private String updatedate;
    private String thumnail;
    private String ingredient;
    private int bookmark;
    private String post_tag;
    private String tip;
    private String writer;

    // 레시피와 작성자 정보 리스트로 가져오기
    private List<ContentVO> content;
    private List<MemberDTO> member;

}
