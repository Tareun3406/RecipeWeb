package com.recipe.dao;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.MemberVO;

import java.util.List;

public interface CategoryDAO {

    int getListCount(CategoryVO b);

    List<CategoryVO> getcategoryList(CategoryVO b);

    List<CategoryVO> getnickname(CategoryVO recipe);

    List<CategoryVO> getscore(CategoryVO recipe);
}
