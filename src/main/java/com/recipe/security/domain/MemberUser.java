package com.recipe.security.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.recipe.vo.MemberVO;

import java.util.Collection;
import java.util.List;

public class MemberUser extends User {

    public MemberUser(MemberVO vo){
        super(vo.getUserid(), vo.getUserpw(), vo.getAuthList());
    }

    public MemberUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
