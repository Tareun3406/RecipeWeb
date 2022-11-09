package com.recipe.service;

import com.recipe.dao.HomeDAO;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDAO homeDAO;

    @Override
    public List<CategoryVO> getRecipeRankedList() {
        List<CategoryVO> recipeList = homeDAO.getRecipeRankedList();

        List<CategoryVO> ans = new ArrayList<>();
        for (CategoryVO recipe : recipeList) {
            String ingredientListStr = recipe.getIngredient();
            String[] ingredientArr = ingredientListStr.split(",");
            List<String> ingrList = new ArrayList<>();
            for (int i = 0; i < 11; i++) {
                if (i < ingredientArr.length) {
                    if(i==10 && ingredientArr.length>11) ingrList.add("&#8942;");
                    else ingrList.add(ingredientArr[i]);
                }
            }
            recipe.setIngredientList(ingrList);
            ans.add(recipe);
        }

        return ans;
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
