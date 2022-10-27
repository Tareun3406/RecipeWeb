package com.recipe.service;

import com.recipe.dao.CategoryDAO;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;


    @Override
    public int getListCount(CategoryVO b) {
        return this.categoryDAO.getListCount(b);
    }

    @Override
    public List<CategoryVO> getcategoryList(CategoryVO b) {
        return this.categoryDAO.getcategoryList(b);
    }

    @Override
    public List<CategoryVO> getnickname(CategoryVO recipe) {
        return this.categoryDAO.getnickname(recipe);

    }
}
