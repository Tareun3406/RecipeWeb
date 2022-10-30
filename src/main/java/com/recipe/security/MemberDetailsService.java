package com.recipe.security;

import com.recipe.dao.MemberDAO;
import com.recipe.security.domain.MemberUser;
import com.recipe.vo.MemberDTO;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.sql.RowSet;

public class MemberDetailsService implements UserDetailsService {

    public static RowSet loadUserByUsername;
    @Setter(onMethod_ = {@Autowired})
    public MemberDAO memberDAO;


    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        MemberDTO memberInfo = memberDAO.readMemberInfo(userid);

        return memberInfo == null ? null : new MemberUser(memberInfo);
    }


}
