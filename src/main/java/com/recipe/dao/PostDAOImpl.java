package com.recipe.dao;

import com.recipe.vo.PostVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public PostVO getPost(int post_no) {
        return sqlSession.selectOne("post_getList", post_no);
    }
}
