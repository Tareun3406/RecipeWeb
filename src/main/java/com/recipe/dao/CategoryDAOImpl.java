package com.recipe.dao;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public int getListCount(CategoryVO b) {
       return this.sqlSession.selectOne("cate_count",b);
    }

    @Override
    public List<CategoryVO> getcategoryList(CategoryVO b) {
       return this.sqlSession.selectList("cate_list",b);
    }

    @Override
    public List<CategoryVO> getnickname(CategoryVO recipe) {
       return this.sqlSession.selectList("nick_list",recipe);
    }

    @Override
    public List<CategoryVO> getscore(CategoryVO recipe) {
        return this.sqlSession.selectList("score_list",recipe);
    }
}
