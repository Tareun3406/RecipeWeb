package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MypageVO {


    //member테이블 (유저)
    private String userid; //아이디
    private String userpw; //비번
    private String nickname; //닉네임
    private String email; //이메일

    //구독테이블 불러오기
    private List<SubscribeVO> subList; //구독테이블
    
    //북마크 테이블 불러오기
    private List<BookmarkVO> bookList; //북마크테이블

}
