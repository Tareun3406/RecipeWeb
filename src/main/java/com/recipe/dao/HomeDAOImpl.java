package com.recipe.dao;

import com.recipe.vo.CategoryVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeDAOImpl implements HomeDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CategoryVO> getRecipeRankedList() {
        return sqlSession.selectList("recipeRanked");
    }
}
