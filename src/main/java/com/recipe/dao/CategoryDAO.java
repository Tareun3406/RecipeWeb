package com.recipe.dao;

import com.recipe.vo.CategoryVO;

import java.util.List;

public interface CategoryDAO {

    int getListCount(CategoryVO b);

    List<CategoryVO> getcategoryList(CategoryVO b);

}
