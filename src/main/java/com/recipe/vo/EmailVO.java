package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailVO {

    private String senderMail;  // 발신 이메일 주소
    private String mailTitle;   // 메일 제목
    private String message;     // 메일 내용
    private String email;       // 받을 이메일

}
