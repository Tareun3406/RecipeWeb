package com.recipe.security.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.recipe.vo.MemberDTO;

import java.util.Collection;

public class MemberUser extends User {

    public MemberUser(MemberDTO dto){
        super(dto.getUserid(), dto.getUserpw(), dto.getAuthList());
    }

    public MemberUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
