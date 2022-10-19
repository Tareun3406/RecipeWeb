package com.recipe.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class mypageVO {


    private String id; //아이디
    private String pw; //비번
    private String name; //닉네임
    private String subscript; //구독
    private String bookmark; //즐겨찾기

}
