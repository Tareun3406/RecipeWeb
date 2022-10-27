package com.recipe.dao;

import com.recipe.vo.AuthDTO;
import com.recipe.vo.MemberDTO;

import java.util.List;

public interface MemberDAO {
    MemberDTO readMemberInfo(String userid);

    void insertMember(MemberDTO vo);

    void insertAuth(AuthDTO auth);


    List<MemberDTO> findIdList(String email);

    MemberDTO checkId(String id);

    int updateFindPw(MemberDTO member);
}
