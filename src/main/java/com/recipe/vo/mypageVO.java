package com.recipe.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class mypageVO {


    //member테이블 (유저)
    private String userid; //아이디
    private String userpw; //비번
    private String nickname; //닉네임

    //구독테이블 불러오기
    private List<subscribeVO> subList; //구독테이블

}
