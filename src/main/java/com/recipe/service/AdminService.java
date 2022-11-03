package com.recipe.service;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;

import java.util.List;

public interface AdminService {

    List<CategoryVO> getRecipeList(String page, String search, int listNum);

    int readRecipeListCount(String search, int listNum);

    List<CommuVO> getCommuList(String page, String search, int pageList);

    int getComuListCount(String search, int listNum);

    List<MemberDTO> getMemberList(String search, String page, int listNum);

    int getMemberListCount(String search, int listNum);

    MemberDTO getMemberInfo(String userid);

    void memberUpdate(MemberDTO member);

    void deleteMember(String userid);
}
