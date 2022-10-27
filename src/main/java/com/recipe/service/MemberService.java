package com.recipe.service;

import com.recipe.vo.MemberDTO;

import java.util.List;


public interface MemberService {

    void insertMemberUser(MemberDTO vo);


    List<MemberDTO> findIdList(String email);

    MemberDTO idCheck(String id);

    int changePwSend(MemberDTO member);
}
