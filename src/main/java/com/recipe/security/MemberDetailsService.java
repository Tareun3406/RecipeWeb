package com.recipe.security;

import com.recipe.dao.MemberDAO;
import com.recipe.security.domain.MemberUser;
import com.recipe.vo.MemberVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberDetailsService implements UserDetailsService {

    @Setter(onMethod_ = {@Autowired})
    public MemberDAO memberDAO;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println(id);
        MemberVO memberInfo = memberDAO.readMemberInfo(id);

        return memberInfo == null ? null : new MemberUser(memberInfo);
    }
}
