package com.recipe.service;

import com.recipe.dao.HomeDAO;
import com.recipe.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    private HomeDAO homeDAO;

    @Override
    public List<CategoryVO> getRecipeRankedList() {
        return homeDAO.getRecipeRankedList();
    }
}
