package com.recipe.service;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.MemberVO;

import java.util.List;

public interface CategoryService {

    int getListCount(CategoryVO b); //게시글 갯수 불러오는

    List<CategoryVO> getcategoryList(CategoryVO b); // 게시글 내용 불러오는

}
