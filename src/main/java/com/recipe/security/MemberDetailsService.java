package com.recipe.security;

import com.recipe.dao.MemberDAO;
import com.recipe.security.domain.MemberUser;
import com.recipe.vo.AuthDTO;
import com.recipe.vo.MemberDTO;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.RowSet;
import java.util.ArrayList;

public class MemberDetailsService implements UserDetailsService {

    public static RowSet loadUserByUsername;

    @Setter(onMethod_ = {@Autowired})
    public MemberDAO memberDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        MemberDTO memberInfo = memberDAO.readMemberInfo(userid);

        if (memberInfo == null) {
            String ran = String.valueOf(Math.random());
            String encRanPw = encoder.encode(ran);
            return new MemberUser("none",encRanPw, new ArrayList<AuthDTO>());
        }

        return new MemberUser(memberInfo);
    }


}
