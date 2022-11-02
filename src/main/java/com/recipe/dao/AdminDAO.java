package com.recipe.dao;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;

import java.util.List;

public interface AdminDAO {

    List<CategoryVO> readRecipeList();

    List<CommuVO> readCommuList();

    List<MemberDTO> getMemberList(MemberDTO dto);

    MemberDTO getMemberInfo(String userid);

    void updateMember(MemberDTO member);

    int getMemberListCount(String search);

    void deleteMember(String userid);

}
