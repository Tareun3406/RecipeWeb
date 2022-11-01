package com.recipe.dao;

import com.recipe.vo.ReplyVO;

import java.util.List;

public interface ReplyDAO {
    void insertReply(ReplyVO r);

    List<ReplyVO> getReply(int post_no);

    void deleteReply(ReplyVO replyVO);

    int getReplyState(ReplyVO replyVO);
}
