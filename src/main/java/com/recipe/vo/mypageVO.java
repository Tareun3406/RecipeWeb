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

    //구독 테이블
    private List<String> subscriber_id; //구독한 사람
    private List<String> target_id; //구독받은 사람

}
