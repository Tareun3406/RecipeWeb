package com.recipe.dao;

import com.recipe.vo.CategoryVO;

import java.util.List;

public interface HomeDAO{
    List<CategoryVO> getRecipeRankedList();
}
