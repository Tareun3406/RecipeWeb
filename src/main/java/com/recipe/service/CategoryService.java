package com.recipe.service;

import com.recipe.vo.categoryVO;

import java.util.List;

public interface CategoryService {

    int getListCount(categoryVO b);

    List<categoryVO> getcategoryList(categoryVO b);
}
