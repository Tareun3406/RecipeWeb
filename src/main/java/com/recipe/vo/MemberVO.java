package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Getter
@Setter
@ToString
public class MemberVO {

    //member 테이블 정보
    private String id;
    private String pw;
    private String name;

    // 권한 정보
    private List<AuthVO> authList;


    // 기타 정보

    public void addAuthList(AuthVO authVO){
        authList.add(authVO);
    }
}
