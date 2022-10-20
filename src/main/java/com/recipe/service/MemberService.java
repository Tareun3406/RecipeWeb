package com.recipe.service;

import com.recipe.vo.MemberVO;

import java.util.List;


public interface MemberService {

    void insertMemberUser(MemberVO vo);


    List<MemberVO> findIdList(String email);

    MemberVO idCheck(String id);
}
