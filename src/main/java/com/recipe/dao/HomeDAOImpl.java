package com.recipe.dao;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;
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

    @Override
    public List<CategoryVO> getBookmarkRecipeList() {
        return sqlSession.selectList("recipeBookmarked");
    }

    @Override
    public List<CategoryVO> getRecentRecipeList() {
        return sqlSession.selectList("recipeRecent");
    }

    @Override
    public List<CommuVO> getRecentCommuList() {
        return sqlSession.selectList("commuRecent");
    }

    @Override
    public List<MemberDTO> getChefRankedList() {
        return sqlSession.selectList("chefRanked");
    }
}
