package com.recipe.service;

import com.recipe.vo.MemberDTO;

import java.util.List;

public interface AdminService {


    List<MemberDTO> getMemberList(String page, int listNum);

    int getMemberListCount(int listNum);

    MemberDTO getMemberInfo(String userid);

    void memberUpdate(MemberDTO member);


}
