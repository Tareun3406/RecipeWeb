package com.recipe.dao;

import com.recipe.vo.ContentVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentDAOImpl implements ContentDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<ContentVO> getContentList(int post_no) {
        return sqlSession.selectList("content_getList", post_no);
    }
}
