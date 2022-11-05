package com.recipe.service;

import com.recipe.dao.HomeDAO;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;
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

    @Override
    public List<CategoryVO> getBookmarkRecipeList() {
        return homeDAO.getBookmarkRecipeList();
    }

    @Override
    public List<CategoryVO> getRecentRecipeList() {
        return homeDAO.getRecentRecipeList();
    }

    @Override
    public List<CommuVO> getRecentCommuList() {
        return homeDAO.getRecentCommuList();
    }

    @Override
    public List<MemberDTO> getChefRankedList() {
        return homeDAO.getChefRankedList();
    }
}
