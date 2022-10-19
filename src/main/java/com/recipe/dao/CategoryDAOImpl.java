package com.recipe.dao;

import com.recipe.vo.categoryVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public int getListCount(categoryVO b) {
       return this.sqlSession.selectOne("cate_count",b);
    }

    @Override
    public List<categoryVO> getcategoryList(categoryVO b) {
       return this.sqlSession.selectList("cate_list",b);
    }
}
