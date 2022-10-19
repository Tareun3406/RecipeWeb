package com.recipe.service;

import com.recipe.dao.CategoryDAO;
import com.recipe.vo.categoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;


    @Override
    public int getListCount(categoryVO b) {
        return this.categoryDAO.getListCount(b);
    }

    @Override
    public List<categoryVO> getcategoryList(categoryVO b) {
        return this.categoryDAO.getcategoryList(b);
    }
}
