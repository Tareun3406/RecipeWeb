package com.recipe.dao;

import com.recipe.vo.PostVO;
import com.recipe.vo.Recipe_PostDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<PostVO> getPost(int post_no) {
        return sqlSession.selectList("post_getList", post_no);
    }

    @Override
    public void updateHit(int post_no) {
        sqlSession.update("post_upHit", post_no);
    }

    @Override
    public void insertRp(Recipe_PostDTO rpd) {
        sqlSession.insert("rp_in",rpd);
    }
}
