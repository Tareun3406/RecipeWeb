package com.recipe.dao;

import com.recipe.vo.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void insertReply(ReplyVO r) {
        sqlSession.insert("reply_in", r);
    }

    @Override
    public List<ReplyVO> getReplyList(int post_no) {
        return sqlSession.selectList("reply_getList" ,post_no);
    }
}
