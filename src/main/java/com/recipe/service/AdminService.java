package com.recipe.service;

import com.recipe.vo.MemberDTO;

import java.util.List;

public interface AdminService {


    List<MemberDTO> getMemberList();

    MemberDTO getMemberInfo(String userid);

    void memberUpdate(MemberDTO member);
}
