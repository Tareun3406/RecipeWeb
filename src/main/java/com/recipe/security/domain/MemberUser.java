package com.recipe.security.domain;

import com.recipe.vo.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class MemberUser extends User {

    private MemberVO member;
    public MemberUser(MemberVO vo){
        super(vo.getId(), vo.getPw(), vo.getAuthList());
        member=vo;
    }

    public MemberUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
