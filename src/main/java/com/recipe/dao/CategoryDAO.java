package com.recipe.dao;

import com.recipe.vo.categoryVO;

import java.util.List;

public interface CategoryDAO {

    int getListCount(categoryVO b);

    List<categoryVO> getcategoryList(categoryVO b);
}
