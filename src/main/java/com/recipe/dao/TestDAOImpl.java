package com.recipe.dao;

import com.recipe.vo.TestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOImpl implements TestDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int getPostNo() {
        return sqlSession.selectOne("getPostNo");
    }

    @Override
    public void insertImage(TestVO testVO) {
        sqlSession.insert("insertImage", testVO);
    }
}
