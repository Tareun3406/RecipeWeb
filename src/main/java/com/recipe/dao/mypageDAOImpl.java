package com.recipe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class mypageDAOImpl {

    @Autowired
    private SqlSession sqlSession;


}
