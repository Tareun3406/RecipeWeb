package com.recipe.service;

import com.recipe.vo.MemberDTO;

import java.util.List;

public interface AdminService {


    List<MemberDTO> getMemberList(String search, String page, int listNum);

    int getMemberListCount(String search, int listNum);

    MemberDTO getMemberInfo(String userid);

    void memberUpdate(MemberDTO member);


}
