package com.recipe.service;

import com.recipe.vo.CategoryVO;

import java.util.List;

public interface HomeService {
    List<CategoryVO> getRecipeRankedList();
}
