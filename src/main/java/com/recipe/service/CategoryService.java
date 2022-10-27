package com.recipe.service;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.MemberVO;

import java.util.List;

public interface CategoryService {

    int getListCount(CategoryVO b);

    List<CategoryVO> getcategoryList(CategoryVO b);

    List<CategoryVO> getnickname(CategoryVO recipe);

}
