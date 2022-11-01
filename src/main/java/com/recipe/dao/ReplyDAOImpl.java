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
        sqlSession.insert("insert_reply", r);
    }

    @Override
    public List<ReplyVO> getReply(int post_no) {
        return sqlSession.selectList("reply_getList", post_no);
    }

    @Override
    public void deleteReply(ReplyVO replyVO) {
        sqlSession.delete("delete_reply", replyVO);
    }

    @Override
    public int getReplyState(ReplyVO replyVO) {
        return sqlSession.selectOne("getReplyState", replyVO);
    }

}
