package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageVO {

    private String sender; //보낸사람
    private String receiver; //받은사람
    private String message; //메세지내용
    private String senddate; //보낸날짜
    private int isread; //1,2로 읽음 확인 할 객체 1은 안읽음

    private String sender2; //보낸사람
    private String receiver2; //받은사람
    private String message2; //메세지내용
    private String senddate2; //보낸날짜
    private int isread2;

    private String snickname;
    private String rnickname;

}
