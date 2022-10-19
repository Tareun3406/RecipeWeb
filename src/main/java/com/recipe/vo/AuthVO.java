package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class AuthVO implements GrantedAuthority {


    private String userid;
    private String auth;

    @Override
    public String getAuthority() {
        return auth;
    }

    // 권한 상수
    public static final String AUTH_ADMIN = "ADMIN";
    public static final String AUTH_USER = "USER";
}
