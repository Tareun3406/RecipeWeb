package com.recipe.dao;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;

import java.util.List;

public interface HomeDAO{
    List<CategoryVO> getRecipeRankedList();

    List<CategoryVO> getBookmarkRecipeList();

    List<CategoryVO> getRecentRecipeList();

    List<CommuVO> getRecentCommuList();

    List<MemberDTO> getChefRankedList();
}
