package com.recipe.dao;

import com.recipe.vo.AuthVO;
import com.recipe.vo.MemberVO;

import java.util.List;

public interface MemberDAO {
    MemberVO readMemberInfo(String userid);

    void insertMember(MemberVO vo);

    void insertAuth(AuthVO auth);


    List<MemberVO> findIdList(String email);
}
